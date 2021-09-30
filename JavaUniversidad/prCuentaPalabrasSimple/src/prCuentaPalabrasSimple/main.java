package prCuentaPalabrasSimple;

import java.io.*;
import java.util.NoSuchElementException;
import palabras.*;

public class main {

		public static void main(String [] args) {
			String [] datos = {	
				"Guerra tenía una jarra y Parra tenía una perra, ",
				"pero la perra de Parra rompió la jarra de Guerra.",
				"Guerra pegó con la porra a la perra de Parra. ",
				"¿Oiga usted buen hombre de Parra! ",
				"Por qué ha pegado con la porra a la perra de Parra.",
				"Porque si la perra de Parra no hubiera roto la jarra de Guerra,",
				"Guerra no hubiera pegado con la porra a la perra de Parra."};
			
			String delimitadores = "[ .,:;\\-\\!\\¿\\¡\\?]+";    
												
			 
			String [] noSig = {"CON", "LA", "A", "DE", "NO", "SI", "Y", "UNA"};
			ContadorPalabras contador = null, contadorSig = null;

			try {
				int n = Integer.parseInt(args[0]);
				System.out.println("Con argumento " + n);
				contador = new ContadorPalabras(n);
				contadorSig = new ContadorPalabrasSig(n, noSig);
			} catch (RuntimeException e) {
				System.out.println("Por defecto...");
				contador = new ContadorPalabras();
				contadorSig = new ContadorPalabrasSig(noSig);
			}
	
			contador.incluyeTodas(datos, delimitadores);
			contadorSig.incluyeTodas(datos, delimitadores);
			
			System.out.println(contador + "\n");
			
			System.out.println(contadorSig + "\n");
			
			try {
				System.out.println(contador.encuentra("parra"));
				System.out.println(contador.encuentra("Gorra"));
			} catch (NoSuchElementException e) {
				System.err.println(e.getMessage());
			}
		
			
			System.out.println("Repetimos la ejecución tomando la E/S desde/a fichero");
			
			ContadorPalabras contadorSigFich=null;
	
			try {
				int n = Integer.parseInt(args[0]);
				System.out.println("Con argumento " + n);
				contador = new ContadorPalabras(n);
				contadorSigFich= new ContadorPalabrasSig(n,"fichNoSig.txt",delimitadores);
			} catch (RuntimeException e) {
				System.out.println("Por defecto...");
				contador = new ContadorPalabras();
				
				try {
					contadorSigFich= new ContadorPalabrasSig("fichNoSig.txt",delimitadores);
				} catch (IOException e1) {
					// 
					System.out.println("ERROR:"+ e1.getMessage());
				}
			} catch (IOException e){
				System.out.println("ERROR:"+ e.getMessage());
			}
			
		    
			
			try{
				contador.incluyeTodasFichero("datos.txt",delimitadores);
				contadorSigFich.incluyeTodasFichero("datos.txt", delimitadores);
				System.out.println(contador + "\n");
				System.out.println(contadorSigFich + "\n");
				PrintWriter pw=new PrintWriter(System.out, true);
				contador.presentaPalabras(pw);
				contador.presentaPalabras("salida.txt");
				System.out.println();
				contadorSigFich.presentaPalabras(pw);
				contadorSigFich.presentaPalabras("salidaNoSig.txt");
			}catch (IOException e){
				System.out.println("ERROR:"+ e.getMessage());
			}

		}
	
	
	
	
	
}
