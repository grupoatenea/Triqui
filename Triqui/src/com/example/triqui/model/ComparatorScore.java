package com.example.triqui.model;

import java.util.Comparator;

public class ComparatorScore implements Comparator<Score> {

	@Override
	public int compare(Score score1, Score score2) {
		return score1.getNumberMoves().compareTo(score2.getNumberMoves());
	}
}
