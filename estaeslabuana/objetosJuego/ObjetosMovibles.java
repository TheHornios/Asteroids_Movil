package com.example.ronri.estaeslabuana.objetosJuego;

import android.graphics.Bitmap;

import com.example.ronri.estaeslabuana.estadosJuego.Juego1;
import com.example.ronri.estaeslabuana.vectores.Vector2D;

import java.util.ArrayList;


public abstract class ObjetosMovibles extends ObjetosJuego{
	protected Vector2D velocidad;
	protected double angulo;
	protected double maxVelocidad;
	protected int ancho;
	protected int alto;
	protected Juego1 juego;
	protected boolean mio;
	
	public ObjetosMovibles(Vector2D posicion, Vector2D velocidad, Bitmap textura, double maxVelocidad, Juego1 juego) {
		super(posicion, textura);
		this.velocidad = velocidad;
		angulo = 0;
		this.maxVelocidad = maxVelocidad;
		ancho = textura.getWidth();
		alto = textura.getHeight();
		this.juego = juego;
		mio=false;
	}
	protected void colaider(){
		ArrayList<ObjetosMovibles> objetosMovibles = juego.getObjetosMovibles();
		for(int i =0; i<objetosMovibles.size();i++){
			ObjetosMovibles m = objetosMovibles.get(i);
			double distance =1000;
			if(m.equals(this)){
				
			}else{
				distance = m.getCentro().substracto(getCentro()).getMagnitud();
			}
			if(distance != 1000){
				if(distance < m.ancho/2 + ancho/2 && objetosMovibles.contains(this)){
					colisionObejeto(m,this);
				}	
			}
			
		}
	}
	private void colisionObejeto(ObjetosMovibles a, ObjetosMovibles b){
		if(!(a instanceof Nave && ((Nave)a).isSpawn()||b instanceof Nave && ((Nave)b).isSpawn())){
			if(!(a instanceof Meteoro&& b instanceof Meteoro||a instanceof Nave&& b instanceof Disparos && b.mio||a instanceof Disparos&& b instanceof Nave && a.mio||a instanceof Disparos &&b instanceof Disparos)){
				juego.crearExplosion(getCentro());
				a.borrar();
				b.borrar();
			}
		}
		
	}
	protected void borrar(){
		juego.getObjetosMovibles().remove(this);
	}
	public Vector2D getCentro(){
		return new Vector2D(posicion.getX() + ancho/2, posicion.getY() + alto/2);
	}
	public int ancho(){
		return ancho;
	}
	public int alto(){
		return alto;
	}
}
