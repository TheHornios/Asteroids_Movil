package com.example.ronri.estaeslabuana.objetosJuego;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.RotateDrawable;
import android.widget.SeekBar;

import com.example.ronri.estaeslabuana.constantes.Constantes;
import com.example.ronri.estaeslabuana.estadosJuego.Juego1;
import com.example.ronri.estaeslabuana.graficos.Mensaje;
import com.example.ronri.estaeslabuana.vectores.Vector2D;

public class Meteoro extends ObjetosMovibles{
	private Tamaño tamaño;
	public Meteoro(Vector2D posicion, Vector2D velocidad,
				   Bitmap textura, double maxVelocidad, Tamaño tamaño, Juego1 juego) {
		super(posicion, velocidad, textura, maxVelocidad,juego);
		this.tamaño = tamaño;
		this.velocidad = velocidad.aceleracion(maxVelocidad);
	}

	@Override
	public void update() {
		posicion = posicion.add(velocidad);
		angulo += Constantes.VELOCIDADANGULO/2;
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
	}
	public Bitmap rotateBitmap(Bitmap original, float degrees,Canvas e) {
		int width = original.getWidth();
		int height = original.getHeight();

		Matrix matrix = new Matrix();
		matrix.preRotate(degrees);

		Bitmap rotatedBitmap = Bitmap.createBitmap(original, 0, 0, width, height, matrix, true);

		return rotatedBitmap;
	}
	@Override
	public void draw(Canvas g) {
		Paint g2 = new Paint();
		g.drawBitmap(textura,null,new Rect((int)posicion.getX(),(int)posicion.getY(),(int)textura.getWidth()+(int)posicion.getX(),(int)textura.getHeight()+(int)posicion.getY()),g2);
	}
	public Tamaño getTamaño(){
		return tamaño;
	}
	@Override
	public void borrar(){
		juego.dividirMeteoros(this);
		juego.getHud().addScore(Constantes.PT_METEORO);
		double x = posicion.getX();
		double y = posicion.getY();
		if(x<1+70){
			x = 70;
		}
		if(x>Constantes.ANCHO-100){
			x = Constantes.ANCHO-100;
		}
		if(y<1+40){
			y = 100;
		}
		if(y>Constantes.ALTO-100){
			y = Constantes.ALTO-100;
		}
		if(juego.getOMensajes().size()<=15){
			if(Hud.x2){
				juego.getOMensajes().add(new Mensaje(new Vector2D(x,y), true,"+"+Constantes.PT_METEORO*2+"PTs", juego,60));
			}else{
				juego.getOMensajes().add(new Mensaje(new Vector2D(x,y), true,"+"+Constantes.PT_METEORO+"PTs", juego,60));
			}
		}

		super.borrar();
	}
}
