package prNotas;

public class Alumno {
	private String nombre;
	private String dni;
	private double nota;
	
	public Alumno(String d, String n, double c) throws AlumnoException {
		if (c < 0) {
			throw new AlumnoException("Calificacion negativa");
		}
		nombre = n;
		dni = d;
		nota = c;
	}
	
	public Alumno(String d, String n) throws AlumnoException {
		this(d, n, 0);
	}
	
	public boolean equals(Object obj) {
		boolean res = obj instanceof Alumno;
		Alumno al = res ? (Alumno) obj : null;
		return res && nombre.equals(al.nombre) && dni.equalsIgnoreCase(al.dni);
	}
	
	public int hashCode() {
		return nombre.hashCode() + dni.toLowerCase().hashCode();
	}
	
	public String getNombre() {
		return nombre;
	}

	public String getDni() {
		return dni;
	}

	public double getCalificacion() {
		return nota;
	}
	
	public String toString() {
		return nombre + " " + dni;
	}
}
