package prBuses;

public class EnMatricula implements  Criterio {

	@Override
	public boolean esSeleccionable(Bus b) {
		
		return b.getMatricula().contains(dato);// contais retorna true o false
		
	}

	private String dato;
	
	public EnMatricula (String dato) {
		this.dato = dato;
		
	}

	@Override
	public String toString() {
		return "EnMatricula [dato=" + dato + "]";
	}
	
	
}
