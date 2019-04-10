package com.example.ronri.estaeslabuana.objetosJuego;

public class Timer {
	long antes;
	long ahora,dif;
	public Timer(){
		antes = System.nanoTime();
	}
	public long tiempo(){
		ahora = System.nanoTime();
		dif = ahora-antes;
		return dif/1000000000;
	}
}
