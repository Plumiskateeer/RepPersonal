package prPractica21;

public class Jarra {

	private int contenido;
	private final int capacidad = 7;
	
	
	public Jarra(int c) {
		
		contenido = c;
	}
	
	public int capacidad ( ) {
		return capacidad;
	}
	
	public int contenido(){
		return contenido;
	}
	
	public void llena() {
		contenido = capacidad;
	}
	
	public void vacia() {
		contenido = 0;
	}
	
	public void llenaDesde(Jarra j) {
		
		this.contenido+=j.contenido;
		
	}

	@Override
	public String toString() {
		return "Jarra [contenido=" + contenido + ", capacidad=" + capacidad + "]";
	}
	
	
}
