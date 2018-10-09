package com.joy.widasemariam.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;

import com.joy.widasemariam.R;

public class Main extends AbstractActivity {

	private static long SPLASH_SCREEN_TIMEOUT_MS = 2000;
	
	private MediaPlayer introSong;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.splash_screen);
		
		introSong = MediaPlayer.create(Main.this, R.raw.intro);
		
		final SharedPreferences getPrefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		
		boolean music = getPrefs.getBoolean("checkBoxKey", true);
		
		if(music == true)
		{
			SPLASH_SCREEN_TIMEOUT_MS = 14000;
			
			introSong.start();
		}
		
		new AsyncTask<Void, Void, Void>() {

			@Override
			protected Void doInBackground(Void... arg0) {

				try {
					
					Thread.sleep(SPLASH_SCREEN_TIMEOUT_MS);
					
				} catch(InterruptedException ex) { }
				
				return null;
			}

			@Override
			protected void onPostExecute(Void result) {
				
				startActivity(new Intent(Main.this, ChooseLanguage.class));	
			}
						
		}.execute();
		
		
		/*
		 *	The splash disappears after 5 second 
		 
		Thread timer = new Thread()
		{
			public void run()
			{
				try
				{ 
					sleep(SPLASH_SCREEN_TIMEOUT_MS);
				}
				catch(InterruptedException e)
				{
					e.printStackTrace();
				}
				finally
				{
					startActivity(new Intent(Main.this, ChooseLanguage.class));
				}
			}
		};
		
		timer.start();
		*/
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		
		introSong.release();
		
	}

}
