package com.joy.widasemariam.activity;

import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.TextView;

import com.joy.widasemariam.Constants;
import com.joy.widasemariam.R;
import com.joy.widasemariam.model.Language;
import com.joy.widasemariam.model.PartOfBook;

public class Reader extends AbstractActivity {

	private Typeface TYPE_FACE_NYALA; 
	
	//private Typeface TYPE_FACE_VISUAL_GEEZ;
	
	private String selectedPartOfBook;
	
	private String selectedLanguage;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.reader);
		
		TYPE_FACE_NYALA = Typeface.createFromAsset(getAssets(), Constants.FONT_NYALA_FILE_LOCATION);
		
		//TYPE_FACE_VISUAL_GEEZ = Typeface.createFromAsset(getAssets(), Constants.FONT_VISUAL_GEEZ_FILE_LOCATION);
		
		final Bundle extras = getIntent().getExtras();
		
		if(extras.containsKey(Constants.ACTIVITY_PROPERTY_SELECTED_LANGUAGE)) {
			
			selectedLanguage = extras.getString(Constants.ACTIVITY_PROPERTY_SELECTED_LANGUAGE);
		}
		
		if(extras.containsKey(Constants.ACTIVITY_PROPERTY_SELECTED_PART_OF_BOOK)) {
			
			selectedPartOfBook = extras.getString(Constants.ACTIVITY_PROPERTY_SELECTED_PART_OF_BOOK);
		}
		
		initializeHomeView();
	}

	private void initializeHomeView() {

		if(!isProcessingDialogShowing())
			showProcessingDialog(getResources().getString(R.string.general_loading_msg));
		
		
		// Get the preference set as default font size or use 18 font size
		final SharedPreferences getPrefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

		String fontSize = getPrefs.getString("fontSizeListKey", "18");
		
		TextView prayerHeader = (TextView) findViewById(R.id.reader_prayer_header_label);
		
		TextView prayer = (TextView) findViewById(R.id.reader_prayer_label);
		
		prayerHeader.setTextSize(Float.parseFloat(fontSize) + 4.0F);
		
		prayer.setTextSize(Float.parseFloat(fontSize));
		
		if (null != selectedLanguage) {
			if(!selectedLanguage.equals(Language.ENGLISH.name())) {
				
				prayerHeader.setTypeface(TYPE_FACE_NYALA);
		
				prayer.setTypeface(TYPE_FACE_NYALA);
				
			}
		}
		
		if(null != selectedPartOfBook) {

            if(selectedPartOfBook.equals(PartOfBook.ZEWETER.name())) {

                prayerHeader.setText(R.string.reader_prayer_daily_header_label);

                prayer.setText(R.string.reader_prayer_daily_label);
            }

            if(selectedPartOfBook.equals(PartOfBook.MONDAY.name())) {
				
				prayerHeader.setText(R.string.reader_prayer_monday_header_label);
				
				prayer.setText(R.string.reader_prayer_monday_label);
			}
			
			if(selectedPartOfBook.equals(PartOfBook.TUESDAY.name())) {
					
				prayerHeader.setText(R.string.reader_prayer_tuesday_header_label);
				
				prayer.setText(R.string.reader_prayer_tuesday_label);
			}
			
			if(selectedPartOfBook.equals(PartOfBook.WEDNESDAY.name())) {
				
				prayerHeader.setText(R.string.reader_prayer_wedensday_header_label);
				
				prayer.setText(R.string.reader_prayer_wedensday_label);
			}

			if(selectedPartOfBook.equals(PartOfBook.THURSDAY.name())) {
				
				prayerHeader.setText(R.string.reader_prayer_thursday_header_label);
				
				prayer.setText(R.string.reader_prayer_thursday_label);
			}
			
			if(selectedPartOfBook.equals(PartOfBook.FRIDAY.name())) {
				
				prayerHeader.setText(R.string.reader_prayer_friday_header_label);
				
				prayer.setText(R.string.reader_prayer_friday_label);
			}
			
			if(selectedPartOfBook.equals(PartOfBook.SATURDAY.name())) {
				
				prayerHeader.setText(R.string.reader_prayer_saturday_header_label);
				
				prayer.setText(R.string.reader_prayer_saturday_label);
			}
			
			if(selectedPartOfBook.equals(PartOfBook.SUNDAY.name())) {
				
				prayerHeader.setText(R.string.reader_prayer_sunday_header_label);
				
				prayer.setText(R.string.reader_prayer_sunday_label);
			}
			
			if(selectedPartOfBook.equals(PartOfBook.ANQETSE_BIRHAN.name())) {
				
				prayerHeader.setText(R.string.reader_prayer_anqetse_birhan_header_label);
				
				prayer.setText(R.string.reader_prayer_anqetse_birhan_label);
			}
			
			if(selectedPartOfBook.equals(PartOfBook.YIWEDSEWA_MELAEKT.name())) {
				
				prayerHeader.setText(R.string.reader_prayer_yiwedswea_melaekt_header_label);
				
				prayer.setText(R.string.reader_prayer_yiwedswea_melaekt_label);
			}
			
			if(selectedPartOfBook.equals(PartOfBook.MELKA_MARIAM.name())) {
				
				prayerHeader.setText(R.string.reader_prayer_melka_mariam_header_label);
				
				prayer.setText(R.string.reader_prayer_melka_mariam_label);
			}
			
			if(selectedPartOfBook.equals(PartOfBook.MELKA_EYESUS.name())) {
				
				prayerHeader.setText(R.string.reader_prayer_melka_eyesus_header_label);
				
				prayer.setText(R.string.reader_prayer_melka_eyesus_label);
			}
			
			if(selectedPartOfBook.equals(PartOfBook.MELKA_EDOM.name())) {
				
				prayerHeader.setText(R.string.reader_prayer_melka_edom_header_label);
				
				prayer.setText(R.string.reader_prayer_melka_edom_label);
			}
		}
		
		hideProcessingDialog();
		
	}

}
