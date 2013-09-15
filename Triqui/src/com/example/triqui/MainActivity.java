package com.example.triqui;

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
		switch(v.getId()) {
			case R.id.about_button :
				Intent i = new Intent(this, About.class);
		         startActivity(i);
				Log.d("Triqui", "Realizo click");
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
		           .setItems(R.array.difficulty,
		            new DialogInterface.OnClickListener() {
		               public void onClick(DialogInterface dialoginterface,
		                     int i) {
		                  startGame(i);
		               }
		            })
		           .show();
		   }
	   
	   
	   /** Start a new game with the given difficulty level */
	   private void startGame(int i) {
	      Log.d("Triqui", "clicked on " + i);
	      Intent intent = new Intent(this, Game.class);
	      intent.putExtra(Game.KEY_DIFFICULTY, i);
	      startActivity(intent);
	   }
}
