package com.example.ronri.estaeslabuana.graficos;

import android.graphics.Bitmap;

import com.example.ronri.estaeslabuana.vectores.Vector2D;

public class Animacion {
	private Bitmap[] frames;
	private int velocidad;
	private int index;
	private boolean runing;
	private Vector2D posicion;
	private long time, lastTime;
	
	public Animacion(Bitmap[] frames,int velocidad,Vector2D posicion){
		this.frames = frames;
		this.velocidad =velocidad;
		this.posicion = posicion; 
		index =0;
		runing = true;
		time = 0;
		lastTime = System.currentTimeMillis();
	}
	public void update(){
		time  += System.currentTimeMillis()-lastTime;
		lastTime = System.currentTimeMillis();
		if(time>velocidad){
			time = 0;
			index ++;
			if(index >=frames.length ){
				runing = false;
			}
		}
	}
	public boolean isRunning(){
		return runing;
	}
	public Vector2D getPosicion(){
		return posicion;
	}
	public Bitmap getCurrentFrame(){
		return frames[index];
	}
}
