package primerapractica;

public class Jarra {

	private int contenido;
	private final int capacidad ;
	
	
	public Jarra(int capacidad) {
		
		this.capacidad = capacidad;
		this.contenido = 0;
	}
	public int capacidad() {
		return capacidad;
	}
	
	public int contenido() {
		return contenido;
	}
	public void llena() {
		this.contenido = capacidad;
	}
	
	public void vacia() {
		this.contenido = 0;
	}
	public void llenaDesde(Jarra j2) {
		
		int queda = this.capacidad - this.contenido;
		
		if(j2.contenido >= queda) {
			
		j2.contenido-=queda;
		this.contenido = this.capacidad;
		
		}else {
			
		this.contenido += j2.contenido;
		j2.contenido -= queda;
		
		if(this.contenido < 0 || j2.contenido < 0 ) {
			this.contenido = 0;
			j2.contenido = 0;
		}
	}
	}
	@Override
	public String toString() {
		return "J(" + capacidad +","+ contenido + ")";
	}
	
	
	
	
	
	
	
	
}
