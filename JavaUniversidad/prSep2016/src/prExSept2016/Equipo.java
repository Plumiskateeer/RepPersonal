package prExSept2016;

public class Equipo implements Comparable <Equipo>{
	private String nombre;
	private int categoria;
	private int puntos;
	
	
	public Equipo(String nombre, int categoria, int puntos) {
		
		if(categoria< 0 || categoria > 5) {
			throw new CompetitionException("Categoria no valida");
		}
		if(puntos < 0) {
			throw new CompetitionException("Puntos negativos");
		}
		this.nombre = nombre;
		this.categoria = categoria;
		this.puntos = puntos;
		
	}
	
	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		if(categoria< 0 || categoria > 5) {
			throw new CompetitionException("Categoria no valida");
		}
		this.categoria = categoria;
	}

	public String getNombre() {
		return nombre;
	}

	public int getPuntos() {
		return puntos;
	}

	@Override
	public String toString(){
		
		return this.nombre + ":" + this.categoria + ":" + this.puntos;
		}

	@Override
	public int hashCode() {
		return this.nombre.toLowerCase().hashCode() + this.categoria + this.puntos;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Equipo) {
			Equipo aux = (Equipo) obj;
			return this.nombre.equalsIgnoreCase(aux.nombre) &&
					this.categoria == aux.categoria &&
					this.puntos == aux.puntos;
		}
		return false;
	}

	public int compareTo(Equipo arg0) {
		
		int res = this.categoria - arg0.categoria;
		
		if(res==0) 
			res = arg0.puntos - this.puntos;
		if(res==0)
			res = this.nombre.compareToIgnoreCase(arg0.nombre);
		
		
		return res;
	}
	
	
	//PARA ORDEN NATURAL ---> COMPARABLE
	//PARA ORDEN ALTERNATIVO -----> COMPARATOR
	
	
	
	
}
