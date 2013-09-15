package com.example.triqui;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class Game extends Activity {

	public static final String KEY_DIFFICULTY =
		      "org.example.triqui.difficulty";
	
	private String figuraSeleccionada;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		int seleccion = getIntent().getIntExtra(KEY_DIFFICULTY, 0);
		figuraSeleccionada = seleccion == 0 ? "X" : "O";
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
