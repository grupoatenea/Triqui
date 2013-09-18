package com.example.triqui.model;

public class Score {
	private String player;
	private Integer numberMoves;
	
	
	public Score(String player, int numberMoves) {
		super();
		this.player = player;
		this.numberMoves = numberMoves;
	}
	
	
	public String getPlayer() {
		return player;
	}
	public void setPlayer(String player) {
		this.player = player;
	}
	public Integer getNumberMoves() {
		return numberMoves;
	}
	public void setNumberMoves(Integer numberMoves) {
		this.numberMoves = numberMoves;
	}
	
	
	public String toString() {
		return "Jugador: " + player + ", Numero de movimiento: " + numberMoves;
	}
}
