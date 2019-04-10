package com.example.ronri.estaeslabuana.objetosJuego;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.RotateDrawable;
import android.widget.ImageView;

import com.example.ronri.estaeslabuana.constantes.Constantes;
import com.example.ronri.estaeslabuana.estadosJuego.Juego1;
import com.example.ronri.estaeslabuana.graficos.Assets;
import com.example.ronri.estaeslabuana.imput.Teclado;
import com.example.ronri.estaeslabuana.vectores.Vector2D;

public class Nave extends ObjetosMovibles{
	private Vector2D direccion;
	private Vector2D movimiento;
	private Bitmap textura2;
	private boolean isAceleracion;
	private Juego1 juego;
	private Cronometro fireRate;
	private Cronometro animacion;
	private boolean spawn;
	private boolean visible;
	private Cronometro spawn_Time;
	private Cronometro spawn_Visible;
	private Cronometro bombas_timer;
	private Rect box;
	private boolean detras;
	private boolean triple;
	private boolean triple2;
	private boolean dislexia;
	public float girarNave;
	public Nave(Vector2D posicion, Vector2D velocidad, Bitmap textura,double maxVelocidad,Bitmap textura2,Juego1 estado) {
		super(posicion, velocidad, textura,maxVelocidad,estado);
		direccion = new Vector2D(0,1);
		movimiento = new Vector2D();
		this.textura2 = textura2;
		isAceleracion = false;
		this.juego = estado; 
		fireRate = new Cronometro();
		animacion = new Cronometro();
		bombas_timer = new Cronometro();
		spawn_Time = new Cronometro();
		spawn_Visible =  new Cronometro();
		box = new Rect((int)posicion.getX(),(int)posicion.getY(),textura.getWidth(),textura.getHeight());
		dislexia = false;
	}

