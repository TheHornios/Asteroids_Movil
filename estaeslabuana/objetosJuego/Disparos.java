package com.example.ronri.estaeslabuana.objetosJuego;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import com.example.ronri.estaeslabuana.constantes.Constantes;
import com.example.ronri.estaeslabuana.estadosJuego.Juego1;
import com.example.ronri.estaeslabuana.vectores.Vector2D;
public class Disparos extends ObjetosMovibles{
	private Juego1 juego;
	private Cronometro tiempo;
	public Disparos(Vector2D posicion, Vector2D velocidad, Bitmap textura, double maxVelocidad, double angulo, Juego1 juego, boolean mio) {
		super(posicion, velocidad, textura, maxVelocidad,juego);
		this.velocidad = velocidad.aceleracion(maxVelocidad);
		this.angulo = angulo;
		this.juego = juego;
		this.mio = mio;
		tiempo = new Cronometro();
		tiempo.run(2000);
	}

	@Override
	public void update() {
		if(Settings.sicosis&&mio){
			if(posicion.getX() > Constantes.ANCHO){
				posicion.setX(-ancho);
			}
			if(posicion.getY() > Constantes.ALTO){
				posicion.setY(-alto);
			}
			if(posicion.getX() < -ancho){
				posicion.setX(Constantes.ANCHO);
			}
			if(posicion.getY() < -alto){
				posicion.setY(Constantes.ALTO);
			}
			if(!tiempo.isEncendido()){
				juego.getObjetosMovibles().remove(this);
			}
		}else{
			if(posicion.getX() > Constantes.ANCHO||posicion.getY() > Constantes.ALTO||posicion.getX() < 0||posicion.getY() < 0&&mio){
				juego.getObjetosMovibles().remove(this);
			}
		}
		if(posicion.getX() > Constantes.ANCHO||posicion.getY() > Constantes.ALTO||posicion.getX() < 0||posicion.getY() < 0&&!mio){
			juego.getObjetosMovibles().remove(this);
		}
		posicion = posicion.add(velocidad);
		colaider();
	}

	@Override
	public void draw(Canvas g) {
		Paint g2 = new Paint();
		g.drawBitmap(textura,null,new Rect((int)posicion.getX(),(int)posicion.getY(),(int)textura.getWidth()+(int)posicion.getX(),(int)textura.getHeight()+(int)posicion.getY()),g2);
	}

}
