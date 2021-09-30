
public class Equipo implements Comparable<Equipo>{
	
	private String nombre;
	private int categoria;
	private int puntos;
	
	public Equipo(String nombre, int categoria, int puntos) {
		super();
		this.nombre = nombre;
		
		if(categoria <1 || categoria >5)throw new CompeticionException("Categoria caca");
		else this.categoria = categoria;
		
		if(puntos < 0)throw new CompeticionException("Puntos mal");
		else this.puntos = puntos;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		if(categoria <1 || categoria >5)throw new CompeticionException("Categoria caca");
		else this.categoria = categoria;
		
	}

	public String getNombre() {
		return nombre;
	}

	public int getPuntos() {
		return puntos;
	}
	
	
	void increPuntos(int puntos) {
		
		if(puntos < 0)throw new CompeticionException("Puntos mal");
		else this.puntos+=puntos;
		
	}

	@Override
	public String toString() {
		return this.nombre + " : " + this.categoria + " : " + this.puntos;
	}
	
	
	@Override
	public int hashCode() {
		
		return this.nombre.toLowerCase().hashCode() +
				this.categoria + this.puntos;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Equipo) {
			
			Equipo aux = (Equipo)obj; // aqui como sabes que obj es de tipo mensaje creas "otro" para manejar el emisor texto etc, porque no podrias hacer obj.emisor
			return this.nombre.equalsIgnoreCase(aux.nombre)
					&& this.puntos == aux.puntos &&
					this.categoria == aux.categoria;
		}
		
		return false;

		}
	

	@Override
	public int compareTo(Equipo o) {
		
		int res = this.categoria - o.categoria;
		if(res == 0) res = this.puntos - o.puntos;
		if(res == 0) 
		return res;
	}
	
	
	
}
