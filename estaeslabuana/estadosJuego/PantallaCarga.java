package com.example.ronri.estaeslabuana.estadosJuego;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.example.ronri.estaeslabuana.graficos.Assets;

public class PantallaCarga extends Estados{
	private Thread hiloCarga;
	public PantallaCarga(Thread hiloCarg){
        hiloCarga = hiloCarg;
		hiloCarga.start();
	}
	@Override
	public void draw(Canvas g) {
		Paint e = new Paint();
		float porcentaje = (Assets.cantidadCargado/Assets.maximaCantidadDeAssets);
		g.drawText("Cargando.....",100,100,e);
        g.drawText(""+Assets.cantidadCargado,100,150,e);
        g.drawText(""+Assets.cargado,100,200,e);

	}
	

	@Override
	public void update() {

		if(Assets.cargado){
			Estados.setEstadoActual(new Menu_Prin());
            System.out.println("  fasdfa---------------------------------------------------------------------------");
			try{
				hiloCarga.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
		
}
