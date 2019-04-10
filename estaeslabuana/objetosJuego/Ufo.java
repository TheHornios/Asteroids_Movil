package com.example.ronri.estaeslabuana.objetosJuego;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import com.example.ronri.estaeslabuana.constantes.Constantes;
import com.example.ronri.estaeslabuana.estadosJuego.Juego1;
import com.example.ronri.estaeslabuana.graficos.Assets;
import com.example.ronri.estaeslabuana.graficos.Mensaje;
import com.example.ronri.estaeslabuana.vectores.Vector2D;
import java.util.ArrayList;

public class Ufo extends ObjetosMovibles{
	private ArrayList<Vector2D> recorrido;
	private int index;
	private Vector2D nodoSeguimiento;
	private boolean siguiendo;
	private Cronometro fireRate;
	public Ufo(Vector2D posicion, Vector2D velocidad, Bitmap textura,
			   double maxVelocidad, Juego1 juego, ArrayList<Vector2D> recorrido) {
		super(posicion, velocidad, textura, maxVelocidad, juego);
		index = 0;
		siguiendo = true;
		fireRate = new Cronometro();
		fireRate.run(Constantes.UFOFIRERATE);
		this.recorrido = recorrido;
	}

	@Override
	public void update() {
		Vector2D modoDeSeguimiento;
		if(siguiendo){
			modoDeSeguimiento = getRecorrido();
		}else{
			modoDeSeguimiento = new Vector2D();
		}
		modoDeSeguimiento = modoDeSeguimiento.aceleracion(1/Constantes.UFO_MASA);
		
		velocidad = velocidad.add(modoDeSeguimiento);
		
		velocidad = velocidad.limite(maxVelocidad);
		
		posicion = posicion.add(velocidad);
		
		if(posicion.getX() > Constantes.ANCHO||posicion.getY() > Constantes.ALTO || posicion.getX()<0 || posicion.getY()<0){
			borrar();
		}
		if(!fireRate.isEncendido()){
			Vector2D jugador = juego.getNave().getCentro().substracto(getCentro());
			jugador = jugador.normalizar();
			
			double anguloDisparo = jugador.getAngulo();
			
			double newAngulo =anguloDisparo;
			jugador = jugador.setDireccion(newAngulo);
			
			Disparos disparo = new Disparos(getCentro().add(jugador.aceleracion(ancho)), jugador, Assets.disparoNave, Constantes.UFO_NIVEL, newAngulo+Math.PI/2, juego,false);
			juego.getObjetosMovibles().add(disparo);
			fireRate.run(Constantes.UFOFIRERATE);
		}
		if((int)(Math.random()*2)==0){
			angulo += 0.005;	
		}
		colaider();
		fireRate.update();
	}

	@Override
	public void draw(Canvas g) {

		Paint g2 = new Paint();
		g.drawBitmap(textura,null,new Rect((int)posicion.getX(),(int)posicion.getY(),(int)textura.getWidth()+(int)posicion.getX(),(int)textura.getHeight()+(int)posicion.getY()),g2);
	}
	private Vector2D getRecorrido(){
		nodoSeguimiento = recorrido.get(index);
		
		double distanciaDelNodo = nodoSeguimiento.substracto(getCentro()).getMagnitud();
		if(distanciaDelNodo <Constantes.UFO_RADIO_NODO){
			index++;
			if(index>=recorrido.size()){
				siguiendo = false;
			}
		}
		return fuerza(nodoSeguimiento);
	}
	private Vector2D fuerza (Vector2D vec){
		Vector2D direcionVelocidad = vec.substracto(getCentro());
		direcionVelocidad = direcionVelocidad.normalizar().aceleracion(maxVelocidad);
		return direcionVelocidad.substracto(velocidad);
	}
	@Override
	public void borrar(){
		juego.getHud().addScore(Constantes.PT_UFO);
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
		if(Hud.x2){
			juego.getOMensajes().add(new Mensaje(new Vector2D(x,y), true,"+"+Constantes.PT_UFO*2+"PTs", juego,60));
		}else {
			juego.getOMensajes().add(new Mensaje(new Vector2D(x,y), true,"+"+Constantes.PT_UFO+"PTs",  juego,60));
		}
		super.borrar();
		
	}
	
}
