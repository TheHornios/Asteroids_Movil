package com.example.ronri.estaeslabuana.estadosJuego;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import com.example.ronri.estaeslabuana.constantes.Constantes;
import com.example.ronri.estaeslabuana.graficos.Animacion;
import com.example.ronri.estaeslabuana.graficos.Assets;
import com.example.ronri.estaeslabuana.graficos.Mensaje;
import com.example.ronri.estaeslabuana.imput.Teclado;
import com.example.ronri.estaeslabuana.interfazUsuario.Botones;
import com.example.ronri.estaeslabuana.mejoras.Boom;
import com.example.ronri.estaeslabuana.mejoras.DisparoDetras;
import com.example.ronri.estaeslabuana.mejoras.DisparoPor3;
import com.example.ronri.estaeslabuana.mejoras.FireRateDown;
import com.example.ronri.estaeslabuana.mejoras.FireRateUp;
import com.example.ronri.estaeslabuana.mejoras.MasBombas;
import com.example.ronri.estaeslabuana.mejoras.MasVelocidad;
import com.example.ronri.estaeslabuana.mejoras.MasVision;
import com.example.ronri.estaeslabuana.mejoras.Mejoras;
import com.example.ronri.estaeslabuana.mejoras.MenosBombas;
import com.example.ronri.estaeslabuana.mejoras.MenosVelocidad;
import com.example.ronri.estaeslabuana.mejoras.MenosVision;
import com.example.ronri.estaeslabuana.mejoras.MilPts;
import com.example.ronri.estaeslabuana.mejoras.OneUp;
import com.example.ronri.estaeslabuana.mejoras.PuntosX2;
import com.example.ronri.estaeslabuana.mejoras.Sicosis;
import com.example.ronri.estaeslabuana.objetosJuego.Bombas;
import com.example.ronri.estaeslabuana.objetosJuego.Hud;
import com.example.ronri.estaeslabuana.objetosJuego.Meteoro;
import com.example.ronri.estaeslabuana.objetosJuego.Nave;
import com.example.ronri.estaeslabuana.objetosJuego.ObjetosMovibles;
import com.example.ronri.estaeslabuana.objetosJuego.Settings;
import com.example.ronri.estaeslabuana.objetosJuego.Tamaño;
import com.example.ronri.estaeslabuana.objetosJuego.Timer;
import com.example.ronri.estaeslabuana.objetosJuego.Ufo;
import com.example.ronri.estaeslabuana.vectores.Vector2D;

import java.util.ArrayList;

public class Juego1 extends Estados{
	private Nave nave;
	private ArrayList<ObjetosMovibles> objetosMovibles;
	private ArrayList<Animacion> animaciones;
	private ArrayList<Bombas> bombas;
	private int meteoros;
	private Hud hud;
	
	private Vector2D ufo;
	private ArrayList<Mensaje> mensajes;
	private Timer tiempo;
	public static boolean pausa;
	private Botones menu;
	private Botones menu1;
	private Botones salir;
	private Botones jugar;
	private boolean morir;
	private Botones aplicar;
	public static boolean aplicarBo;
	private boolean ordenar;
	private boolean vision;
	private Rect de;
	private Rect iz;
	private Rect up;
	private ArrayList<Mejoras> mejoras;
	private Rect sh;
	public Juego1(int i){

	}
	public Rect getDe(){
		return de;
	}public Rect getIz(){
		return iz;
	}
	public Rect getUp(){
		return up;
	}
	public Rect getSh(){
		return sh;
	}

