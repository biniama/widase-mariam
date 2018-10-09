package com.joy.widasemariam.activity;

import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.TextView;

import com.joy.widasemariam.Constants;
import com.joy.widasemariam.R;

public class About extends AbstractActivity {

	private Typeface TYPE_FACE_NYALA;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	
		super.onCreate(savedInstanceState);

        setContentView(R.layout.about);

        TYPE_FACE_NYALA = Typeface.createFromAsset(getAssets(), Constants.FONT_NYALA_FILE_LOCATION);

        final TextView aboutTheApp = (TextView) findViewById(R.id.about_the_app_label);

        // Get the preference set as default font size or use 20 font size
     	final SharedPreferences getPrefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

     	String fontSize = getPrefs.getString("fontSizeListKey", "26");
     	
     	aboutTheApp.setTextSize(Float.parseFloat(fontSize) + 4.0F);
     		
     	aboutTheApp.setTypeface(TYPE_FACE_NYALA);
     	/*
        if(getBaseContext().getResources().getConfiguration().locale.equals(Constants.ACTIVITY_PROPERTY_LOCALE_AMHARIC) ||
        	getBaseContext().getResources().getConfiguration().locale.equals(Constants.ACTIVITY_PROPERTY_LOCALE_GEEZ))
            	aboutTheApp.setTypeface(TYPE_FACE_NYALA);
     	 */
	}

}
