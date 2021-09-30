
package palabras;

public class PalabraEnTexto{
	/**
	 * Almacena una palabra en mayusculas junto con  el numero de apariciones
	 */
	private String palabra;
	private int veces;
	
	
	public PalabraEnTexto(String p) {
		palabra = p.toUpperCase();
		veces = 1;
	}
	
	public void incrementa() {
		veces++;
	}
	
	/**
	 * Solo tiene en cuenta la belabor sin importar mayusuculas ni minusculas
	 */
	public boolean equals(Object o) {
		return o instanceof PalabraEnTexto &&
			 ((PalabraEnTexto)o).palabra.equalsIgnoreCase(palabra);
	}
	
	
	public int compareTo(PalabraEnTexto pal) {
		
		return this.palabra.compareTo(pal.palabra);
	}
	
	
	public int hashCode() {
		return palabra.toUpperCase().hashCode();
	}
	
	public String toString() {
		return palabra + ": "+ veces;
	}

}
