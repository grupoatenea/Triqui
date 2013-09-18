package com.example.triqui.test;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import com.example.triqui.model.ListScores;
import com.example.triqui.model.Score;

public class ScoresTest {
	
	@Test
	public void addScoresTest () {
		
		List<Score> listScores = new ListScores().getInstance();
		listScores.add(new Score("Jorge", 3));
		listScores.add(new Score("Mario", 4));
		listScores.add(new Score("Juan", 5));
		
		Assert.assertEquals(3, ListScores.getInstance().size());
	}
}
