package prLibreria;

public class Libro {

	private static double porcIVA;
	private String autor,titulo;
	private int preciobase;
	
	
	public Libro(String autor, String titulo, int preciobase) {
		
		this.autor = autor;
		this.titulo = titulo;
		this.preciobase = preciobase;
	}


	public static double getIVA() {
		return porcIVA;
	}


	public static void setIVA(double IVA) {
		porcIVA = IVA;
	}


	public String getAutor() {
		return autor;
	}


	public String getTitulo() {
		return titulo;
	}


	public int getPreciobase() {
		return preciobase;
	}
	
	public double getPrecioFinal(){
		return preciobase+(preciobase*porcIVA/100);
	}
	
	
	@Override
	public String toString() {
		return "("+ autor + ";" + titulo + ";" + preciobase + ";"+porcIVA+"%;"+getPrecioFinal()+")";
	}

	
}
