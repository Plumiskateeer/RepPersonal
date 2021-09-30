package prBuses;

public class PorLinea implements Criterio{

	@Override
	public boolean esSeleccionable(Bus b) {
		// TODO Auto-generated method stub
		return b.getCodLinea() == codLinea;
		
	}

	private int codLinea;
	public PorLinea(int codLinea) {
		this.codLinea = codLinea;
		
		
	}
	@Override
	public String toString() {
		return "PorLinea [codLinea=" + codLinea + "]";
	}
	
	
	
	
}
