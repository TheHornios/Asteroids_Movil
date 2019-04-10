package com.example.ronri.estaeslabuana.objetosJuego;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import com.example.ronri.estaeslabuana.vectores.Vector2D;


public abstract class ObjetosJuego {
	protected Bitmap textura;
	protected Vector2D posicion;
	
	public ObjetosJuego (Vector2D posicion,Bitmap textura){
		this.textura = textura;
		this.posicion = posicion;
	}
	
	public abstract void update();
	public abstract void draw(Canvas g);
	
	public Vector2D getPosicion(){
		return posicion;
	}
	public void setPosicion(Vector2D posicion){
		this.posicion = posicion;
	}
}

