package com.example.ronri.estaeslabuana.objetosJuego;

public class Settings {
	public static int maestro_Menu = 220;
	public static int maestro_juego= 220;
	public static int efectos_juego= 350;
	public static int efectos_Menu= 350;
	public static boolean volumen= true;
	public static boolean sicosis = false;
	public static int getMaestro_juego(){
		int valor = 0;
		if(maestro_juego==50&&maestro_juego<=100){
			valor = -69;
		}
		if(maestro_juego>100&&maestro_juego<=150){
			valor = -39;
		}
		if(maestro_juego>150&&maestro_juego<=200){
			valor = -20;
		}
		if(maestro_juego>200&&maestro_juego<=250){
			valor = -10;
		}
		if(maestro_juego>250&&maestro_juego<=300){
			valor = -5;
		}
		if(maestro_juego>300&&maestro_juego<=350){
			valor = 0;
		}
		if(maestro_juego>350&&maestro_juego<=400){
			valor = 3;
		}
		if(maestro_juego>400&&maestro_juego<=450){
			valor = 6;
		}
		return valor;
	}
	public static int getEfectos_Menu(){
		int valor = 0;
		if(efectos_Menu==50&&efectos_Menu<=100){
			valor = -69;
		}
		if(efectos_Menu>100&&efectos_Menu<=150){
			valor = -39;
		}
		if(efectos_Menu>150&&efectos_Menu<=200){
			valor = -20;
		}
		if(efectos_Menu>200&&efectos_Menu<=250){
			valor = -10;
		}
		if(efectos_Menu>250&&efectos_Menu<=300){
			valor = -5;
		}
		if(efectos_Menu>300&&efectos_Menu<=350){
			valor = 0;
		}
		if(efectos_Menu>350&&efectos_Menu<=400){
			valor = 3;
		}
		if(efectos_Menu>400&&efectos_Menu<=450){
			valor = 6;
		}
		return valor;
	}
	public static int getEfectos_juego(){
		int valor = 0;
		if(efectos_juego==50&&efectos_juego<=100){
			valor = -69;
		}
		if(efectos_juego>100&&efectos_juego<=150){
			valor = -39;
		}
		if(efectos_juego>150&&efectos_juego<=200){
			valor = -20;
		}
		if(efectos_juego>200&&efectos_juego<=250){
			valor = -10;
		}
		if(efectos_juego>250&&efectos_juego<=300){
			valor = -5;
		}
		if(efectos_juego>300&&efectos_juego<=350){
			valor = 0;
		}
		if(efectos_juego>350&&efectos_juego<=400){
			valor = 3;
		}
		if(efectos_juego>400&&efectos_juego<=450){
			valor = 6;
		}
		return valor;
	}
	public static int getMaestro_Menu(){
		int valor = -10;
		if(maestro_Menu==50&&maestro_Menu<=100){
			valor = -69;
		}
		if(maestro_Menu>100&&maestro_Menu<=150){
			valor = -39;
		}
		if(maestro_Menu>150&&maestro_Menu<=200){
			valor = -20;
		}
		if(maestro_Menu>200&&maestro_Menu<=250){
			valor = -10;
		}
		if(maestro_Menu>250&&maestro_Menu<=300){
			valor = -5;
		}
		if(maestro_Menu>300&&maestro_Menu<=350){
			valor = 0;
		}
		if(maestro_Menu>350&&maestro_Menu<=400){
			valor = 3;
		}
		if(maestro_Menu>400&&maestro_Menu<=450){
			valor = 6;
		}
		return valor;
	}
}
