package com.scottline.patientalliance.activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.scottline.patientalliance.R;

public class SplashScreenctivity extends Activity
{

	TextView name,caption;
	ImageView logo;
	RelativeLayout layout;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.splashscreen_layout);
		showMainLogo();
	}
	/** Handler to update splash visibility. */
	private Handler mHandler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			if (msg.what == 0) {
				switchActivity();
			}
		}

	};

	private void showMainLogo() {
		mHandler.sendEmptyMessageDelayed(0, 2500);
	}

	private void switchActivity() 
	{
		Intent intent = null;
		intent = new Intent(getApplicationContext(), LoginActivity.class);
		//intent = new Intent(getApplicationContext(),LoginActivity.class);
		startActivity(intent);
		finish();

	}

}
