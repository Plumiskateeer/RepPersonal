package palabras;

public class PalabraEnTexto {

	private String palabra;
	private int veces;
	
	public PalabraEnTexto(String palabra) {
		palabra = palabra.toUpperCase();
		veces = 1 ;
	}


	public void incrementa() {
		veces++;
	}
	
	@Override
	public String toString() {
		return palabra + ": " + veces;
	}


	@Override
	public boolean equals(Object obj) {
		return obj instanceof PalabraEnTexto && 
		  ((PalabraEnTexto)obj).palabra.equalsIgnoreCase(this.palabra);
	}
	

	@Override
	public int hashCode() {
		return palabra.toUpperCase().hashCode();
	}

	
	
	
}
