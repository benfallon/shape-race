package com.benjaminafallon.shaperace;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private StarButton b;
	private int score;
	private int high_score = 0;
	private int currStarButton = 0;
	final Handler handler = new Handler();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		LinearLayout mLayout = (LinearLayout) findViewById(R.id.LinearLayout2);
		mLayout.setBackgroundColor(Color.BLACK);
				
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
                handler.post(new Runnable() {
                    public void run() {
        				showScore();
                    }
           });

			}
			
		};
		
		Timer myTimer = new Timer();
		myTimer.schedule(task, 5000);
		
		score = 0;
		changeStar(1);
		getRand1to3();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void onButtonPressed(View v) {
		
		b = (StarButton) v;
			
		if (b.getHasStar()) {
			b.setImageResource(android.R.color.transparent);
			b.setHasStar(false);
			changeStar(0);
			score++;
		}
		
		else {
			score-=2;
		}

	}
	
	public void changeStar(int i) {
		View mView;

		currStarButton = getRand1to3();

		switch(currStarButton) {
			case 1:
				mView = (View) findViewById(R.id.starButton1);
				break;
			case 2:
				mView = (View) findViewById(R.id.starButton2);
				break;
			case 3:
				mView = (View) findViewById(R.id.starButton3);
				break;
			default:
				mView =  (View) findViewById(R.id.starButton1);
				break;
		}
				
		StarButton c = (StarButton) mView;
		c.setImageResource(R.drawable.ic_launcher);
		c.setHasStar(true);

	}
	
	public int getRand1to3() {
		
		Random r = new Random();
		int starOnButton = r.nextInt(3 - 1 + 1) + 1;

		
		while (starOnButton == currStarButton) {
			starOnButton = r.nextInt(3 - 1 + 1) + 1;
		}
				
		return starOnButton;
		
	}
	
	public void showScore() {
		
		if (score > high_score) {
			high_score = score;
		}
		
		AlertDialog.Builder alertDialog2 = new AlertDialog.Builder(this);

		alertDialog2.setMessage("Your Score: " + score + "\n High Score: " + high_score);
		
		alertDialog2.setPositiveButton("Play Again",
		        new DialogInterface.OnClickListener() {
		            public void onClick(DialogInterface dialog, int which) {
		                Toast.makeText(getApplicationContext(),
		                        "You clicked Play Again", Toast.LENGTH_SHORT)
		                        .show();
		            }
		        });
		
		alertDialog2.setNegativeButton("Quit",
		        new DialogInterface.OnClickListener() {
		            public void onClick(DialogInterface dialog, int which) {
		                Toast.makeText(getApplicationContext(),
		                        "You clicked Quit", Toast.LENGTH_SHORT)
		                        .show();
		                dialog.cancel();
		            }
		        });

		alertDialog2.show();
	}

}
