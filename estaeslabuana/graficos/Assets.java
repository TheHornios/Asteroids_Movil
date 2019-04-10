package com.example.ronri.estaeslabuana.graficos;

import android.graphics.Bitmap;

import com.example.ronri.estaeslabuana.GamePanel;
import com.example.ronri.estaeslabuana.R;
import com.example.ronri.estaeslabuana.estadosJuego.Estados;


public class Assets {
	public static boolean cargado = false;
	public static float cantidadCargado = 0;
	public static float maximaCantidadDeAssets = 80;
	private static GamePanel gamePanel;

	public static Bitmap nave_1;
	public static Bitmap nave_2;
	public static Bitmap disparoNave;

	public static Bitmap[] grande;
	public static Bitmap[] mediano;
	public static Bitmap[] pequeño;

	public static Bitmap[] explosion;
	public static Bitmap[] explosion2;
	public static Bitmap bomba;

	public static Bitmap ufo;

	public static Bitmap vidas;

	public static Bitmap boton1;
	public static Bitmap boton2;
	public static Bitmap boton3;
	public static Bitmap boton4;

	public static Bitmap marco;
	public static Bitmap boton_marco1;
	public static Bitmap boton_marco2;

	public static Bitmap boton_Aplicar1;
	public static Bitmap boton_Aplicar2;

	public static Bitmap scroll1;
	public static Bitmap scroll2;
	public static Bitmap scroll3;

	public static Bitmap pausa;

	public static Bitmap boton_paly;
	public static Bitmap boton_paly1;
	public static Bitmap boton_salir;
	public static Bitmap boton_salir1;
	public static Bitmap boton_menu;
	public static Bitmap boton_menu1;
	public static Bitmap boton_controles;
	public static Bitmap boton_controles1;
	public static Bitmap boton_pts;
	public static Bitmap boton_pts1;
	public static Bitmap transparencia;
	public static Bitmap teclado;
	public static Bitmap boton_mute;
	public static Bitmap boton_mute1;
	public static Bitmap boton_mute2;
	public static Bitmap boton_mute3;

	public static Bitmap rectangulo;
	public static Bitmap puntos;

	public static Bitmap mejora_1000pts;
	public static Bitmap mejora_1up;
	public static Bitmap mejora_boom;
	public static Bitmap mejora_dislexia;
	public static Bitmap mejora_disparoDetras;
	public static Bitmap mejora_laser;
	public static Bitmap mejora_masVelocidad;
	public static Bitmap mejora_menosVelocidad;
	public static Bitmap mejora_masVision;
	public static Bitmap mejora_menosVision;
	public static Bitmap mejora_disparoX2;
	public static Bitmap mejora_escudo;
	public static Bitmap mejora_ptsX2;
	public static Bitmap mejora_sicosis;

	public static Bitmap mejora_fireRateUp;
	public static Bitmap mejora_fireRateDow;
	public static Bitmap mejora_masBombas;
	public static Bitmap mejora_menosBomabas;

	public static Bitmap cursor;

	public static Bitmap vision;

	public static Bitmap tcla_dere;
	public static Bitmap tcla_iz;
	public static Bitmap tcla_up;
	public static Bitmap tcla_sh;

	public static Bitmap tcla_dere1;
	public static Bitmap tcla_iz1;
	public static Bitmap tcla_up1;
	public static Bitmap tcla_sh1;

