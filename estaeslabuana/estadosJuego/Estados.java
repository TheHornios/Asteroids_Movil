package com.example.ronri.estaeslabuana.estadosJuego;

import android.graphics.Canvas;


public abstract class Estados {
	private static Estados estadoActual = null;

	public static Estados getEstadoActual() {
		return estadoActual;
	}

	public static void setEstadoActual(Estados estadoActual) {
		Estados.estadoActual = estadoActual;
	}
	public abstract void draw(Canvas g);
	public abstract void update();
}
