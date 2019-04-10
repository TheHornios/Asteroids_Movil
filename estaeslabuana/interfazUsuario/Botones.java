package com.example.ronri.estaeslabuana.interfazUsuario;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import com.example.ronri.estaeslabuana.estadosJuego.Audio_Menu;
import com.example.ronri.estaeslabuana.estadosJuego.Controles;
import com.example.ronri.estaeslabuana.estadosJuego.Estados;
import com.example.ronri.estaeslabuana.estadosJuego.Juego1;
import com.example.ronri.estaeslabuana.estadosJuego.Menu_Prin;
import com.example.ronri.estaeslabuana.estadosJuego.Puntuaciones;
import com.example.ronri.estaeslabuana.imput.Raton;
import com.example.ronri.estaeslabuana.objetosJuego.Settings;
import com.example.ronri.estaeslabuana.vectores.Vector2D;


public class Botones {
	private Bitmap clik1;
	private Bitmap clik2;
	private boolean mouseDentro;
	private Rect colisiones;
	private int aciontBoton;
	private int vol1;
	private int vol2;
	private int vol3;
	private int vol4;
	private boolean sonido;
	public Botones(Bitmap clik1,Bitmap clik2,int x,int y,int i){
		this.clik1 = clik1;
		this.clik2 = clik2;
		colisiones= new Rect(x,y,clik2.getWidth(),clik2.getHeight());
		aciontBoton = i;
		sonido = true;
	}
	public void update(){
		if(colisiones.contains(Raton.X,Raton.Y)){
			mouseDentro = true;
		}else{
			mouseDentro = false;
			sonido = true;
		}
		if(mouseDentro&&Raton.BotonPresionadoIz && aciontBoton==1){
			Estados.setEstadoActual(new Juego1());
			
		}
		if(mouseDentro&&Raton.BotonPresionadoIz && aciontBoton==2){
		//	Estados.setEstadoActual(new Audio_Menu());
		}
		if(mouseDentro&&Raton.BotonPresionadoIz && aciontBoton==3){
			Estados.setEstadoActual(new Menu_Prin());
		}
		if(mouseDentro&&Raton.BotonPresionadoIz && aciontBoton==4){
			Settings.maestro_Menu = vol1;
			Settings.efectos_Menu = vol2;
			Settings.maestro_juego = vol3;
			Settings.efectos_juego = vol4;
		}
		if(mouseDentro&&Raton.BotonPresionadoIz && aciontBoton==5){
			Juego1.pausa = false;
			Estados.setEstadoActual(new Menu_Prin());
		}
		if(mouseDentro&&Raton.BotonPresionadoIz && aciontBoton==7){
			Juego1.pausa = false;
			Estados.setEstadoActual(new Controles());
		}
		if(mouseDentro&&Raton.BotonPresionadoIz && aciontBoton==8){
			Estados.setEstadoActual(new Menu_Prin());
		}
		if(mouseDentro&&Raton.BotonPresionadoIz && aciontBoton==9){	
			Estados.setEstadoActual(new Puntuaciones());
		}
		if(mouseDentro&&Raton.BotonPresionadoIz && aciontBoton==12){
			Juego1.pausa = false;
		}
		if(mouseDentro&&Raton.BotonPresionadoIz && aciontBoton==11){
			System.exit(0);
		}
		if(mouseDentro&&Raton.BotonPresionadoIz && aciontBoton==13){
			Settings.volumen = true;
			
		}
		if(mouseDentro&&Raton.BotonPresionadoIz && aciontBoton==14){
			Settings.volumen = false; 
		}
		if(mouseDentro&&Raton.BotonPresionadoIz && aciontBoton==20){
			Juego1.aplicarBo = true;
		}
		if(mouseDentro&&Raton.BotonPresionadoIz && aciontBoton==21){
			Estados.setEstadoActual(new Menu_Prin());
		}
		if(mouseDentro&&Raton.BotonPresionadoIz && aciontBoton==25){
			Estados.setEstadoActual(new Menu_Prin());
		}
	}
	public void draw(Canvas g){

		Paint g2 = new Paint();

		if(mouseDentro){
			g.drawBitmap(clik2,null,new Rect((int)colisiones.left,(int)colisiones.top,(int)clik2.getWidth(),(int)clik2.getHeight()),g2);
		}else{
			g.drawBitmap(clik1,null,new Rect((int)colisiones.left,(int)colisiones.top,(int)clik2.getWidth(),(int)clik2.getHeight()),g2);
		}
	}
	public int getX(){
		return colisiones.left;
	}
	public void setEjeXeY(int x,int y){
		colisiones.set(x, y, clik2.getWidth(), clik2.getHeight());
	}
	public Vector2D getCentre(){
		return new Vector2D((colisiones.left+30),(colisiones.top+10));
	}
	public int getVol1() {
		return vol1;
	}
	public void setVol1(int vol1) {
		this.vol1 = vol1;
	}
	public int getVol2() {
		return vol2;
	}
	public void setVol2(int vol2) {
		this.vol2 = vol2;
	}
	public int getVol3() {
		return vol3;
	}
	public void setVol3(int vol3) {
		this.vol3 = vol3;
	}
	public void setVol4(int vol4) {
		this.vol4 = vol4;
	}
}