	public static Bitmap aster_1;
	public static Bitmap ctc;
	/*
	public static Clip song_disparo;
	public static Clip song_disparo_Ufo;
	public static Clip morir_Nave;
	public static Clip destruir_Asteroide;
	public static Clip musica_Partida;

	public static Clip click;
	public static Clip song_Menu;
	public static Clip song_juego1;
	public static Clip song_juego2;
	public static Clip song_juego3;

	public static Clip mejora;

	public static Font fontOleada;
	public static Font Hud;
	public static Font Hud2;
	public static Font sonido1;
	public static Font puntiacion;

	public static Font titulo;
	*/
	public Assets(GamePanel e){
		gamePanel = e;
	}
	public void init(){
		try{

		vidas = cargaImagnes(R.drawable.vidas);
		nave_1 = cargaImagnes(R.drawable.nave);
		nave_2 = cargaImagnes(R.drawable.nave1);
		disparoNave = cargaImagnes(R.drawable.disparo);

		boton1 = cargaImagnes(R.drawable.boton1);
		boton2 =cargaImagnes(R.drawable.boton2);
		boton3 = cargaImagnes(R.drawable.boton4);
		boton4 =cargaImagnes(R.drawable.boton3);
			//

		boton_paly =cargaImagnes(R.drawable.b_jugar);
		boton_paly1 =cargaImagnes(R.drawable.b_jugar1);
		boton_salir =cargaImagnes(R.drawable.b_salir);
		boton_salir1 =cargaImagnes(R.drawable.b_salir1);
		boton_menu=cargaImagnes(R.drawable.b_menu);
		boton_menu1 =cargaImagnes(R.drawable.b_menu1);
		boton_mute =cargaImagnes(R.drawable.mute);
		boton_mute1=cargaImagnes(R.drawable.mute1);
		boton_mute2=cargaImagnes(R.drawable.mute2);
		boton_mute3=cargaImagnes(R.drawable.mute4);
		boton_controles=cargaImagnes(R.drawable.boton_con);
		boton_controles1=cargaImagnes(R.drawable.boton_con1);
		boton_pts=cargaImagnes(R.drawable.pts_1);
		boton_pts1=cargaImagnes(R.drawable.pts_2);



		scroll1 =cargaImagnes(R.drawable.scroll);
		scroll2 =cargaImagnes(R.drawable.scroll2);
		scroll3 =cargaImagnes(R.drawable.barra);
		boton_Aplicar1=cargaImagnes(R.drawable.aplicar1);
		boton_Aplicar2=cargaImagnes(R.drawable.aplicar2);
		cursor =cargaImagnes(R.drawable.cursor);
		transparencia=cargaImagnes(R.drawable.trans);
		pausa=cargaImagnes(R.drawable.pausa);
		marco=cargaImagnes(R.drawable.marco);
		boton_marco1 =cargaImagnes(R.drawable.boton1_son);
		boton_marco2 =cargaImagnes(R.drawable.boton2_son);
		teclado=cargaImagnes(R.drawable.teclado);
		rectangulo=cargaImagnes(R.drawable.rectangulo);
		puntos=cargaImagnes(R.drawable.puntos);

		vision=cargaImagnes(R.drawable.vision);

		mejora_1000pts=cargaImagnes(R.drawable.epts);
		mejora_1up=cargaImagnes(R.drawable.e1up);
		mejora_boom=cargaImagnes(R.drawable.boom);
		mejora_dislexia=cargaImagnes(R.drawable.dislexia);
		mejora_disparoDetras=cargaImagnes(R.drawable.disparodetras);
		mejora_masVelocidad=cargaImagnes(R.drawable.masvision);
		mejora_menosVelocidad=cargaImagnes(R.drawable.menosvelocidad);
		mejora_masVision=cargaImagnes(R.drawable.masvision);
		mejora_menosVision=cargaImagnes(R.drawable.menosvision);
		mejora_disparoX2=cargaImagnes(R.drawable.x2);
		mejora_escudo=cargaImagnes(R.drawable.escudo);
		mejora_ptsX2=cargaImagnes(R.drawable.ptsx2);
		mejora_sicosis=cargaImagnes(R.drawable.sicosis);
		bomba=cargaImagnes(R.drawable.bomba);

		mejora_fireRateUp=cargaImagnes(R.drawable.tiersup);
		mejora_fireRateDow=cargaImagnes(R.drawable.tiersdown);
		mejora_masBombas=cargaImagnes(R.drawable.bombasmas);
		mejora_menosBomabas=cargaImagnes(R.drawable.bombasmenos);

		explosion2= new Bitmap[3];
		grande = new Bitmap[3];
		mediano = new Bitmap[3];
		pequeño = new Bitmap[3];

		explosion = new Bitmap[4];

		explosion2[0] = cargaImagnes(R.drawable.explosion1);
		explosion2[1] = cargaImagnes(R.drawable.explosion2);
		explosion2[2] = cargaImagnes(R.drawable.explosion3);

		grande[0] = cargaImagnes(R.drawable.big_1);
		grande[1] = cargaImagnes(R.drawable.big_2);
		grande[2] = cargaImagnes(R.drawable.big_3);

		mediano[0] = cargaImagnes(R.drawable.norma_1);
		mediano[1] = cargaImagnes(R.drawable.norma_2);
		mediano[2] = cargaImagnes(R.drawable.norma_3);

		pequeño[0] = cargaImagnes(R.drawable.small_1);

		pequeño[1] = cargaImagnes(R.drawable.small_2);

		pequeño[2] = cargaImagnes(R.drawable.small_3);
			System.out.print("-------------------eeeee-----------------------------------");
		explosion[0] = cargaImagnes(R.drawable.explosion_1);
		explosion[1] = cargaImagnes(R.drawable.explosion_2);
		explosion[2] = cargaImagnes(R.drawable.explosion_3);
		explosion[3] = cargaImagnes(R.drawable.explosion_4);

		ufo = cargaImagnes(R.drawable.ufo);


		tcla_dere = cargaImagnes(R.drawable.derecha_pan);
		tcla_iz = cargaImagnes(R.drawable.izquierda_pan);
		tcla_up = cargaImagnes(R.drawable.arriba_pan);
		tcla_sh = cargaImagnes(R.drawable.dispar_pan);

		tcla_dere1 = cargaImagnes(R.drawable.derecha_pan1);
		tcla_iz1 = cargaImagnes(R.drawable.izquierda_pan1);
		tcla_up1 = cargaImagnes(R.drawable.arriba_pan1);
		tcla_sh1 = cargaImagnes(R.drawable.dispar_pan1);

		aster_1= cargaImagnes(R.drawable.aster_1);

		ctc= cargaImagnes(R.drawable.ctc);
		System.out.print("------------------------------------------------------");
		cargado = true;

		/*
		if(!Buffers.noSonido){
			song_disparo = cargaSonido("/sonidos/disparo.wav");
			song_disparo_Ufo = cargaSonido("/sonidos/disparo_UFO.wav");
			morir_Nave = cargaSonido("/sonidos/morir.wav");
			destruir_Asteroide = cargaSonido("/sonidos/asteroide.wav");
			musica_Partida = cargaSonido("/sonidos/musica.wav");

			click = cargaSonido("/sonidos/cli.wav");
			song_Menu  = cargaSonido("/sonidos/musica/New Hope.wav");
			song_juego1  = cargaSonido("/sonidos/musica/Never Surrender.wav");

			song_juego2  = cargaSonido("/sonidos/musica/Common Fight.wav");
			song_juego3 = cargaSonido("/sonidos/musica/Boss Fight.wav");
			mejora = cargaSonido("/sonidos/mejora.wav");
		}

		fontOleada = cargaFont("/fonts/alien_encounters/Alien-Encounters-Bold.ttf",44);
		Hud= cargaFont("/fonts/una/Hyperspace.otf",25);
		Hud2 = cargaFont("/fonts/una/Hyperspace.otf",15);
		sonido1= cargaFont("/fonts/una/Hyperspace.otf",40);
		titulo= cargaFont("/fonts/una/Hyperspace Bold.otf",80);
		puntiacion= cargaFont("/fonts/una/Vectorb.ttf",20);

		*/

		}catch(Exception e){
		}
	}
	public static Bitmap cargaImagnes(int path){
		cantidadCargado++;
		return gamePanel.cargaImagenesEnBuffer(path);
	}
	/*
	public static Clip cargaSonido(String path){
		cantidadCargado++;
		return buffer.cargaDeSonidos(path);
	}
	public static Font cargaFont(String path,int a){
		cantidadCargado++;
		return buffer.cargaFont(path, a);
	}*/
}
