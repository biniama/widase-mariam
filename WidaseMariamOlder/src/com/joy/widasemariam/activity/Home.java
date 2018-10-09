package com.joy.widasemariam.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
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
import com.joy.widasemariam.model.PartOfBook;

public class Home extends AbstractActivity implements WithAboutMenu, WithHelpMenu, WithPrefsMenu {

	private String selectedLanguage;
	
	private Typeface TYPE_FACE_NYALA; 
	
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		
		super.onSaveInstanceState(outState);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.home);
		
		TYPE_FACE_NYALA = Typeface.createFromAsset(getAssets(), Constants.FONT_NYALA_FILE_LOCATION);
		
		final Bundle extras = getIntent().getExtras();
		
		if(extras.containsKey(Constants.ACTIVITY_PROPERTY_SELECTED_LANGUAGE)) {
			
			selectedLanguage = extras.getString(Constants.ACTIVITY_PROPERTY_SELECTED_LANGUAGE);
		}
		
		setLocale();
		
		initializeHomeView();
	}

	private void setLocale() {
		
		if(null != selectedLanguage) {
			
			if(selectedLanguage.equals(Language.AMHARIGNA.name())) {
				
				changeLocale(Constants.ACTIVITY_PROPERTY_LOCALE_AMHARIC);
				
			} else if(selectedLanguage.equals(Language.GEEZ.name())) {
				
				changeLocale(Constants.ACTIVITY_PROPERTY_LOCALE_GEEZ);
			
			} else if(selectedLanguage.equals(Language.ENGLISH.name())) {
				
				changeLocale(Constants.ACTIVITY_PROPERTY_LOCALE_ENGLISH);
			}	
		}	
	}
	
	private void initializeHomeView() {
		
//		if(!isProcessingDialogShowing())
//			showProcessingDialog(getResources().getString(Integer.parseInt(Constants.MESSAGE_R_STRING_PREFIX + "general_loading_msg_" + selectedLanguage.toLowerCase().substring(0, 2))));
		
		final TextView chooseThePartYouWantToRead = (TextView) findViewById(R.id.home_part_of_book_list_label);
		
		if(!selectedLanguage.equals(Language.ENGLISH.name())) 
			chooseThePartYouWantToRead.setTypeface(TYPE_FACE_NYALA);
		
		chooseThePartYouWantToRead.setText(R.string.home_part_of_book_list_label);
		
		final Button choosePartZeweterButton = (Button) findViewById(R.id.home_day_zeweter_button);
		
		if(!selectedLanguage.equals(Language.ENGLISH.name())) 
			choosePartZeweterButton.setTypeface(TYPE_FACE_NYALA);
		
		choosePartZeweterButton.setText(R.string.home_day_zeweter_button);
		
		choosePartZeweterButton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				
				goToReader(PartOfBook.ZEWETER);
				
			}
		});
		
		
		final Button choosePartMondayButton = (Button) findViewById(R.id.home_day_monday_button);
		
		if(!selectedLanguage.equals(Language.ENGLISH.name())) 
			choosePartMondayButton.setTypeface(TYPE_FACE_NYALA);
		
		choosePartMondayButton.setText(R.string.home_day_monday_button);
		
		choosePartMondayButton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				
				goToReader(PartOfBook.MONDAY);
				
			}
		});
		
		final Button choosePartTuesdayButton = (Button) findViewById(R.id.home_day_tuesday_button);
		
		if(!selectedLanguage.equals(Language.ENGLISH.name())) 
			choosePartTuesdayButton.setTypeface(TYPE_FACE_NYALA);
		
		choosePartTuesdayButton.setText(R.string.home_day_tuesday_button);
		
		choosePartTuesdayButton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				
				goToReader(PartOfBook.TUESDAY);
				
			}
		});
		
		final Button choosePartWednesdayButton = (Button) findViewById(R.id.home_day_wednesday_button);
		
		if(!selectedLanguage.equals(Language.ENGLISH.name())) 
			choosePartWednesdayButton.setTypeface(TYPE_FACE_NYALA);
		
		choosePartWednesdayButton.setText(R.string.home_day_wednesday_button);
		
		choosePartWednesdayButton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				
				goToReader(PartOfBook.WEDNESDAY);
				
			}
		});
		
		final Button choosePartThursdayButton = (Button) findViewById(R.id.home_day_thursday_button);
		
		if(!selectedLanguage.equals(Language.ENGLISH.name())) 
			choosePartThursdayButton.setTypeface(TYPE_FACE_NYALA);
		
		choosePartThursdayButton.setText(R.string.home_day_thursday_button);
		
		choosePartThursdayButton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				
				goToReader(PartOfBook.THURSDAY);
				
			}
		});
		
		final Button choosePartFridayButton = (Button) findViewById(R.id.home_day_friday_button);
		
		if(!selectedLanguage.equals(Language.ENGLISH.name())) 
			choosePartFridayButton.setTypeface(TYPE_FACE_NYALA);
		
		choosePartFridayButton.setText(R.string.home_day_friday_button);
		
		choosePartFridayButton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				
				goToReader(PartOfBook.FRIDAY);
				
			}
		});
		
		final Button choosePartSaturdayButton = (Button) findViewById(R.id.home_day_saturday_button);
		
		if(!selectedLanguage.equals(Language.ENGLISH.name())) 
			choosePartSaturdayButton.setTypeface(TYPE_FACE_NYALA);
		
		choosePartSaturdayButton.setText(R.string.home_day_saturday_button);
		
		choosePartSaturdayButton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				
				goToReader(PartOfBook.SATURDAY);
				
			}
		});
		
		final Button choosePartSundayButton = (Button) findViewById(R.id.home_day_sunday_button);
		
		if(!selectedLanguage.equals(Language.ENGLISH.name())) 
			choosePartSundayButton.setTypeface(TYPE_FACE_NYALA);
		
		choosePartSundayButton.setText(R.string.home_day_sunday_button);
		
		choosePartSundayButton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				
				goToReader(PartOfBook.SUNDAY);
				
			}
		});
		
		final Button choosePartAnqetseBirhanButton = (Button) findViewById(R.id.home_day_anqetse_birhan_button);
		
		if(!selectedLanguage.equals(Language.ENGLISH.name())) 
			choosePartAnqetseBirhanButton.setTypeface(TYPE_FACE_NYALA);
		
		choosePartAnqetseBirhanButton.setText(R.string.home_day_anqetse_birhan_button);
		
		choosePartAnqetseBirhanButton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				
				goToReader(PartOfBook.ANQETSE_BIRHAN);
				
			}
		});
				
		final Button choosePartYiwedsewaMelaektButton = (Button) findViewById(R.id.home_day_yiwedsewa_melaekt_button);
		
		if(!selectedLanguage.equals(Language.ENGLISH.name())) 
			choosePartYiwedsewaMelaektButton.setTypeface(TYPE_FACE_NYALA);
		
		choosePartYiwedsewaMelaektButton.setText(R.string.home_day_yiwedsewa_melaekt_button);
		
		choosePartYiwedsewaMelaektButton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				
				goToReader(PartOfBook.YIWEDSEWA_MELAEKT);
				
			}
		});
		
		final Button choosePartMelkaMariamButton = (Button) findViewById(R.id.home_day_melka_mariam_button);
		
		if(!selectedLanguage.equals(Language.ENGLISH.name())) 
			choosePartMelkaMariamButton.setTypeface(TYPE_FACE_NYALA);
		
		choosePartMelkaMariamButton.setText(R.string.home_day_melka_mariam_button);
		
		choosePartMelkaMariamButton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				
				goToReader(PartOfBook.MELKA_MARIAM);
				
			}
		});
		
		final Button choosePartMelkaEyesusButton = (Button) findViewById(R.id.home_day_melka_eyesus_button);
		
		if(!selectedLanguage.equals(Language.ENGLISH.name())) 
			choosePartMelkaEyesusButton.setTypeface(TYPE_FACE_NYALA);
		
		choosePartMelkaEyesusButton.setText(R.string.home_day_melka_eyesus_button);
		
		choosePartMelkaEyesusButton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				
				goToReader(PartOfBook.MELKA_EYESUS);
				
			}
		});
		
		final Button choosePartMelkaEdomButton = (Button) findViewById(R.id.home_day_melka_edom_button);
		
		if(!selectedLanguage.equals(Language.ENGLISH.name())) 
			choosePartMelkaEdomButton.setTypeface(TYPE_FACE_NYALA);
		
		choosePartMelkaEdomButton.setText(R.string.home_day_melka_edom_button);
		
		choosePartMelkaEdomButton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				
				goToReader(PartOfBook.MELKA_EDOM);
				
			}
		});
		
		final Button goToChooseLanguageButton = (Button) findViewById(R.id.home_go_to_choose_language_button);
		
		if(!selectedLanguage.equals(Language.ENGLISH.name())) 
			goToChooseLanguageButton.setTypeface(TYPE_FACE_NYALA);
		
		goToChooseLanguageButton.setText(R.string.home_go_to_choose_language_button);
		
		goToChooseLanguageButton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				
				goToChooseLanguage(Home.this);
				
			}
		});
		
		hideProcessingDialog();
	}

	protected void goToReader(PartOfBook partOfBook) {
		
		final Intent intent = new Intent(Home.this, Reader.class);
		
		intent.putExtra(Constants.ACTIVITY_PROPERTY_SELECTED_LANGUAGE, selectedLanguage);
		
		intent.putExtra(Constants.ACTIVITY_PROPERTY_SELECTED_PART_OF_BOOK, partOfBook.name());
		
		startActivity(intent);
		
	}
	
}
