package prVideoclub;


import java.io.File;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeSet;



public class Videoclub {

	// cada pelicula tiene el numero de copias de la misma, que nunca sera 0, unicamente si todas las copias estan prestadas
	private SortedMap<Pelicula,Integer> copiasdecadapelicula;
	// aqui solo hay peliculas q tengan copias prestadas, si no tiene prestadas no aparece, el numero de copias no puede ser negativo
	private SortedMap<Pelicula,Integer> peliculasprestadas;
	
	
	
	public Videoclub(String fileName) throws VideoclubException {
		
		Pelicula p;
		int copias;
		try(Scanner sc = new Scanner(new File(fileName))){
			
			sc.useDelimiter("%");
			String titulo = sc.nextLine();
			Set<String> actores = new TreeSet<>();
			
			Scanner scLinea = new Scanner(sc.nextLine());
			
			while(scLinea.hasNext()) {
				sc.useDelimiter(",");
				actores.add(scLinea.nextLine());
			}
			scLinea.close();
			
			String codigo = sc.nextLine();
			int estreno = sc.nextInt();
				copias = sc.nextInt();
			sc.close();
			
			 p = new Pelicula(titulo,actores,codigo,estreno);
			 
			 
		}catch(Exception e) {
			throw new VideoclubException(e.getMessage());
		}
		
		int c = copiasdecadapelicula.get(p);
		int copiaspelicula = copias + c;
		
		if(copiasdecadapelicula.containsKey(p)) {
			copiaspelicula = copiasdecadapelicula.get(p) + 1;
		}
		
		copiasdecadapelicula.put(p, copiaspelicula);
		
	
	}
	
	public void añadir(Pelicula p, int copias) throws VideoclubException {
		if(copiasdecadapelicula.containsKey(p)) 
			copiasdecadapelicula.put(p, copiasdecadapelicula.get(p) + copias);
		else throw new VideoclubException("Esa pelicula no esta en el videoclub");
	}
	
	public int disponibles(Pelicula p) throws VideoclubException {
		
		int cantidad;
		
		if(copiasdecadapelicula.containsKey(p)) {
			cantidad = copiasdecadapelicula.get(p) - peliculasprestadas.get(p);
		}else throw new VideoclubException("Esa pelicula no esta en el videoclub"); 
		
		return cantidad;
		
	}
	
	public Pelicula pelicula(String titulo) {
		
		Iterator<Pelicula> it = copiasdecadapelicula.keySet().iterator();
		
		boolean encontrado = false;
		Pelicula pelibuscada = null;
		
		
		while(it.hasNext() && !encontrado) {
			
			Pelicula p  = it.next();
			
			if(p.getTitulo() == titulo) {
				pelibuscada = p;
				encontrado = true;
			}
				
		}
		return pelibuscada;
		
	}
	
	public Set<Pelicula> peliculasDeActor(String actor){
		
		Set<Pelicula> pelisdelactor = new TreeSet<>();
		
		Iterator<Pelicula> it = copiasdecadapelicula.keySet().iterator();
		
		while(it.hasNext()) {
		
		Pelicula pelicula = it.next();
			
		for(String s : pelicula.getActores()) {
			if(s == actor) pelisdelactor.add(pelicula);
		}
		
		}
		return pelisdelactor;
	}
	 public void prestar(Pelicula p) throws VideoclubException {
		 
		 if(copiasdecadapelicula.containsKey(p)) {
		 int c = copiasdecadapelicula.get(p) - 1;
		 
		 if(c < 0) throw new VideoclubException("No hay copias de esa pelicula");
		 else {
			 copiasdecadapelicula.put(p, c);
			 int d = peliculasprestadas.get(p) + 1;
			 peliculasprestadas.put(p, d);
		 }
		 }else throw new VideoclubException("Esa pelicula no esta en el videoclub");
		  
	 }
	 
	 public void devolver(Pelicula p) throws VideoclubException {
		 
		 
		 int c;
		 
		 if(peliculasprestadas.containsKey(p) && copiasdecadapelicula.containsKey(p)) {
		 int d = peliculasprestadas.get(p) - 1;
		 if(d < 0) throw new VideoclubException("Se esta devolviendo una pelicula que no estaba prestada");
		 else if (d == 0){
			 peliculasprestadas.remove(p);
			 c = copiasdecadapelicula.get(p) + 1;
			 copiasdecadapelicula.put(p, c);
		 }
		 else {
			 peliculasprestadas.put(p, d);
			 c = copiasdecadapelicula.get(p) + 1;
			 copiasdecadapelicula.put(p, c);
		 }
		 }throw new VideoclubException("Esa pelicula no esta en el videoclub");
		 
	 }
	
	
	
}
 
