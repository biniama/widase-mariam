package com.joy.widasemariam.activity;

import com.joy.widasemariam.R;
import android.preference.PreferenceActivity;
import android.os.Bundle;

public class Prefs extends PreferenceActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		
		addPreferencesFromResource(R.xml.prefs);
	}
	
}
