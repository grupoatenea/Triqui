package com.example.triqui;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public class Game extends Activity {

	public static final String KEY_PLAYER = "org.example.triqui.player";
	private String figuraSeleccionada;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		int indexPlayerSelected = getIntent().getIntExtra(KEY_PLAYER, 0);
		figuraSeleccionada = indexPlayerSelected == 0 ? "X" : "O";
		setContentView(new CustomView(this));
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.game, menu);
		return true;
	}
	
	public String getFiguraSeleccionada(){
		return figuraSeleccionada;
	}
}
