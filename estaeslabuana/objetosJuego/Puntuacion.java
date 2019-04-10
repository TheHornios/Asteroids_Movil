package com.example.ronri.estaeslabuana.objetosJuego;

public class Puntuacion {
	private String[] lista;
	private int[] lista2;
	private String[] listaDefinitiva;
	private boolean terminado;
	public Puntuacion(String[] e,String o){
		terminado = false;
		lista = new String[11];
		for(int i=0;i<10;i++){
			lista[i] = e[i];
		}
		lista[10] = o;
		lista2 = new int[11];
		for(int i=0;i<11;i++){
			lista2[i] = Integer.parseInt(lista[i].substring(0,lista[i].indexOf('-')));
		}
		burbuja(lista2,lista);
		listaDefinitiva = new String[10];
		for(int i=0;i<10;i++){
			listaDefinitiva[i] = lista[i];	
		}
		terminado = true;
	}
	public static void burbuja(int[] A,String[] w) {
        int i, j, aux;
        String aux2 ="";
        for (i = 0; i < A.length - 1; i++) {
            for (j = 0; j < A.length - i - 1; j++) {
                if (A[j + 1] > A[j]) {
                	aux2 = w[j + 1];
                    aux = A[j + 1];
                    w[j + 1] = w[j];
                    A[j + 1] = A[j];
                    w[j] = aux2;
                    A[j] = aux;
                }
            }
        }
	}
	public boolean isTerminado(){
		return terminado;
	}
	public String[] getLista(){
		return listaDefinitiva;
	}
}
