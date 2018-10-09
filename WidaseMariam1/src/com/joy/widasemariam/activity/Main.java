package com.joy.widasemariam.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MotionEvent;
import android.widget.TextView;

import com.joy.widasemariam.Constants;
import com.joy.widasemariam.R;

public class Main extends AbstractActivity {

	private static long SPLASH_SCREEN_TIMEOUT_MS = 2000;
	
	private MediaPlayer introSong;
	
	private Thread splashTread;
	
	 private Typeface TYPE_FACE_NYALA;
	
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
		
		TYPE_FACE_NYALA = Typeface.createFromAsset(getAssets(), Constants.FONT_NYALA_FILE_LOCATION);

		((TextView) findViewById(R.id.intro_text)).setTypeface(TYPE_FACE_NYALA);
		((TextView) findViewById(R.id.intro_text)).setTextSize(22.0F);
		/*
		 	((TextView) findViewById(R.id.intro_text_one)).setTypeface(TYPE_FACE_NYALA);
			((TextView) findViewById(R.id.intro_text_two)).setTypeface(TYPE_FACE_NYALA);
		 */
		splashTread = new Thread() {
        	
			@Override
            public void run() {
				
                try {
                	
                    synchronized(this){

                            wait(SPLASH_SCREEN_TIMEOUT_MS);
                    }

                } catch(InterruptedException e) {
                	
                } finally {
                	
                	introSong.release();
                    finish();

                    Intent i = new Intent();
                    i.setClass(Main.this, getStartScreen());
                    startActivity(i);

                }
            }
        };

        splashTread.start();
		
	}

	private Class<?> getStartScreen(){
		
		return ChooseLanguage.class;
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		
		if (event.getAction() == MotionEvent.ACTION_DOWN) {
			
			synchronized(splashTread){
				
				splashTread.notifyAll();
				
			}
		}
		return true;
    }
	
	@Override
	protected void onPause() {

		super.onPause();
		
		introSong.release();
		
	}
	
}
