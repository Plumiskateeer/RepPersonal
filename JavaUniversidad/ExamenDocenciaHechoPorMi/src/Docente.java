
public class Docente implements Comparable<Docente>{
	private String nombre;
	private int carga;
	private int capacidad;
	private int horquilla;
	/// horquilla es 0 cuando imparte las horas correspondientes, si imparte menos o mas es erronea
	/// no deberia
	
	public Docente(String nombre, int capacidad) throws DocenciaException {
		
		this.nombre = nombre;
		this.carga  = 0;
		
		if(capacidad<0) throw new DocenciaException("La capacidad es incorrecta");
		else {
		this.capacidad = capacidad;
		}
		
		this.horquilla = carga - capacidad;
	}

	public int getCarga() {
		return carga;
	}

	public void setCarga(int carga) {
		this.carga = carga;
		this.horquilla = carga - capacidad;
	}

	public String getNombre() {
		return nombre;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public int getHorquilla() {
		return horquilla;
	}

	@Override
	public String toString() {
		return this.nombre + ":" + this.capacidad + ":" + carga + ":" + horquilla;
	}

	
	
	@Override
	public int hashCode() {
		return this.nombre.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Docente) {
			Docente aux = (Docente) obj;
			if(this.nombre.compareTo(aux.nombre)==0)return true;
		}
		return false;
		
	}

	@Override
	public int compareTo(Docente arg0) {
			return arg0.nombre.toUpperCase().hashCode() 
					- this.nombre.toUpperCase().hashCode(); 
	}
	
	
	
	
}
