package prMaternidad;

public class Persona implements Comparable<Persona>{
	private String nombre;
	private int codigo;
	private int habitacion;
	
	
	public Persona(String nombre, int codigo, int habitacion) {

		if(codigo <= 0 || habitacion < 0) throw new MaternidadException("Datos introducidos incorrectos");
		else {
			this.codigo = codigo;
			this.habitacion = habitacion;
			this.nombre = nombre;		
			}
		
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public int getHabitacion() {
		return habitacion;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	
	@Override
	public String toString() {
		
		return this.nombre + ";" + this.codigo + ":" + this.habitacion;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(obj instanceof Persona) {
			Persona aux = (Persona)obj;
			return this.codigo == aux.codigo;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		
		return this.codigo;
	}

	@Override
	public int compareTo(Persona o) {
		int res =  this.getNombre().compareToIgnoreCase(o.getNombre());
		
		if(res == 0) res = this.getCodigo() - o.getCodigo();
		if(res < 0) res = -1;
		if(res > 0) res = 1;
		else res = 0;
		
		return res;
	}

	
	
}
