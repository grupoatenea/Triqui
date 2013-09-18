package com.example.triqui.model;

import android.util.Log;

public class Triqui {
	
	private String[][] tablero;
	private boolean turnoO = false;
	private String winner; 
	
	
	public Triqui(){
		tablero = new String[3][3];
	}
	
	public Triqui(String figuraSeleccionada) {
		this();
		
		if (figuraSeleccionada == "O") {
			turnoO=true;
		}
		
		
	}

	public String[][] getTablero(){
		return tablero;
	}
	
	public void jugar(int x, int y){
		if (winner==null){
			
		
		if (tablero[x][y]==null) {
			if(turnoO) {
				tablero[x][y] = "O";
			} else {
				tablero[x][y] = "X";
			}
			
			turnoO = ! turnoO;
		}
		
		ganador();
		
		}
		
		
		
	}
	
	public void ganador(){
		//validacion horizontal
		int j=0;
		
		 for (int i = 0 ; i < tablero.length ; i++) {
			
			 if ((tablero[i][j]==tablero[i][j+1])  && (tablero[i][j]==tablero[i][j+2]&&(tablero[i][j] != null))) {
				 winner=tablero[i][j];
				 Log.d("triqui GANADOR",tablero[i][j]);
				
			 }
			 
	     }
		 //validacion vertical
		 
		 for (int i = 0 ; i < tablero.length ; i++) {
			 if ((tablero[j][i]==tablero[j+1][i])  && (tablero[j][i]==tablero[j+2][i])&&(tablero[j][i] != null)) {
				 winner=tablero[j][i];
				 Log.d("triqui GANADOR",tablero[j][i]);
			 }
			 
	     }
		 
		 //validacion iguales
		 if ((tablero[j][j]==tablero[j+1][j+1])  && (tablero[j][j]==tablero[j+2][j+2])&&(tablero[j][j] != null)) {
			 winner=tablero[j][j];
			 Log.d("triqui GANADOR",tablero[j][j]);
		 }
		 
		 //validacion iguales
		 if ((tablero[j+2][j]==tablero[j+1][j+1])  && (tablero[j+1][j+1]==tablero[j][j+2])&&(tablero[j+1][j+1] != null)) {
			 winner=tablero[j+1][j+1];
			 Log.d("triqui GANADOR",tablero[j+1][j+1]);
			 
			 
		 }
		
	}
	
	public String getWinner(){
		
		return winner;
	}
	
public int  getNumberMoves(String player){
		
	 int NumberMoves =0; 
	 for (int i = 0 ; i < tablero.length ; i++) {
		 for (int j = 0 ; j < tablero.length ; j++) {	
		 if ((tablero[i][j])==(player)) {
			 
			 NumberMoves++;
			
		 }
		 }
		 
     }
		return NumberMoves;
	}
}
