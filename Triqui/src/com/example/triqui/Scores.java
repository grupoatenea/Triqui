package com.example.triqui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.example.triqui.model.ComparatorScore;
import com.example.triqui.model.ListScores;
import com.example.triqui.model.Score;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class Scores extends Activity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_score);
		
		ListView listViewBestScores = (ListView) findViewById(R.id.listview_best_scores);
		List<Score> listScores = ListScores.getInstance();
		ArrayAdapter<String> adapter = null;
		List<String> listScoresString = new ArrayList<String>();
		
		Log.v("Lista size", ""+listScores.size());
		
		if(listScores.size() > 0) {
			Collections.sort(listScores, new ComparatorScore());
			
			for(Score score : listScores) {
				listScoresString.add(score.toString());
			}
			
			adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listScoresString);
		} else {
			listScoresString.add("No existen datos");
			adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listScoresString);
		}
		
		listViewBestScores.setAdapter(adapter);
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.scores, menu);
		return true;
	}
}
