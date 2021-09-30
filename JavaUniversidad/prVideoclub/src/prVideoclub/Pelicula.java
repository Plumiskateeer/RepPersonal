package prVideoclub;

import java.util.Iterator;
import java.util.Set;



public class Pelicula implements Comparable<Pelicula>{

	private String titulo;
	private Set<String> actores;
	private String codigo;
	private int estreno;
	
	public Pelicula(String titulo, Set<String> actores, String codigo, int estreno) {
	
		this.actores.clear();
		this.titulo = titulo;
		this.actores.addAll(actores);
		this.codigo = codigo;
		this.estreno = estreno;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public Set<String> getActores() {
		return actores;
	}
	public String getCodigo() {
		return codigo;
	}
	public int getEstreno() {
		return estreno;
	}
	
	
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("[" + this.titulo + ", ");
		
		Iterator<String> it = actores.iterator();
		
		sb.append("actores : ");
		while(it.hasNext()) {
			
			sb.append(it.next().toString() + ",");
			
		}
	
		return sb.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		
		boolean res = false;
		if(obj instanceof Pelicula) {
			Pelicula aux = (Pelicula) obj;
			res = aux.titulo == this.titulo &&
					aux.estreno == this.estreno;
		}
		return res;
	}

	@Override
	public int compareTo(Pelicula arg0) {
		
		int res = 0;
		
		int numStringpropio = Integer.parseInt(this.titulo);
		int numStringcomparar = Integer.parseInt(arg0.titulo);
		
		
		if(numStringpropio < numStringcomparar) res = -1;
		else if(numStringpropio > numStringcomparar) res = 1;
		else {
			if(this.estreno < arg0.estreno) res = -1;
			else if(this.estreno > arg0.estreno) res = 1;
		}
		
		return res;
	}
	
	
	
	
}
