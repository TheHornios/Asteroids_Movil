package com.example.ronri.estaeslabuana.mejoras;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

import com.example.ronri.estaeslabuana.estadosJuego.Juego1;
import com.example.ronri.estaeslabuana.objetosJuego.Nave;
import com.example.ronri.estaeslabuana.vectores.Vector2D;

public abstract class Mejoras {
	protected Bitmap textura;
	protected Juego1 juego;
	protected Nave nave;
	protected Vector2D posicionNave;
	protected Vector2D posicionMejora;
	
	protected boolean colision;
	protected double anchoMejora;
	protected double altoMejora;
	protected double anchoNave;
	protected double altoNave;
	public Rect box;
	public Mejoras (Juego1 juego){
		this.juego = juego;
		posicionNave = juego.getNave().getPosicion();
		nave = juego.getNave();
	}
	public abstract void update();
	public abstract void draw(Canvas g);
	
	public void setTextura(Bitmap textura){
		this.textura = textura;
	}
	public void setPosicion(int x,int y){
		posicionMejora = new Vector2D(x,y);
		box = new Rect(x,y,textura.getWidth()+x,textura.getHeight()+y);
	}
	public void tamaños(){
		anchoMejora = textura.getWidth();
		altoMejora = textura.getHeight();
		anchoNave = nave.ancho();
		altoNave = nave.alto();
	}
}
