package com.example.ronri.estaeslabuana.objetosJuego;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import com.example.ronri.estaeslabuana.estadosJuego.Juego1;
import com.example.ronri.estaeslabuana.vectores.Vector2D;

public class Bombas extends ObjetosJuego{
	private Rect colision;
	private Cronometro cm3;
	private Juego1 juego;
	private boolean e1;
	private boolean e2;
	private boolean e3;
	private boolean e4;
	private boolean morir;
	public Bombas(Vector2D posicion, Bitmap textura, Juego1 juego) {
		super(posicion, textura);
		cm3 = new Cronometro();
		cm3.run(2200);
		this.juego = juego;
		e1=true;
		e2=true;
		e3=true;
		e4=true;
		morir = false;
	}	

	@Override
	public void update() {
		cm3.update();
		if(!cm3.isEncendido()&&!morir){
			colision = new Rect((int)posicion.getX()-100,(int)posicion.getY()-100,200,200);
			morir = true;
			
		}
	}

	@Override
	public void draw(Canvas g) {
		Paint g2 = new Paint();
		g.drawBitmap(textura,null,new Rect((int)posicion.getX(),(int)posicion.getY(),(int)textura.getWidth()+(int)posicion.getX(),(int)textura.getHeight()+(int)posicion.getY()),g2);

	}
	public Rect getRectangulo(){
		return colision;
	}
	public boolean isMorir() {
		return morir;
	}

	public void setMorir(boolean morir) {
		this.morir = morir;
	}

}
