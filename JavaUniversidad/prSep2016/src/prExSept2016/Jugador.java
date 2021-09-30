package prExSept2016;

public class Jugador {
	private String nombre;
	private int pJugados;
	private int pGanados;
	
	public Jugador(String nombre, int pJugados, int pGanados) {
		if (pJugados < 0 || pGanados < 0)
			throw new CompetitionException("no aceptamos negativos. Oscar vete de clase");
		if (pJugados < pGanados)
			throw new CompetitionException("no aceptamos tramposos. Oscar vete de clase");
			
		
		this.nombre = nombre;
		this.pJugados = pJugados;
		this.pGanados = pGanados;
	}
	
	public Jugador(String nombre) {
		this(nombre,0,0);
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getpJugados() {
		return pJugados;
	}
	
	public int getpGanados() {
		return pGanados;
	}
	
	
	public void increPartidos(int incpj,int incpg) {
		if (incpj < 0 || incpj < 0)
			throw new CompetitionException("no aceptamos negativos. Oscar vete de clase");
		if (incpj < incpj)
			throw new CompetitionException("no aceptamos tramposos. Oscar vete de clase");
			
		this.pJugados += incpj;
		this.pGanados += incpg;		
	}
	
	@Override
	public String toString() {
		return this.nombre+":"+this.pJugados+":"+this.pGanados;
	}	
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Jugador) {
			Jugador aux = (Jugador) obj;
			return this.nombre.equalsIgnoreCase(aux.nombre);
		}
		return false;
	}	
	
	@Override
	public int hashCode() {
		return this.nombre.toUpperCase().hashCode();
	}
	
}
