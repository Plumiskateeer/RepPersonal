package cuartapractica;
public class Alumno {

	private String nombre;
	private String dni;
	private double nota;
	
	public Alumno(String nombre, String dni,double nota) throws AlumnoException  {
		
		if(nota < 0) {
			throw new AlumnoException("Calificacion negativa");
		}
		this.nombre = nombre;
		this.dni = dni;
		this.nota = nota;	
		
	}
	public Alumno(String nombre,String dni) {
		
		this.nombre = nombre;
		this.dni = dni;
		nota = 0;
		
		
	}
	public String getNombre() {
		return nombre;
	}
	public String getDni() {
		return dni;
	}
	public double getNota() {
		return nota;
	}
	@Override
	public String toString() {
		return  dni + ";" + nombre + ";" + nota;
	}
	@Override
	public int hashCode() {
		return nombre.hashCode() + dni.toLowerCase().hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		
		boolean res = obj instanceof Alumno;
		Alumno al = res ? (Alumno) obj : null;
		return res && nombre.equals(al.nombre) && dni.equalsIgnoreCase(al.dni);
		
		
	}
	
	
	
}
