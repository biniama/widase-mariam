package com.joy.widasemariam.activity;

import java.util.Locale;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.joy.widasemariam.R;
import com.joy.widasemariam.WithAboutMenu;
import com.joy.widasemariam.WithHelpMenu;
import com.joy.widasemariam.WithPrefsMenu;
import com.joy.widasemariam.WithExitMenu;

public abstract class AbstractActivity extends Activity {

	private ProgressDialog progressDialog;
	
	public static final int ABOUT_MENU = 10001;
	
	public static final int HELP_MENU = 10002;
	
	public static final int PREFS_MENU = 10003;

    public static final int EXIT_MENU = 10004;
		
	@Override
	public void setContentView(int layoutResID) {

		super.setContentView(layoutResID);
	}

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		if(this instanceof WithHelpMenu) {
			
			menu.add(0, HELP_MENU, HELP_MENU, R.string.help_menu_label);
		}
		
		if(this instanceof WithAboutMenu) {
			
			menu.add(0, ABOUT_MENU, ABOUT_MENU, R.string.about_menu_label);
		}
		
		if(this instanceof WithPrefsMenu) {
			
			menu.add(0, PREFS_MENU, PREFS_MENU, R.string.prefs_menu_label);
		}

        if(this instanceof WithExitMenu) {

            menu.add(0, EXIT_MENU, EXIT_MENU, R.string.exit_menu_label);
        }
		
		return menu.size() > 0;
	}


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		final boolean result = super.onOptionsItemSelected(item);
		
		switch(item.getItemId()) {
		
		case HELP_MENU:
			
			goToHelpMenu();
			
			break;
			
		case ABOUT_MENU:
			
			goToAboutMenu();
			
			break;
			
		case PREFS_MENU:
			
			goToPrefsMenu();

            break;

        case EXIT_MENU:

            goToExitMenu();

            break;
        }
		
		return result;
	}

	private void goToPrefsMenu() {
		
		final Intent intent = new Intent(AbstractActivity.this, Prefs.class);
		
		startActivity(intent);
		
	}


	protected void goToHelpMenu() {

		final Intent intent = new Intent(AbstractActivity.this, Help.class);
		
		startActivity(intent);
		
	}
	
	protected void goToAboutMenu() {
	
		final Intent intent = new Intent(AbstractActivity.this, About.class);
		
		startActivity(intent);
		
	}

    protected void goToExitMenu() {

        finish();

    }
	
	protected void goToChooseLanguage(final Context context) {
		
		final Intent intent = new Intent(context, ChooseLanguage.class);
		
		startActivity(intent);
		
	}
	
	protected void changeLocale(final String selectedLocale) {
		
		Locale locale = new Locale(selectedLocale);
		
		Locale.setDefault(locale);
		
		Configuration config = new Configuration();
		
		config.locale = locale;
		
		getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
	}

	/**
	 * Returns true if a processing dialog is currently being displayed
	 * @return
	 */
	protected boolean isProcessingDialogShowing() {
		
		return null != progressDialog && progressDialog.isShowing();
	}
	
	/**
	 * Show a default processing message
	 */
	protected synchronized void showProcessingDialog(){
		showProcessingDialog(null);
	}
	
	
	/**
	 * Shows a processing dialog with the supplied message
	 * @param message
	 */
	protected synchronized void showProcessingDialog(String message){
		
		if(null != progressDialog && progressDialog.isShowing())
			progressDialog.dismiss();
		
		if(message == null)
			message = getResources().getString(R.string.general_loading_msg);
		
		progressDialog = ProgressDialog.show(this, null, message, true, true);
		
	}
	
	/**
	 * Hides/Closes a processing dialog
	 */
	protected synchronized void hideProcessingDialog(){
		
		try {
			
			if(null != progressDialog && progressDialog.isShowing())
				progressDialog.dismiss();
			
		}catch(Exception ex){}
	}

	/**
	 * Handles the user based on the supplied exception. 
	 * @param th
	 * @param nextStepRunnable
	 */
	protected void handleException(final Throwable th, final Runnable nextStepRunnable){
		
		final String errorMessage = getAlertMessage(th);
		
		if(null != errorMessage)
			showErrorDialog(errorMessage.trim(), nextStepRunnable);
	}
		
	private String getAlertMessage(Throwable th) {
		
		return th.getMessage();
	}


	/**
	 * Shows an error message dialog box
	 * @param alertMessage
	 * @param nextStepRunnable
	 */
	protected void showErrorDialog(final String alertMessage, final Runnable nextStepRunnable){
		
		showDialog(getResources().getString(R.string.general_error_alert_title), alertMessage, nextStepRunnable);
				
	}
	
	/**
	 * Shows a custom dialog
	 * @param message
	 * @param nextStepRunnable
	 */
	protected void showDialog(final String message, final Runnable nextStepRunnable){
		showDialog(null, message, nextStepRunnable);
	}
	
	/**
	 * Shows a custom dialog
	 * @param title
	 * @param message
	 * @param nextStepRunnable
	 */
	protected void showDialog(final String title, final String message, final Runnable nextStepRunnable){
		
		hideProcessingDialog();
		
		if(null == message)
			return;
		
		final AlertDialog.Builder confirmDialog = new AlertDialog.Builder(this);
		
		if(null != title)
			confirmDialog.setTitle(title);
		else
			confirmDialog.setTitle(R.string.general_alert_title);
		
        confirmDialog.setMessage(message);  
        confirmDialog.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {

			public void onClick(DialogInterface dialog, int which) {
				
				if(null != nextStepRunnable)
					nextStepRunnable.run();
			}
			
		});
        confirmDialog.create();  
        confirmDialog.show(); 
		
	}
	
}