	@Override
	public void update() {
		box.set((int)posicion.getX(),(int)posicion.getY(),textura.getWidth()+(int)posicion.getX(),textura.getHeight()+(int)posicion.getY());
		if(!(spawn_Time.isEncendido())){
			spawn = false;
			visible = true;
		}
		if(spawn){
			if(!(spawn_Visible.isEncendido())){
				spawn_Visible.run(Constantes.INVISIBLE);
				visible = !visible;
			}
		}
		if(Teclado.tecla_e&&!bombas_timer.isEncendido()&&!spawn&&juego.getHud().getSbombas()!=0){
			juego.getBombas().add(new Bombas(posicion, Assets.bomba, juego));
			bombas_timer.run(Constantes.FIRERATE_BOMBAS);
			juego.getHud().menosBombas();
		}
		if(Teclado.espacio&&!fireRate.isEncendido()&&!spawn){
			juego.getObjetosMovibles().add(new Disparos(getCentro(), direccion, Assets.disparoNave, Constantes.DISPARO_VELOCIDAD, angulo,juego,true));
			if(detras){
				juego.getObjetosMovibles().add(new Disparos(getCentro(), new Vector2D(-direccion.getX(),-direccion.getY()), Assets.disparoNave, Constantes.DISPARO_VELOCIDAD, angulo,juego,true));
			}
			if(triple){
				juego.getObjetosMovibles().add(new Disparos(getCentro(), new Vector2D(direccion.getX()+0.2,direccion.getY()), Assets.disparoNave, Constantes.DISPARO_VELOCIDAD, angulo,juego,true));
				juego.getObjetosMovibles().add(new Disparos(getCentro(), new Vector2D(direccion.getX()-0.2,direccion.getY()), Assets.disparoNave, Constantes.DISPARO_VELOCIDAD, angulo,juego,true));
				if(triple2){
					juego.getObjetosMovibles().add(new Disparos(getCentro(), new Vector2D(direccion.getX()+0.4,direccion.getY()), Assets.disparoNave, Constantes.DISPARO_VELOCIDAD, angulo,juego,true));
					juego.getObjetosMovibles().add(new Disparos(getCentro(), new Vector2D(direccion.getX()-0.4,direccion.getY()), Assets.disparoNave, Constantes.DISPARO_VELOCIDAD, angulo,juego,true));
					juego.getObjetosMovibles().add(new Disparos(getCentro(), new Vector2D(direccion.getX()+0.6,direccion.getY()), Assets.disparoNave, Constantes.DISPARO_VELOCIDAD, angulo,juego,true));
					
				}
				if(detras){
					juego.getObjetosMovibles().add(new Disparos(getCentro(), new Vector2D(-(direccion.getX()+0.2),-direccion.getY()), Assets.disparoNave, Constantes.DISPARO_VELOCIDAD, angulo,juego,true));
					juego.getObjetosMovibles().add(new Disparos(getCentro(), new Vector2D(-(direccion.getX()-0.2),-direccion.getY()), Assets.disparoNave, Constantes.DISPARO_VELOCIDAD, angulo,juego,true));
					if(triple2){
						juego.getObjetosMovibles().add(new Disparos(getCentro(), new Vector2D(-(direccion.getX()+0.4),-direccion.getY()), Assets.disparoNave, Constantes.DISPARO_VELOCIDAD, angulo,juego,true));
						juego.getObjetosMovibles().add(new Disparos(getCentro(), new Vector2D(-(direccion.getX()-0.4),-direccion.getY()), Assets.disparoNave, Constantes.DISPARO_VELOCIDAD, angulo,juego,true));
						juego.getObjetosMovibles().add(new Disparos(getCentro(), new Vector2D(-(direccion.getX()+0.6),-direccion.getY()), Assets.disparoNave, Constantes.DISPARO_VELOCIDAD, angulo,juego,true));
					}
				}
			}
			fireRate.run(Constantes.FIRERATE);
		}
		if(!dislexia){
			if(Teclado.derecha){
				angulo += Constantes.VELOCIDADANGULO;
			}
			if(Teclado.izquierda){
				angulo -= Constantes.VELOCIDADANGULO;;
			}
			if(Teclado.arriba){
					movimiento = direccion.aceleracion(Constantes.ACELERACION);
					isAceleracion = true;
			}else{
				if(movimiento.getMagnitud()!=0){
					movimiento = (velocidad.aceleracion(-10).normalizar()).aceleracion(Constantes.ACELERACION*1);
					isAceleracion = false;
				}
			}
		}else{
			if(Teclado.izquierda){
				angulo += Constantes.VELOCIDADANGULO;
			}
			if(Teclado.derecha){
				angulo -= Constantes.VELOCIDADANGULO;;
			}
			if(Teclado.debajo){
				movimiento = direccion.aceleracion(Constantes.ACELERACION);
				isAceleracion = true;
			}else{
				if(movimiento.getMagnitud()!=0){
					movimiento = (velocidad.aceleracion(-5).normalizar()).aceleracion(Constantes.ACELERACION/5);
					isAceleracion = false;
				}
			}
		}
		
		velocidad = velocidad.add(movimiento);
		velocidad = velocidad.limite(maxVelocidad/2);
		
		direccion = direccion.setDireccion(angulo - Math.PI/2);
		
		posicion = posicion.add(velocidad);
		
		if(posicion.getX() > Constantes.ANCHO){
			posicion.setX(-ancho);
		}
		if(posicion.getY() > Constantes.ALTO){
			posicion.setY(-alto);
		}
		if(posicion.getX() < -ancho){
			posicion.setX(Constantes.ANCHO);
		}
		if(posicion.getY() < -alto){
			posicion.setY(Constantes.ALTO);
		}
		fireRate.update();
		animacion.update();
		spawn_Time.update();
		spawn_Visible.update();
		bombas_timer.update();
		colaider();
	}
    public void setAngulo(double e){
        angulo = e;
    }
    public double getAngulo(){
       return angulo ;
    }
	@Override
	public void draw(Canvas g) {
		Paint g2 = new Paint();
		g2.setColor(Color.WHITE);

		if(visible){



			Rect e = new Rect((int)posicion.getX(),(int)posicion.getY(),Assets.nave_1.getHeight()+(int)posicion.getX(),Assets.nave_1.getHeight()+(int)posicion.getY());

            g.drawBitmap(rotateBitmap(Assets.nave_1,(float) angulo*57,g),null,e,g2);
           // g.drawRect(new Rect((int)posicion.getX(),(int)posicion.getY(),Assets.nave_1.getHeight()+(int)posicion.getX(),Assets.nave_1.getHeight()+(int)posicion.getY()),g2);
			if(isAceleracion&&!animacion.isEncendido()){
				g.drawBitmap(rotateBitmap(Assets.nave_2,(float) angulo*57,g),null,e,g2);
				animacion.run(Constantes.COLA);
			}	
		}
		
	}
    public Bitmap rotateBitmap(Bitmap original, float degrees,Canvas e) {

        int width = original.getHeight();
        int height = original.getHeight();

        Matrix matrix = new Matrix();
        //matrix.preRotate(degrees);
		matrix.setRotate(degrees);
		Bitmap scaledBitmap = Bitmap.createScaledBitmap(original, width, height,true);

        Bitmap rotatedBitmap = Bitmap.createBitmap(scaledBitmap, 0, 0, width, height, matrix, true);

        return rotatedBitmap;
    }
	public void borrar(){
		spawn = true;
		spawn_Time.run(Constantes.SPAWN);
		juego.getHud().addDaño(1);
		if(juego.getHud().getVidas()==0){
			super.borrar();
		}
	}
	public boolean isSpawn(){
		return spawn;
	}
	public Rect getBox(){
		return box;
	}
	public void setDetras(boolean si){
		detras = si;
	}
	public void setTriple(boolean si){
		triple = si;
	}
	public void setTriple2(boolean si){
		triple2 = si;
	}
	public boolean idTriple(){
		return triple;
	}
	public boolean isDislexia(){
		return dislexia;
	}
	public void setDislexia(boolean si){
		dislexia = si;
	}

}
