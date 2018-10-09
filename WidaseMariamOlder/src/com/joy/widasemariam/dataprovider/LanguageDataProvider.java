package com.joy.widasemariam.dataprovider;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;

import com.joy.widasemariam.model.Language;

public class LanguageDataProvider extends AbstractDataProvider {

	public static LanguageDataProvider instance;
	
	public static List<Language> languageList;
	
	protected LanguageDataProvider(Context context) {
		
		super(context);
		
		languageList = new ArrayList<Language>();
		
	}
	
	public synchronized static LanguageDataProvider getInstance(final Context context) {
		
		if(null == instance) {
			
			instance = new LanguageDataProvider(context);
		}
		
		return instance;
		
	}
	
	public void reset() {
		
		synchronized (languageList) {
		
			languageList.clear();
			
		}
	}
	
}
