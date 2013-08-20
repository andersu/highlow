package no.nith.android.highlow;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class GameActivity extends Activity {

	private TextView textViewCurrentNumber;
	private TextView textViewNextNumber;
	private TextView textViewScore;
	private Button buttonLower;
	private Button buttonHigher;
	private Button buttonPlayAgain;
	private Button buttonSubmitScore;
	private EditText editTextName;
	
	int score;
	
	private Bundle savedInstanceState;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.savedInstanceState = savedInstanceState;
		setContentView(R.layout.activity_game);
		initViews();
		initListeners();
		setRandomNumber();
	}
	
	private void initViews() {
		textViewCurrentNumber = (TextView) findViewById(R.id.textViewCurrentNumber);
		textViewNextNumber = (TextView) findViewById(R.id.textViewNextNumber);
		textViewScore = (TextView) findViewById(R.id.textViewScore);
		buttonLower = (Button) findViewById(R.id.buttonLower);
		buttonHigher = (Button) findViewById(R.id.buttonHigher);
		buttonPlayAgain = (Button) findViewById(R.id.buttonPlayAgain);
		buttonSubmitScore = (Button) findViewById(R.id.buttonSubmitScore);
		editTextName = (EditText) findViewById(R.id.editTextName);
		score = 0;
		
	}
	
	private void initListeners() {
		buttonLower.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				checkCorrectness(true);
			}
		});
		
		buttonHigher.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				checkCorrectness(false);			
			}
		});
		
		buttonPlayAgain.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				onCreate(savedInstanceState);
			}
		});
		
		buttonSubmitScore.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO: Ta navnet og scoren med og lag et nytt listeelement i highscorelisten. 
				// Gå til highscorelisten
			}
		});
		
	}
	
	private void endGame() {
		textViewCurrentNumber.setTextColor(getResources().getColor(R.color.fail_red));
		textViewNextNumber.setVisibility(View.INVISIBLE);
		buttonLower.setVisibility(View.INVISIBLE);
		buttonHigher.setVisibility(View.INVISIBLE);
		buttonPlayAgain.setVisibility(View.VISIBLE);
		buttonSubmitScore.setVisibility(View.VISIBLE);
		editTextName.setVisibility(View.VISIBLE);
		
		
	}
	
	private void continueGame() {
		textViewCurrentNumber.setTextColor(getResources().getColor(R.color.correct_green));
		score += 1;
		textViewScore.setText(getString(R.string.score) + score);
	}
	
	private void checkCorrectness(boolean clickedLower) {
		int oldNumber = Integer.parseInt(textViewCurrentNumber.getText().toString());
		int newNumber = setRandomNumber();
		
		if ((newNumber > oldNumber && clickedLower) || 
			(newNumber < oldNumber && !clickedLower)) {
			endGame();
		}
		else {
			continueGame();
		}
		
	}
	private int setRandomNumber() {
		int randomNumber = (int) (Math.floor(10*Math.random()));
		textViewCurrentNumber.setText(Integer.toString(randomNumber));
		return randomNumber;
	}
}
