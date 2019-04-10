package com.example.ronri.estaeslabuana.graficos;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.example.ronri.estaeslabuana.estadosJuego.Juego1;
import com.example.ronri.estaeslabuana.vectores.Vector2D;

public class Mensaje {
	private Juego1 juego;
	private float alpha;
	private String text;
	private Vector2D pos;
	private Color color;
	private boolean centro;
	private boolean fade;
	private final float delta = 0.01f;
	private int tam;
	public Mensaje(Vector2D pos,boolean fade,String text,Juego1 juego,int tam){
		this.pos = pos;
		this.fade = fade;
		this.text = text;
		this.color = color;
		this.centro = centro;
		this.juego = juego;
		this.tam = tam;
		if(fade){
			alpha = 1;
		}else{
			alpha = 0;
		}
	}
	public void draw(Canvas g2d){
		Paint p = new Paint();
		p.setColor(Color.WHITE);
		p.setTextSize(tam);
		p.setAntiAlias(true);
		g2d.drawText(text, (float) pos.getX(), (float) pos.getY(), p);

		
		pos.setY(pos.getY()-1);
		
		if(fade){
			alpha -=delta;
		}else{
			alpha +=delta;
		}
		
		if(fade&&alpha <=0){
			juego.getOMensajes().remove(this);
		}
		if(!fade && alpha > 1){
			fade = true;
			alpha = 1;
		}
	}
}
