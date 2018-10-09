package com.joy.widasemariam.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.joy.widasemariam.Constants;
import com.joy.widasemariam.R;
import com.joy.widasemariam.WithAboutMenu;
import com.joy.widasemariam.WithHelpMenu;
import com.joy.widasemariam.WithPrefsMenu;
import com.joy.widasemariam.model.Language;

public class ChooseLanguage extends AbstractActivity implements WithAboutMenu, WithHelpMenu, WithPrefsMenu {
	
	private Typeface TYPE_FACE_NYALA; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		
		final SharedPreferences getPrefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		
		String defaultLanguageSelected = getPrefs.getString("languageListKey", Constants.ACTIVITY_PROPERTY_NO_LANGUAGE_SELECTED);
		
		// If default language is selected in the Preferences Menu
		if(!defaultLanguageSelected.contentEquals(Constants.ACTIVITY_PROPERTY_NO_LANGUAGE_SELECTED))
		{
			goToHome(Language.valueOf(defaultLanguageSelected));
			
		} else {

			setContentView(R.layout.choose_language);
			
			TYPE_FACE_NYALA = Typeface.createFromAsset(getAssets(), Constants.FONT_NYALA_FILE_LOCATION);
			
			initializeView();
		}
	}

	@Override
	public void onBackPressed() { this.finish(); }
	
	private void initializeView() {
		
		final TextView chooseLanguageListLabel = (TextView) findViewById(R.id.choose_language_list_label);
		
		chooseLanguageListLabel.setText(R.string.choose_language_list_label);
		
		chooseLanguageListLabel.setTypeface(TYPE_FACE_NYALA);
		
		
		final Button chooseLanguageAmarignaButton = (Button) findViewById(R.id.choose_language_button_am);
		
		chooseLanguageAmarignaButton.setText(R.string.choose_language_button_am);
		
		chooseLanguageAmarignaButton.setTypeface(TYPE_FACE_NYALA);
		
		
		chooseLanguageAmarignaButton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				
				goToHome(Language.AMHARIGNA);
				
			}
		});
		
		
		final Button chooseLanguageGeezButton = (Button) findViewById(R.id.choose_language_button_ge);
		
		chooseLanguageGeezButton.setText(R.string.choose_language_button_ge);
		
		chooseLanguageGeezButton.setTypeface(TYPE_FACE_NYALA);
		
		
		chooseLanguageGeezButton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				
				goToHome(Language.GEEZ);
				
			}
		});

		
		final Button chooseLanguageEnglishButton = (Button) findViewById(R.id.choose_language_button_en);
		
		chooseLanguageEnglishButton.setText(R.string.choose_language_button_en);
		
		
		chooseLanguageEnglishButton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				
				goToHome(Language.ENGLISH);
				
			}
		});
	}

	protected void goToHome(Language selectedLanguage) {
		
		final Intent intent = new Intent(ChooseLanguage.this, Home.class);
		
		intent.putExtra(Constants.ACTIVITY_PROPERTY_SELECTED_LANGUAGE, selectedLanguage.name());
		
		startActivity(intent);
		
	}
	
}
