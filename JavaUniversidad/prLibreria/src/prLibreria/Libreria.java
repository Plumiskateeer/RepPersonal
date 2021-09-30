package prLibreria;

import java.util.Arrays;

public class Libreria {
	protected static final int CAP_INICIAL = 16;
	private Libro[] libs;
	private int numLibs;
	
	public Libreria(int num){
		numLibs = 0;
		libs = new Libro[num];
	}
	
	public Libreria(){		
		this(CAP_INICIAL);
	}
	
	public void addLibro(String autor, String titulo, double precioBase){
		Libro l = new Libro(autor, titulo,precioBase);
		anyadirLibro(l);
	}
	
	public void remLibro(String autor,String titulo){
		int indice = buscarLibro(autor, titulo);
		if (indice != -1) eliminarLibro(indice); 
	}
	
	public double getPrecioBase(String autor,String titulo){
		return buscar(autor,titulo).getPrecioBase();
	}
	
	public double getPrecioFinal(String autor,String titulo){
		return buscar(autor,titulo).getPrecioFinal();
	}
	
	@Override
	public String toString() {
		String s = "[";
	
		for (int i = 0; i < numLibs; i++){
			if (i==0) s += libs[i].toString() + "\n";
			else s += ", " +libs[i].toString() + "\n";			
		}
		
		s += "]";
		
		return s;
	}
	
	/*
	 [(George Orwell; 1984; 6.20; 10.0%; 6.82), 
	 (Philip K. Dick; ¿Sueñan los androides con ovejas eléctricas?; 3.50; 10.0%; 3.85),
	  (Isaac Asimov; Fundación e Imperio; 9.40; 10.0%; 10.34), 
	  (Ray Bradbury; Fahrenheit 451; 7.40; 10.0%; 8.14), 
	  (Aldous Huxley; Un Mundo Feliz; 6.50; 10.0%; 7.15), 
	  (Isaac Asimov; La Fundación; 7.30; 10.0%; 8.03), 
	  (William Gibson; Neuromante; 8.30; 10.0%; 9.13), 
	  (Isaac Asimov; Segunda Fundación; 8.10; 10.0%; 8.91), 
	  (Isaac Newton; Arithmetica Universalis; 10.50; 10.0%; 11.55)] 
	 */
	
	protected void anyadirLibro(Libro l){
		int i = buscarLibro(l.getAutor(),l.getTitulo());
		if (i >= 0 ) libs[i] = l;
		else{		
			if (numLibs >= libs.length){			
				libs = Arrays.copyOf(libs,libs.length*2);
			}
			
			libs[numLibs] = l;
			numLibs++;
		}
	}
	
	private Libro buscar(String autor,String titulo){
		int i = buscarLibro(autor, titulo);
		if (i != -1) return libs[i];
		else throw new RuntimeException("El libro no existe, xenxo");
	}
	
	private void eliminarLibro(int i){
		libs[i]=libs[numLibs-1];
		libs[numLibs-1] = null;
		numLibs--;
	}
	
	private int buscarLibro(String autor, String titulo){
		int i = numLibs-1;
		Libro k = new Libro(autor, titulo);
		while (i >= 0 && ! libs[i].equals(k)) { 
			i--;
		}
		return i;	
	}
}
