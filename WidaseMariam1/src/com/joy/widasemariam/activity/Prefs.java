package com.joy.widasemariam.activity;

import android.os.Bundle;
import android.preference.PreferenceActivity;

import com.joy.widasemariam.R;

public class Prefs extends PreferenceActivity {

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.prefs);
	}

}
