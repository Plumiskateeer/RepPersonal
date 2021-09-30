package prLaboratorios;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class Asignaciones {

	private SortedMap<Integer, SortedSet<PeticionAsignacion>> asignacion;
	protected List<PeticionAsignacion> conflictos;
	private int NUM_LAB = 10;
	
	
	public Asignaciones(int n) {
		
		this.NUM_LAB = n;
		this.conflictos = new ArrayList<>();
		this.asignacion = new TreeMap<>();
		
		for(int i = 0; i < NUM_LAB ; i++) {
			Random rnd = new Random();
			int key = rnd.nextInt(NUM_LAB)+1;
			SortedSet<PeticionAsignacion> c = asignacion.getOrDefault(key, new TreeSet<>());
			asignacion.put(key, c);
			
		}
	}
	
	public Asignaciones(int n, String s) {
		this(n);
		
		
	}
	
	
	
	
	
	
	
	
	
}
