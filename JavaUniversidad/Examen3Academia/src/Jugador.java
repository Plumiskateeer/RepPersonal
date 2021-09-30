
public class Jugador {

	private String nombre;
	private int pjugados,pganados;
	
	
	public Jugador(String nombre, int pjugados, int pganados) {
		if(pganados < 0 || pjugados <0) {
			
			throw new CompeticionException("Error al introducir datos");
			
		}else if(pganados > pjugados) {
			
			throw new CompeticionException("Error al introducir el numero de partidos ganados.");
			
		}else {
		
		this.nombre = nombre;
		this.pjugados = pjugados;
		this.pganados = pganados;
		
		}
	}
	
	public Jugador(String nombre) {
		
		this(nombre,0,0);
		
	}

	public String getNombre() {
		return nombre;
	}

	public int getPjugados() {
		return pjugados;
	}

	public int getPganados() {
		return pganados;
	}
	
	void increPartidos(int pjugados, int pganados) {
		
		if(pganados < 0 || pjugados <0) {
			
			throw new CompeticionException("Error al introducir datos");
			
		}else if(pganados > pjugados) {
			
			throw new CompeticionException("Error al introducir el numero de partidos ganados.");
			
		}else {
		
		
		this.pjugados = this.pjugados + pjugados;
		this.pganados = this.pganados + pganados;
		
		}
	}

	@Override
	public String toString() {
		return this.nombre + " : " + this.pjugados + " : " + this.pganados;
	}

	@Override
	public int hashCode() {
		return this.nombre.toLowerCase().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Jugador) {
			
			Jugador aux = (Jugador)obj; // aqui como sabes que obj es de tipo mensaje creas "otro" para manejar el emisor texto etc, porque no podrias hacer obj.emisor
			return this.nombre.equalsIgnoreCase(aux.nombre);
		}
		
		return false;
		
		
		
		}
	
	
	
	
	
	
	
	
	
}