	public Juego1(){
		Hud.x2 = false;
		objetosMovibles = new ArrayList<ObjetosMovibles>();
		nave = new Nave(new Vector2D(((double)Constantes.ANCHO/2),((double)Constantes.ALTO/2)), new Vector2D(), Assets.nave_1,Constantes.NAVE_VELOCIDAD,Assets.nave_2,this);
		objetosMovibles.add(nave);
		meteoros= 3;
		animaciones = new ArrayList<Animacion>();
		vision = false;
		hud = new Hud();
		
		menu = new Botones(Assets.boton_menu, Assets.boton_menu1, 150, 370, 5);
		menu1 = new Botones(Assets.boton_menu, Assets.boton_menu1, 290, 470, 5);
		salir = new Botones(Assets.boton_salir, Assets.boton_salir1,150, 270, 11);
		jugar = new Botones(Assets.boton_paly, Assets.boton_paly1,150, 470, 12);
		aplicar = new Botones(Assets.boton_Aplicar1, Assets.boton_Aplicar2, 290, 470, 20);
		tiempo = new Timer();
		morir = false;
		aplicarBo = false;
		ordenar =true;
		Constantes.FIRERATE = 400;
		bombas = new ArrayList<Bombas>();
		//mejoras.add(e);
		//mejoras.add(e1);
		//mejoras.add(e2);
		//mejoras.add(e3);

		mejoras = new ArrayList<Mejoras>();
		mejoras.add(new Boom(this));
		mensajes = new ArrayList<Mensaje>();
		iniciarOleada();
		Constantes.NAVE_VELOCIDAD = 7;
		Constantes.ACELERACION = 0.2;
		Settings.sicosis = false;
		de = new Rect(130, Constantes.ALTO-150-(Assets.tcla_iz.getHeight()*2), 130 + Assets.tcla_iz.getWidth(), Constantes.ALTO-150-Assets.tcla_iz.getHeight());
		iz = new Rect(30, Constantes.ALTO-100-Assets.tcla_iz.getHeight(), 30 + Assets.tcla_iz.getWidth(), Constantes.ALTO-100);

		up = new Rect(Constantes.ANCHO-Assets.tcla_iz.getWidth()-130, Constantes.ALTO-150-(Assets.tcla_iz.getHeight()*2), Constantes.ANCHO-130, Constantes.ALTO-150-Assets.tcla_iz.getHeight());
		sh = new Rect(Constantes.ANCHO-Assets.tcla_iz.getWidth()-30, Constantes.ALTO-100-Assets.tcla_iz.getHeight(), Constantes.ANCHO-30, Constantes.ALTO-100);
	}
	public ArrayList<Mensaje> getOMensajes() {
		return mensajes;
	}
	@Override
	public void draw(Canvas g) {

		Paint g2 = new Paint();
	//	System.out.println(Constantes.ANCHO+"-----------"+Constantes.ALTO);


		//g.drawBitmap(Assets.nave_1,null,new Rect(10,500,Assets.nave_1.getWidth()+10,Assets.nave_1.getHeight()+500),g2);

		if(Teclado.derecha){
			g.drawBitmap(Assets.tcla_iz1,null,de,g2);
		}else{
			g.drawBitmap(Assets.tcla_iz,null,de,g2);
		}

		if(Teclado.izquierda){
			g.drawBitmap(Assets.tcla_dere1, null, iz, g2);
		}else{
			g.drawBitmap(Assets.tcla_dere, null, iz, g2);
		}
		if(Teclado.arriba){
			g.drawBitmap(Assets.tcla_up1,null,up,g2);
		}else{
			g.drawBitmap(Assets.tcla_up,null,up,g2);
		}
		if(Teclado.tecla_e){
			g.drawBitmap(Assets.tcla_sh1,null,sh,g2);
		}else{
			g.drawBitmap(Assets.tcla_sh,null,sh,g2);
		}





	/*	if(Constantes.ACELERACION>0){
			Constantes.ACELERACION = 10;
		}*/

		hud.draw(g);
		for(int i = 0;i <mejoras.size(); i++){
			mejoras.get(i).draw(g);
		}
		for(int i = 0;i <mensajes.size(); i++){
			mensajes.get(i).draw(g);
		}
		for(int i = 0;i <bombas.size(); i++){
			bombas.get(i).draw(g);
		}
		for(int i = 0;i <objetosMovibles.size(); i++){
			objetosMovibles.get(i).draw(g);;
		}
		for(int i = 0;i <animaciones.size(); i++){
			Animacion ani = animaciones.get(i);
			g.drawBitmap(ani.getCurrentFrame(),null,new Rect((int)ani.getPosicion().getX(),(int)ani.getPosicion().getY(),
					(int)ani.getCurrentFrame().getWidth()+(int)ani.getPosicion().getX(),(int)ani.getCurrentFrame().getHeight()+(int)ani.getPosicion().getY()),g2);
		
		if(vision){
			g.drawBitmap(Assets.vision,null,new Rect((int)0,0,(int)Assets.vision.getWidth(),(int)Assets.vision.getHeight()),g2);
		}
		}
		if(pausa){
			g.drawBitmap(Assets.transparencia,null,new Rect((int)0,0,(int)Assets.transparencia.getWidth(),(int)Assets.transparencia.getHeight()),g2);
			g.drawBitmap(Assets.pausa,null,new Rect((int)120,150,(int)Assets.pausa.getWidth(),(int)Assets.pausa.getHeight()),g2);
			menu.draw(g);
			salir.draw(g);
			jugar.draw(g);
			
		}

	}
	@Override
	public void update() {

		if(!morir){ // !morir
			if(!Teclado.scape&&!pausa){
				pausa = false;
				boolean nuevaOleada = false;
				for(int i = 0; i < objetosMovibles.size(); i++){
					if(objetosMovibles.get(i) instanceof Meteoro){
						nuevaOleada = true;
					}
				}
				if(!nuevaOleada){
					iniciarOleada();
				}
				for(int i = 0;i <objetosMovibles.size(); i++){
					objetosMovibles.get(i).update();
				}
				for(int i = 0;i <bombas.size(); i++){
					bombas.get(i).update();
				}
				for(int i = 0;i <animaciones.size(); i++){
					Animacion ani = animaciones.get(i);
					ani.update();
					if(!ani.isRunning()){
						animaciones.remove(ani);
					}
				}
				boorarBombas();
				if(hud.getVidas()==0){
					morir = true;
				}
				
			}else{
				pausa = true;
				menu.update();
				salir.update();
				jugar.update();
			}	
		}else{
			Estados.setEstadoActual(new Audio_Menu(this));
		}

	}
	public void mejoras(){
		int mejora = (int)(Math.random()*16);
		int mejora2 = (int)(Math.random()*20);
		if(mejora==0){
			mejoras.add(new Boom(this));
		}
		if(mejora==1){
			mejoras.add(new DisparoPor3(this));
		}
		if(mejora==2){
			mejoras.add(new DisparoDetras(this));
		}
		if(mejora==3){
			mejoras.add(new DisparoPor3(this));
		}
		if(mejora==4){
			mejoras.add(new MasVelocidad(this));
		}
		if(mejora==5){
			mejoras.add(new MilPts(this));
		}
		if(mejora==6){
			mejoras.add(new MenosVelocidad(this));
		}
		if(mejora==7){
			mejoras.add(new Sicosis(this));
		}
		if(mejora==8){
			mejoras.add(new MilPts(this));
		}
		if(mejora==9){
			mejoras.add(new OneUp(this));
		}
		if(mejora==10){
			mejoras.add(new PuntosX2(this));
		}
		if(mejora==11){
			mejoras.add(new Sicosis(this));
		}
		if(mejora==12){
			mejoras.add(new FireRateUp(this));
		}
		if(mejora==13){
			mejoras.add(new FireRateDown(this));
		}
		if(mejora==14){
			mejoras.add(new MasBombas(this));
		}
		if(mejora==15){
			mejoras.add(new MenosBombas(this));
		}
		//11
		if(mejora2==10){
			mejora = (int)(Math.random()*16);
			if(mejora==0){
				mejoras.add(new Boom(this));
			}
			if(mejora==1){
				mejoras.add(new DisparoPor3(this));
			}
			if(mejora==2){
				mejoras.add(new DisparoDetras(this));
			}
			if(mejora==3){
				mejoras.add(new DisparoPor3(this));
			}
			if(mejora==4){
				mejoras.add(new MasVelocidad(this));
			}
			if(mejora==5){
				mejoras.add(new MilPts(this));
			}
			if(mejora==6){
				mejoras.add(new MenosVelocidad(this));
			}
			if(mejora==7){
				mejoras.add(new Sicosis(this));
			}
			if(mejora==8){
				mejoras.add(new MilPts(this));
			}
			if(mejora==9){
				mejoras.add(new OneUp(this));
			}
			if(mejora==10){
				mejoras.add(new PuntosX2(this));
			}
			if(mejora==11){
				mejoras.add(new Sicosis(this));
			}
			if(mejora==12){
				mejoras.add(new FireRateUp(this));
			}
			if(mejora==13){
				mejoras.add(new FireRateDown(this));
			}
			if(mejora==14){
				mejoras.add(new MasBombas(this));
			}
			if(mejora==15){
				mejoras.add(new MenosBombas(this));
			}
		}
	}
	public ArrayList<Mejoras> getMejoras(){
		return mejoras;
	}
	public void boorarBombas(){
		Bombas bom =crearExplosion();
		if(bom!=null){
			boom();
			animaciones.add(new Animacion(Assets.explosion2, 20,bom.getPosicion()));
			bombas.remove(bom);
		}
	}
	public Bombas crearExplosion(){
		Bombas bom = null;
		for(int i = 0;i <bombas.size(); i++){
			if(bombas.get(i).isMorir()){
				bom = bombas.get(i);
			}
		}
		return bom;
	}
	public ArrayList<ObjetosMovibles> getObjetosMovibles() {
		return objetosMovibles;
	}
	private void iniciarOleada(){
		mensajes.add(new Mensaje(new Vector2D(100,Constantes.ALTO/2), true,"RONDA"+(meteoros-2), this,200));
		double x;
		double y;
		crearUfo();
		mejoras();
		for(int i = 0;i<meteoros;i++){
			x = Math.random()*Constantes.ANCHO-100;
			y = Math.random()*Constantes.ALTO-100;
			if(nave.getPosicion().getX()+100>x&&nave.getPosicion().getX()-100<x&&nave.getPosicion().getY()+100>y&&nave.getPosicion().getY()-100<y){
				x =nave.getPosicion().getX()+260;
				y =nave.getPosicion().getY()+260;
			}
			if(ufo.getX()+100>x&&ufo.getX()-100<x&&ufo.getY()+100>y&&ufo.getY()-100<y){
				x =nave.getPosicion().getX()+400;
				y =nave.getPosicion().getY()+600;
			}
			
			Bitmap textura1 = Assets.grande[(int)(Math.random()* Assets.grande.length)];
			getObjetosMovibles().add(new Meteoro(new Vector2D(x, y),new Vector2D(0,1).setDireccion(Math.random()*Math.PI*2), textura1, Constantes.METEORO_VELOCIDAD*Math.random()+1, Tamaño.GRANDE,this));
		}
		meteoros++;
		
	}
	public void dividirMeteoros(Meteoro met){
		Tamaño tamaño = met.getTamaño();
		Tamaño newTamaño = null;
		boolean noDividir = false;
		switch (tamaño) {
		case GRANDE:
			newTamaño = Tamaño.MEDIO;
			break;
		case MEDIO:
			newTamaño = Tamaño.PEQUEÑO;
			break;
		case PEQUEÑO:
			noDividir = true;
			break;
		default:
			break;
		}
		
		if(!noDividir){
			Bitmap[] texturas = newTamaño.texturas;
			for(int i = 0; i<tamaño.cantidad;i++){
				getObjetosMovibles().add(new Meteoro(met.getPosicion(),new Vector2D(0,1).setDireccion(Math.random()*Math.PI*2), texturas[(int)(Math.random()* texturas.length)], Constantes.METEORO_VELOCIDAD*Math.random()+1, newTamaño,this));
			}
		}
	}
	public void crearUfo(){
		ufo = null;
		int rand = (int)(Math.random()*2);
		
		double x = rand;
		double y = rand;
		
		ArrayList<Vector2D> vectores = new ArrayList<Vector2D>();
		
		double siguienteX;
		double siguienteY;
		
		siguienteX = Math.random()*Constantes.ANCHO/2;
		siguienteY = Math.random()*Constantes.ALTO/2;
		vectores.add(new Vector2D(siguienteX,siguienteY));
		
		siguienteX = Math.random()*(Constantes.ANCHO/2)+Constantes.ANCHO/2;
		siguienteY = Math.random()*Constantes.ALTO/2;
		vectores.add(new Vector2D(siguienteX,siguienteY));
		
		siguienteX = Math.random()*(Constantes.ANCHO/2)+Constantes.ANCHO/2;
		siguienteY = Math.random()*(Constantes.ALTO/2)+Constantes.ALTO/2;
		vectores.add(new Vector2D(siguienteX,siguienteY));
		
		siguienteX = Math.random()*Constantes.ANCHO/2;
		siguienteY = Math.random()*(Constantes.ALTO/2)+Constantes.ALTO/2;
		vectores.add(new Vector2D(siguienteX,siguienteY));
		ufo = new Vector2D(x,y);
		objetosMovibles.add(new Ufo(ufo, new Vector2D(), Assets.ufo, Constantes.UFO_NIVEL, this,vectores));
		
		
	}
	public void crearExplosion(Vector2D pos){
		animaciones.add(new Animacion(Assets.explosion,5, pos.substracto(new Vector2D(Assets.explosion[1].getWidth()/2,Assets.explosion[1].getHeight()/2))));
	}
	public Nave getNave(){
		return nave;
	}
	public Hud getHud(){
		return hud;
	}
	private String tiempoPasado(){
		long sec =tiempo.tiempo();
		long min = sec/60;
		long hor = min/60;
		
		sec = sec%60;
		min = min%60;
		hor = hor%24;
		return ""+hor+":"+min+":"+sec;
	}
	public ArrayList<Bombas> getBombas(){
		return bombas;
	}
	public boolean boom(){
		boolean si = false;
		for(int i = 0;i <getObjetosMovibles().size(); i++){
			if(getObjetosMovibles().get(i) instanceof Meteoro){
				((Meteoro)getObjetosMovibles().get(i)).borrar();
			}else{
				if(getObjetosMovibles().get(i) instanceof Ufo){
					((Ufo)getObjetosMovibles().get(i)).borrar();
				}
			}
		}
		for(int i = 0;i <getObjetosMovibles().size(); i++){
			if(getObjetosMovibles().get(i) instanceof Meteoro){
				((Meteoro)getObjetosMovibles().get(i)).borrar();
			}else{
				if(getObjetosMovibles().get(i) instanceof Ufo){
					((Ufo)getObjetosMovibles().get(i)).borrar();
				}
			}
		}
		for(int i = 0;i <getObjetosMovibles().size(); i++){
			if(getObjetosMovibles().get(i) instanceof Meteoro){
				((Meteoro)getObjetosMovibles().get(i)).borrar();
			}else{
				if(getObjetosMovibles().get(i) instanceof Ufo){
					((Ufo)getObjetosMovibles().get(i)).borrar();
				}
			}
		}
		si = true;
		return si;
	}

	public void setVision(boolean e){
		vision = e;
	}
}
