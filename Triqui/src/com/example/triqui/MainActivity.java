package com.example.triqui;

import com.example.triqui.model.ListScores;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       //setContentView(new CustomView(this));
        setContentView(R.layout.activity_main);
        
        View aboutButton = findViewById(R.id.about_button);
        aboutButton.setOnClickListener(this);
        
        View newGameButton = findViewById(R.id.new_game_button);
        newGameButton.setOnClickListener(this);
        
        View bestScoresButton = findViewById(R.id.best_scores_button);
        bestScoresButton.setOnClickListener(this);
        
        //Init list of best scores
        new ListScores().getInstance();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent = null;
		
		switch(v.getId()) {
			case R.id.about_button :
				intent = new Intent(this, About.class);
		        startActivity(intent);
				Log.d("Triqui", "Realizo click");
				break;
			case R.id.best_scores_button:
				intent = new Intent(this, Scores.class);
		        startActivity(intent);
		        break;
			case R.id.new_game_button:
		        openNewGameDialog();
		        break;
			default :
				break;
		}
	}
	
   private void openNewGameDialog() {
	      new AlertDialog.Builder(this)
	           .setTitle(R.string.new_game_label)
	           .setItems(R.array.players,
	            new DialogInterface.OnClickListener() {
	               public void onClick(DialogInterface dialoginterface, int positionSelected) {
	                  startGame(positionSelected);
	               }
	            }) .show();
	   }
   
   
   /** Start a new game with the given difficulty level */
   private void startGame(int positionSelected) {
      Log.d("Triqui", "clicked on " + positionSelected);
      Intent intent = new Intent(this, Game.class);
      intent.putExtra(Game.KEY_PLAYER, positionSelected);
      startActivity(intent);
   }
}
