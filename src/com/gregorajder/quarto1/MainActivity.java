package com.gregorajder.quarto1;

import draw.ImageAdapter;
import logic.RunGame;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

/**
 * MainActivity.java game activity
 * 
 */
public class MainActivity extends Activity implements OnClickListener,
OnItemClickListener {

	private static final String TAG = "MainActivityLogs";
	// int tempText;
	TextView text;
	GridView setGrid, boardGrid;
	Button btn;
	public static RunGame run;
	ImageAdapter boardAdapter = new ImageAdapter(this, R.id.gridBoard);
	ImageAdapter setAdapter = new ImageAdapter(this, R.id.gridSet);

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);
		boardGrid = (GridView) findViewById(R.id.gridBoard);
		setGrid = (GridView) findViewById(R.id.gridSet);
		btn = (Button) findViewById(R.id.button1);
		text = (TextView) findViewById(R.id.instructions);

		run = (RunGame) getLastNonConfigurationInstance();
		if (run == null)
			start();
		boardGrid.setOnItemClickListener(this);
		setGrid.setOnItemClickListener(this);
		btn.setOnClickListener(this);
		Log.d(TAG, "все создано");
		f5();
		Log.d(TAG, "отобразили");
	}

	public void start() {
		Log.d(TAG, "start");
		run = new RunGame();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.restart:
			start();
			f5();
			break;
		case R.id.rules:
			Intent intent = new Intent(this, RulesActivity.class);
			startActivity(intent);
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
		Log.d(TAG, "onItemClick");
		if (setGrid == parent && id != 16) { // choice figure
			run.setClick(position);
			f5();
		}

		if (boardGrid == parent & id == 16) {// move
			run.boardMove(position);
			f5();
		}

		if (boardGrid == parent && id != 16) { // choice win set
			run.boardVin(position);
			f5();
		}
	}

	@Override
	public void onClick(View v) {
		Log.d(TAG, "onClick");
		if (R.id.button1 == v.getId()) {
			run.btnClick();
			f5();
		}
	}

	void f5() { // refresh screen
		Log.d(TAG, "f5");
		setGrid.setAdapter(setAdapter);
		boardGrid.setAdapter(boardAdapter);
		text.setText(getString(run.logicData.getPlayer()) + ": "
				+ getString(run.logicData.getInstruction()));
		btn.setText(run.logicData.getToDoText());
	}

	public Object onRetainNonConfigurationInstance() {
		return run;
	}
}
