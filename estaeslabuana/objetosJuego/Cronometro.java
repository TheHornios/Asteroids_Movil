package com.example.ronri.estaeslabuana.objetosJuego;

public class Cronometro {
	private long delta;
	private long ultimoTiempo;
	private long tiempo;
	private boolean encendido;
	public Cronometro(){
		delta = 0;
		ultimoTiempo = System.currentTimeMillis();
		encendido = false;
	}
	public void run(long time){
		encendido = true;
		tiempo = time;
	}
	public void update(){
		if(encendido){
			delta += System.currentTimeMillis() - ultimoTiempo;
		}
		if(delta >= tiempo){
			encendido = false;
			delta = 0;
		}
		ultimoTiempo = System.currentTimeMillis();
	}
	public boolean isEncendido(){
		return encendido;
	}
	public long getDelta(){
		return delta;
	}
}
