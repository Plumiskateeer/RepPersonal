package prPruebaClase;

import java.util.*;
public class Pila implements EstructuraDeDatos{

	private int[] datos;
	private int numElem;
	private static final int CIMA = 0;
	private static final int TAM = 10;
	
	public Pila() {
		datos = new int[TAM];
		numElem = 0;
	}
	
	public Pila(int tam) {
		datos  = new int [tam];
		numElem = 0;
	}
	
	public void meter(int elem) {
		
		if(numElem == datos.length) {
			int[] nuevo =  new int[datos.length*2];
			System.arraycopy(datos,  0,  nuevo, 0, numElem);
		}
		
		for(int i =  numElem-1; i>=0; i--) {
			datos[i+1] = datos[i];
		}
		
		datos[CIMA] = elem;
		numElem++;
	}
	
	public int sacar(){
		int sacado;
		
	}
	public int tamano() {
		return numElem;
	}
	
	public String toString() {
		String resul;
		if(estaVacia()) {
			resul="[";
		}else {
			resul="[";
			for(int i =0; i<numElem-1;i++) {
				resul = resul +datos[i];
			}
		}
	}
	
}
