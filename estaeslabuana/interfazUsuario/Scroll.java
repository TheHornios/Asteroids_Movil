package com.example.ronri.estaeslabuana.interfazUsuario;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import com.example.ronri.estaeslabuana.imput.Raton;

public class Scroll {
	private Bitmap textura1;
	private Bitmap textura2;
	private Bitmap textura3;
	private boolean dentro;
	private Rect rectangulo;
	private int x;
	private int y;
	private int x1;
	private boolean movido;
	private boolean sonido;
	public Scroll(Bitmap textura1,Bitmap textura2,Bitmap textura3,int x,int y,int x2){
		this.textura1 = textura1;
		this.textura2 = textura2;
		this.textura3 = textura3;
		this.x = x;
		this.y = y;
		x1 =x2;
		rectangulo = new Rect(x,y,textura3.getWidth(),textura1.getHeight());
		movido = false;
		sonido = true;
	}
	public void update(){
		if(rectangulo.contains(Raton.X,Raton.Y)){
			dentro = true;
		}else{
			dentro = false;
			sonido = true;
		}
		if(dentro&&Raton.BotonPresionadoIz){
			movido = true;
			x1 = Raton.X1;
			if(Raton.X1>=(x+textura3.getWidth())-textura2.getWidth()){
				x1 = (x+textura3.getWidth())-textura2.getWidth();
			}
			if(Raton.X1<=x){
				x1 = x;
			}
		}
		
	}
	public void draw(Canvas g){

		Paint g2 = new Paint();
		g.drawBitmap(textura3,null,new Rect((int)x,(int)y,(int)textura3.getWidth(),(int)textura3.getHeight()),g2);
		if(dentro){
			g.drawBitmap(textura2,null,new Rect((int)x1,(int)y,(int)textura2.getWidth(),(int)textura2.getHeight()),g2);
		}else{
			g.drawBitmap(textura1,null,new Rect((int)x1,(int)y,(int)textura1.getWidth(),(int)textura1.getHeight()),g2);
		}
	}
	public int getPosicion(){
		return x1;
	}
	public boolean siMovido(){
		return movido;
	}
}
