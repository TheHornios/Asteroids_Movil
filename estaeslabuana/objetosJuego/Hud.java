package com.example.ronri.estaeslabuana.objetosJuego;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import com.example.ronri.estaeslabuana.constantes.Constantes;
import com.example.ronri.estaeslabuana.graficos.Assets;
import com.example.ronri.estaeslabuana.vectores.Vector2D;
public class Hud{
	private int vidas;
	private int score;
	private int bombas;
	public static boolean x2;
	
	public Hud() {
		score = 0;
		vidas = 3;
		x2 =false;
		bombas = 3;
	}

	public void update() {
		
	}
	public void menosBombas(){
		bombas--;
	}
	public void masBombas(){
		bombas++;
	}
	public void setX2(boolean e){
		x2 = e;
	}
	public void draw(Canvas g2d) {
		dibijarScore(g2d);
		dibijarVidas(g2d);
		dibijarBombas(g2d);
	}
	public void addScore(int valor){
		if(x2){
			score +=(valor*2);
		}else{
			score +=valor;
		}
		
	}
	public void addDaño(int valor){
		vidas -=valor;
	}
	private void dibijarVidas(Canvas g){
		Vector2D pos = new Vector2D(Constantes.ANCHO-Assets.nave_2.getWidth()-10,40);
		Paint g2 = new Paint();
        g2.setTextSize(60);
        g2.setColor(Color.WHITE);
        g.drawText(vidas+"X",Constantes.ANCHO-Assets.bomba.getWidth()-90,+Assets.bomba.getHeight(),g2);
		g.drawBitmap(Assets.nave_2,null,new Rect((int)pos.getX(),(int)pos.getY(),(int)Assets.nave_2.getWidth()+(int)pos.getX(),(int)Assets.nave_2.getHeight()+(int)pos.getY()),g2);
		
	}
	private void dibijarBombas(Canvas g){
		Vector2D pos = new Vector2D(Constantes.ANCHO-Assets.bomba.getWidth()-10,60+Assets.nave_2.getHeight());
		Paint g2 = new Paint();
		g2.setTextSize(60);
		g2.setColor(Color.WHITE);
		g.drawText(bombas+"X",Constantes.ANCHO-Assets.bomba.getWidth()-90,20+40+Assets.nave_2.getHeight(),g2);
		g.drawBitmap(Assets.bomba,null,new Rect((int)pos.getX(),(int)pos.getY(),(int)Assets.bomba.getWidth()+(int)pos.getX(),(int)Assets.bomba.getHeight()+(int)pos.getY()),g2);
	}
	private void dibijarScore(Canvas g){
		Paint g2 = new Paint();
		g2.setTextSize(60);
		g2.setColor(Color.WHITE);
		Vector2D pos = new Vector2D(550,25);
		String e = Integer.toString(score);

		g.drawText("PTS="+e,50,100,g2);
	}
	public int getVidas(){
		return vidas;
	}
	public int getScore(){
		return score;
	}
	public int getSbombas(){
		return bombas;
	}
	public void setVidas(){
		vidas++;
	}
	public void setPts1000(){
		if(x2){
			score +=(5000*2);
		}else{
			score +=5000;
		}
	}
}
