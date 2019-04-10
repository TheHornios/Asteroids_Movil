package com.example.ronri.estaeslabuana.imput;


public class Teclado {
	public static boolean[] teclas = new boolean[256];
	public static boolean arriba;
	public static boolean derecha;
	public static boolean izquierda;
	public static boolean espacio = true;
	public static boolean scape;
	public static boolean debajo;
	public static boolean tecla_e;
	public Teclado(){
		arriba = false;
		derecha = false;
		izquierda = false;
		espacio = false;
		scape = false;
		debajo = false;
		tecla_e = false;
	}
	public void update(){

	}
	
}
