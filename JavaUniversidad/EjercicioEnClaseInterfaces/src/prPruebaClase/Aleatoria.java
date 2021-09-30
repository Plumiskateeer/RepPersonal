package prPruebaClase;

import java.util.*;
public class Aleatoria implements EstructuraDeDatos{

	private static final Random rnd = new Random();
	private int[] datos;
	private int numElem;
	private static final int TAM = 10;
	
	public Aleatoria() {
		datos = new int[TAM];
		numElem = 0;
	}
	
	public Aleatoria(int tam) {
		datos  = new int [tam];
		numElem = 0;
	}
	public int tamaño() {
		return numElem;
	}
	
	public void meter(int elem) {
		int pos =  rnd.nextInt(this.tamaño()+1);

		if(numElem == datos.length) {
			int[] nuevo =  new int[datos.length*2];
			System.arraycopy(datos,  0,  nuevo, 0, numElem);
		}
		
		for(int i =  numElem-1; i>=0; i--) {
			datos[i+1] = datos[i];
		}
		
		datos[pos] = elem;
		numElem++;
	}
	
	public int sacar() {
		int sacado;
		int pos= rnd.nextInt(this.tamaño());
		
	}
	
	
	
	
}