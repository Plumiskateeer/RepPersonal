package prLibreria;

public class Libro {
	private static double porcIVA = 10;
	private String autor;
	private String titulo;
	private double precioBase;
	
	public Libro(String autor, String titulo, double precioBase) {
		this.autor = autor;
		this.titulo = titulo;
		this.precioBase = precioBase;
	}
	
	public Libro(String autor, String titulo){
		this(autor,titulo,0);
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public double getPrecioBase() {
		return precioBase;
	}
	
	
	public double getPrecioFinal() {
		return precioBase + (precioBase * porcIVA / 100);
	}
	
	public static double getIVA() {
		return porcIVA;
	} 
	
	public static void setIVA(double porcIVA) {
		Libro.porcIVA = porcIVA;
	}
	
	@Override
	public String toString() {
		return "(" + this.autor + "; "+ this.titulo + "; " + 
					+ this.precioBase + "; "+ Libro.porcIVA +
					"%; " + this.getPrecioFinal() + ")";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Libro){
			Libro aux = (Libro)obj;
			return (this.autor.equalsIgnoreCase(aux.autor) 
					&& this.titulo.equalsIgnoreCase(aux.titulo));
		}
		return false;
	}
	
	
	
	
	
}
