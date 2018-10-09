package com.joy.widasemariam.activity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

import com.joy.widasemariam.Constants;
import com.joy.widasemariam.R;

public class Help extends AbstractActivity {

    private Typeface TYPE_FACE_NYALA;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
	
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.help_topic);
		
		initializeHelpTopic();
	}

	private void initializeHelpTopic() {
		
		if(!isProcessingDialogShowing())
			showProcessingDialog(getResources().getString(R.string.general_loading_msg));

        TYPE_FACE_NYALA = Typeface.createFromAsset(getAssets(), Constants.FONT_NYALA_FILE_LOCATION);

		final TextView helpTitle = (TextView) findViewById( R.id.help_topic_title_label );

        final WebView webView = (WebView) findViewById( R.id.help_topic_webview );

        final Button goToHomeButton = (Button) findViewById(R.id.help_topic_back_to_choose_language_button);

        if(!getBaseContext().getResources().getConfiguration().locale.equals(Constants.ACTIVITY_PROPERTY_LOCALE_ENGLISH)) {

            helpTitle.setTypeface(TYPE_FACE_NYALA);
            goToHomeButton.setTypeface(TYPE_FACE_NYALA);
        }

        helpTitle.setText(getResources().getString( R.string.help_user_manual_title ));

		webView.loadUrl( "file:///android_asset/help_contents/help_user_manual.html" );

		goToHomeButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				
				goToChooseLanguage(Help.this);
				
			}
		});
		
		hideProcessingDialog();
		
	}	
	
}
