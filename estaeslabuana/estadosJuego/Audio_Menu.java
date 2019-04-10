package com.example.ronri.estaeslabuana.estadosJuego;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.example.ronri.estaeslabuana.graficos.Assets;

public class Audio_Menu extends Estados{
	private Juego1 j;
	public Audio_Menu(Juego1 juego1){
		j = juego1;
	}
	@Override
	public void draw(Canvas g) {
		Paint g2 = new Paint();
		g2.setColor(Color.WHITE);
		g2.setTextSize(70);
		g.drawText("You Die <3",150,150,g2);
		g.drawText("Your Score= "+j.getHud().getScore(),150,300,g2);
		g.drawText("Tap To Go The Menu",150,450,g2);
	}

	@Override
	public void update() {

	}
}
