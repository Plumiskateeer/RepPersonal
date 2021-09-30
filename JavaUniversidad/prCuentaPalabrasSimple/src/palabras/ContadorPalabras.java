package palabras;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class ContadorPalabras {

	 private PalabraEnTexto [] palabras;
	 private int numPalabras;
	 private static final int TAM_INICIAL = 10;
	 
	 
	public ContadorPalabras(int n) {
		palabras  = new PalabraEnTexto[n];
		numPalabras = 0;
	}
	
	public ContadorPalabras() {
		this(TAM_INICIAL);
	}
	

	private int esta(String pal) {
		int pos =0;
		PalabraEnTexto pa = new PalabraEnTexto(pal);
		while(pos < numPalabras && !palabras[pos].equals(pa)) {
			pos++;
		}
	
		return pos < numPalabras ? pos : -1; // esto es un if que devuelve pos o -1
	}
	
	
	protected void incluye(String pal) {
		int i = esta(pal);
		
		if(i == -1) {
			//ahora comprobamos si esta lleno antes de añadir la palabra
			if( numPalabras == palabras.length) {
				
				palabras = Arrays.copyOf(palabras,palabras.length*2);
				
			}
			palabras [numPalabras] = new PalabraEnTexto(pal);
			numPalabras++;
			
		}else {
			// si i >= 0, el array ya contiene la palabra y basta con incrementar
			palabras[i].incrementa();
		}	
	}
	
	private void incluyeTodas(String texto, String del) {
		try(Scanner sc =  new Scanner (texto)){
			sc.useDelimiter(del);
			while(sc.hasNext()) {
				String pal = sc.next();
				incluye(pal);
			}
		}	
	}
	
	public void incluyeTodas(String [] texto, String del) {
		
		for(String linea : texto) {
			incluyeTodas(linea,del);
		}	
	}
	

	private void leerFichero(Scanner sc, String del) throws FileNotFoundException {
		
		while(sc.hasNextLine()) {
			String linea = sc.nextLine();
			incluyeTodas(linea,del);
		}
		
	}
	
	public void incluyeTodasFichero(String nomFil, String del)throws FileNotFoundException {
		
		try(Scanner sc = new Scanner (new File(nomFil))){
			leerFichero(sc,del);
		}
		
	}
	
	public PalabraEnTexto encuentra(String pal) {
		int i = esta(pal);
		if(i == -1) {
			throw new NoSuchElementException("No existe la palabra " + pal);
			
		}
		return palabras[i];
		
	}
		
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		int i = 0;
		while( i < numPalabras) {
			sb.append(palabras[i]);
			if(i != numPalabras -1 ) {
				sb.append(", ");
			}
			i++;
		}
		
		sb.append("]");
		return sb.toString();
	}
	
	
	public void presentaPalabras(String filSal) throws FileNotFoundException { 
		try(PrintWriter pw = new PrintWriter(filSal)){
			presentaPalabras(pw);
		}
	}
	
	public void presentaPalabras(PrintWriter pw) {
		for(int i = 0; i < numPalabras; i++) {
			pw.println(palabras[i]);
		}
	}
}
