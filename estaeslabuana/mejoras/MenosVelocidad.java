package com.example.ronri.estaeslabuana.mejoras;


import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import com.example.ronri.estaeslabuana.constantes.Constantes;
import com.example.ronri.estaeslabuana.estadosJuego.Juego1;
import com.example.ronri.estaeslabuana.graficos.Assets;
import com.example.ronri.estaeslabuana.graficos.Mensaje;
import com.example.ronri.estaeslabuana.vectores.Vector2D;

public class MenosVelocidad  extends Mejoras{
	public MenosVelocidad(Juego1 juego) {
		super(juego);
		setTextura(Assets.mejora_menosVelocidad);
		setPosicion((int)((Math.random()*500)+100),(int)((Math.random()*500)+100));
		colision = false;
	}
	@Override
	public void update() {
		
	}
	@Override
	public void draw(Canvas g) {

		Paint g2 = new Paint();
		g2.setColor(Color.WHITE);

		Rect e = new Rect((int)posicionMejora.getX(),(int)posicionMejora.getY(),Assets.mejora_boom.getWidth()+(int)posicionMejora.getX(),Assets.mejora_boom.getHeight()+(int)posicionMejora.getY());
		g.drawBitmap(textura,null,e,g2);		if(box.intersect(nave.getBox())){
			juego.crearExplosion(new Vector2D(posicionMejora.getX(),posicionMejora.getY()));
			Constantes.ACELERACION = Constantes.ACELERACION-0.1;
			if(Constantes.ACELERACION == 0.1){
				Constantes.ACELERACION=0.1;
			}
			Constantes.NAVE_VELOCIDAD = Constantes.NAVE_VELOCIDAD-2;
			juego.getOMensajes().add(new Mensaje(new Vector2D(posicionMejora.getX(),posicionMejora.getY()), true, "Menos Velocidad", juego,60));
			juego.getMejoras().remove(this);
		}
	}
}
