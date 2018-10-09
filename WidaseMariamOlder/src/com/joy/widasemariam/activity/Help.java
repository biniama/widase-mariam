package com.joy.widasemariam.activity;

import com.joy.widasemariam.R;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

public class Help extends AbstractActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
	
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.help_topic);
		
		initializeHelpTopic();
	}

	private void initializeHelpTopic() {
		
		if(!isProcessingDialogShowing())
			showProcessingDialog(getResources().getString(R.string.general_loading_msg));

		final TextView helpTitle = (TextView) findViewById( R.id.help_topic_title_label );

		helpTitle.setText(getResources().getString( R.string.help_user_manual_title ));

		
		final WebView webView = (WebView) findViewById( R.id.help_topic_webview );

		webView.loadUrl( "file:///android_asset/help_contents/help_user_manual.html" );
		
		
		final Button goToHomeButton = (Button) findViewById(R.id.help_topic_back_to_choose_language_button);
		
		goToHomeButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				
				goToChooseLanguage(Help.this);
				
			}
		});
		
		hideProcessingDialog();
		
	}	
	
}
