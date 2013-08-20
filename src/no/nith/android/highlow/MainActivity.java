package no.nith.android.highlow;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	private Context context;
	private Button buttonStartGame;
	private Button buttonHighscores;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		context = this;
		
		initViews();
		initListeners();
		
	}

	// Initialize all views and classes
	private void initViews() {
		buttonStartGame = (Button) findViewById(R.id.buttonStartGame);
		buttonHighscores = (Button) findViewById(R.id.buttonHighscores);
	}
	
	// Initialize all listeners
	private void initListeners() {
		buttonStartGame.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				goToActivity(context, GameActivity.class);
			}
		});
		
		buttonHighscores.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				goToActivity(context, HighscoreActivity.class);
			}
		});
		
	}
	
	// Go to another activity
	private void goToActivity(final Context context, Class<?> cls) {
		Intent intent = new Intent();
		intent.setClass(context, cls);
		startActivity(intent);
		
	}

}
