package com.example.triqui;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.example.triqui.model.ListScores;
import com.example.triqui.model.Score;
import com.example.triqui.model.Triqui;


public class CustomView  extends View{
	int i;
	
	private static int FONT_SIZE = 30;
	
	Triqui triqui; 
	AlertDialog.Builder builder;
	
	public CustomView(Context context) {
		super(context);
		Game game = (Game)context;
		triqui = new Triqui(game.getFiguraSeleccionada());
		Log.d("Context: ", context.getClass().getName());
		//Log.d("Context: figura selecinada ", game.getFiguraSeleccionada());
		builder= new AlertDialog.Builder(context);
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		Log.d("onDraw", "Size: " + getWidth() + " " + getHeight());
		int width =getWidth(); 
		int height =getHeight();
		pintarFondo(canvas);
		pintarTablero(canvas, width, height);
		pintarFiguras(canvas, width, height);
		
	}

	private void pintarTablero(Canvas canvas, int width, int height) {
		Paint p = new Paint();
		p.setColor(Color.RED);
		p.setStrokeWidth(3);
		canvas.drawLine(width / 3, 0, width / 3, height, p);
		canvas.drawLine(width * 2 / 3, 0, width * 2 / 3, height, p);
		canvas.drawLine(0, height / 3, width, height / 3, p);
		canvas.drawLine(0, height * 2 / 3, width, height * 2 / 3, p);
	}

	private void pintarFondo(Canvas canvas) {
		Paint p = new Paint();
		p.setStyle(Paint.Style.FILL);
		p.setColor(Color.WHITE);
		canvas.drawPaint(p);
	}
	
	private void pintarFiguras(Canvas canvas, int width, int height) {
		Paint paintFiguras = new Paint();
		paintFiguras.setTextSize(FONT_SIZE);
		String [][] tablero = triqui.getTablero();
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				if (tablero[i][j] != null)
					canvas.drawText(tablero[i][j], i * width / 3, (j * height / 3) + FONT_SIZE, paintFiguras);
			}
		}
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {

		if (event.getAction() != MotionEvent.ACTION_DOWN)
			return super.onTouchEvent(event);

		Log.d("onTouchEvt", "Touch! " + event.getX() + " " + event.getY());
		
		
		
		int celdaX = (int) (event.getX() * 3 / getWidth());
		int celdaY = (int) (event.getY() * 3 / getHeight());
		
		Log.d("onTouchEvt", "Celda " + celdaY + " " + celdaX);
		
		triqui.jugar(celdaX, celdaY);
		invalidate(); //Repinta
		
		
		if (triqui.getWinner() != null) 
		{
			String player = "Ganador : " + triqui.getWinner();
			String numberMoves = " en movimientos " + Integer.toString(triqui.getNumberMoves(triqui.getWinner()));
			
			new ListScores().getInstance().add(new Score(player, triqui.getNumberMoves(triqui.getWinner())));
			
			builder.setTitle(R.string.title_winner_game)
	           .setMessage(player + numberMoves)
	           .setPositiveButton(R.string.winner_pos_option, new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                   }
               })
	           .show();
		}
		
		return true;
	}

}
