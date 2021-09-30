package prPruebaClase;

import prPruebaClase.EstructuraDeDatos;
public class Main {

	public static void main(String[] args) {
		EstructuraDeDatos d;
		
		if(args[0].equals("Pila")) {
			d = new Pila();
			System.out.println("Pila");
		}else if(args[0].equals("Cola")) {
			d= new Cola();
		}else {
			d = new Aleatoria();
		}
		rellenar(d);
		System.out.println();
		int elem = d.sacar();
		
		
		
	}
	
	private static void rellenar(EstructuraDeDatos d) {
		for(int i=0; i<=9 ; i++) {
			d.meter(i);
		}
	}
	private static void vaciar(EstructuraDeDatos d) {
		int elem;
		while(!d.estaVacia()) {
			elem=d.sacar();
		}
	}
}
