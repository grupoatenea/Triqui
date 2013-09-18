package com.example.triqui.model;

import java.util.ArrayList;
import java.util.List;

public class ListScores {
	private static List<Score> listScores = null;
	
	public ListScores() {
	}
	
	public static List<Score> getInstance() {
		if(listScores==null) {
			listScores = new ArrayList<Score>();
		}
		
		return listScores;
	}
	
}
