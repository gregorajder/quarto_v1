package com.gregorajder.quarto1;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * RulesActivity.java activity with Quarto game rules
 * 
 */
public class RulesActivity extends Activity {

	final String TAG = "States";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rules);
		Log.d(TAG, "ActivityTwo: onCreate()");
	}

}