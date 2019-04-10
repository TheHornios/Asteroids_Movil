package com.example.ronri.estaeslabuana.objetosJuego;

import android.graphics.Bitmap;

import com.example.ronri.estaeslabuana.graficos.Assets;

public enum Tamaño {
	GRANDE(2, Assets.grande),MEDIO(2, Assets.mediano),PEQUEÑO(0, Assets.pequeño);
	
	public int cantidad;
	public Bitmap[] texturas;
	
	private Tamaño(int cantidad,Bitmap[] texturas){
		this.cantidad = cantidad;
		this.texturas = texturas;
	}
}
