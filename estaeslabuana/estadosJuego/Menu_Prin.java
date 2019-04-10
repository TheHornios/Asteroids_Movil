package com.example.ronri.estaeslabuana.estadosJuego;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import com.example.ronri.estaeslabuana.constantes.Constantes;
import com.example.ronri.estaeslabuana.graficos.Assets;
import com.example.ronri.estaeslabuana.objetosJuego.Meteoro;
import com.example.ronri.estaeslabuana.objetosJuego.Tamaño;
import com.example.ronri.estaeslabuana.vectores.Vector2D;

import java.util.ArrayList;

public class Menu_Prin extends Estados{
	private Rect play;
	private ArrayList<Meteoro> ese = new ArrayList<>();
	public Menu_Prin(){
		play = new Rect(200,(Constantes.ALTO/2)-Assets.boton_paly.getHeight(),Constantes.ANCHO-200,(Constantes.ALTO/2));
		crearAsteroidesFondo();
	}
	@Override
	public void draw(Canvas g) {
		Paint g2 = new Paint();
		g2.setColor(Color.WHITE);
		Rect e = new Rect(50,150,Constantes.ANCHO-50,150+Assets.aster_1.getHeight());
		g.drawBitmap(Assets.aster_1,null,e,g2);

		Rect e1 = new Rect(150,Constantes.ALTO-100-Assets.ctc.getHeight(),Constantes.ANCHO-150,Constantes.ALTO-100);
		g.drawBitmap(Assets.ctc,null,e1,g2);


		g.drawBitmap(Assets.boton_paly,null,play,g2);

		for(int i = 0;i <ese.size(); i++){
			ese.get(i).draw(g);
		}
	}

	@Override
	public void update() {
		for(int i = 0;i <ese.size(); i++){
			ese.get(i).update();
		}
	}
	public Rect getPlay(){
	    return play;
    }
	public void crearAsteroidesFondo(){
		double x;
		double y;
		for(int i = 0;i<15;i++){
			x = Math.random()*Constantes.ANCHO-100;
			y = Math.random()*Constantes.ALTO-100;
			int tam =(int)(Math.random()*3);
			Bitmap textura1 = null;
			if(tam == 0){
				textura1 = Assets.grande[(int)(Math.random()* Assets.grande.length)];
			}
			if(tam == 1){
				textura1 = Assets.mediano[(int)(Math.random()* Assets.grande.length)];
			}
			if(tam == 2){
				textura1 = Assets.pequeño[(int)(Math.random()* Assets.grande.length)];
			}

			ese.add(new Meteoro(new Vector2D(x, y),new Vector2D(0,1).setDireccion(Math.random()*Math.PI*2), textura1, Constantes.METEORO_VELOCIDAD*Math.random()+1, Tamaño.GRANDE,new Juego1(1)));
		}

	}
}
