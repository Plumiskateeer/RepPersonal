package prColeccion;
import java.util.*;

public class Coleccion {
	
	private static int TAM = 10;
	private static int [] enteros;
	
	public Coleccion(){
		enteros  = new int[TAM];
		
	}
	
	public Coleccion(int tam) {
		
		
		if (tam>0)
		{
			enteros  = new int[tam];
		}
		else
		{
			throw  new RuntimeException();
		}
	}
	
	public static int getNumElem() {
		return enteros.length;
	}
	public static int getElem(int i) {
		return enteros[i];
	}
	public static boolean sinElementos() {
		boolean comprobar = false;
		if(enteros.length == 0) {
			comprobar = true;
		}
		return comprobar;
	}
	public static void vacia() {
		
		for(int i = 0; i <= enteros.length;i++) {
			enteros[i]= 0;
		}
		
	}
	public static void añade(int elemen) {
		enteros.add(elemen);
	}
	public static void elimina(int elem) {
		
	}
	public static boolean contiene(int elem) {
		
	}
	public static String toString() {
		
	}

}
	
