package prMaternidad;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;


public class Maternidad {

	private SortedMap<Persona, SortedSet <Persona>> pacientes;
	
	public Maternidad() {
		pacientes = new TreeMap<>();
	}
	
	
	
	public Maternidad(String fileName) throws FileNotFoundException {
		
		this();
		addPacientesFichero(fileName);
		
	}
	
	public void addPacientesFichero(String fileName)  {
		
		try(Scanner sc = new Scanner(new File(fileName))){
			addPacientes(sc);
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public void addPacientes(Scanner sc) {
		
		try{
		while(sc.hasNextLine()) {
			String linea = sc.nextLine();
			Scanner scLinea = new Scanner(linea);
			scLinea.useDelimiter("#");
			while(scLinea.hasNextLine()) {
				String scLinea2 = scLinea.nextLine();
				Scanner scAtributo = new Scanner(scLinea2);
				scAtributo.useDelimiter(":");
				Persona p = new Persona(scAtributo.nextLine(),scAtributo.nextInt(),scAtributo.nextInt());
				SortedSet<Persona> c = pacientes.getOrDefault(p, new TreeSet<Persona>());
				c.add(p);
				pacientes.put(p, c);			
				scAtributo.close();
			}
			scLinea.close();
			
		}
		}catch(Exception e) {
			throw new MaternidadException(e.getMessage());
		}
		
	}
	
	public void addMadreBebes(Persona madre,Collection<Persona>bebes) {
		
		if(bebes.isEmpty()) {
			SortedSet<Persona>c = pacientes.getOrDefault(madre, new TreeSet<Persona>());
			pacientes.put(madre, c);
		}else {
		
		SortedSet<Persona>c = pacientes.getOrDefault(madre, new TreeSet<Persona>());
		
		for(Persona b : bebes) {
			c.add(b);
		}
		
		pacientes.put(madre,c);
		}
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		for(Map.Entry<Persona,SortedSet<Persona>> kv : pacientes.entrySet()) {
			Persona madre = kv.getKey();
			SortedSet<Persona>bebes = kv.getValue();
			sb.append(madre);
			
			for(Persona p : bebes) {
				sb.append("#"+p.toString());
			}
			sb.append("\n");
			
		}
		return sb.toString();
		
		
	}
	
	public void escribirFichero(String fileName) throws FileNotFoundException {
		
		try(PrintWriter pw = new PrintWriter(new File(fileName))){
			escribir(pw);
		}
	}
	
	public void escribir(PrintWriter pw) {
		
		for(Map.Entry<Persona,SortedSet<Persona>> kv : pacientes.entrySet()) {
			Persona madre = kv.getKey();
			SortedSet<Persona>bebes = kv.getValue();
			pw.print(madre);
			
			for(Persona p : bebes) {
				pw.print("#" + p);
			}
			pw.println();
			
		}
	}
	
	public double mediaBebes() {
		
		int bebes = 0 , madres = 0;
		
		for(Map.Entry<Persona,SortedSet<Persona>> kv : pacientes.entrySet()) {
			Persona madre = kv.getKey();
			SortedSet<Persona>bebesmadre = kv.getValue();
			madres++;
			if(!bebesmadre.isEmpty()) {
			for(Persona p : bebesmadre) {
				bebes++;
			}
			}
			
		}
		return bebes/madres;
	}
	
	public int encontrarMadre(long codigobebe) {
			
		int numerohabitacionmadre = -1;
		boolean encontrado = false;
		Persona bebeElegido = new Persona("null",0,0);;
		
		Iterator<SortedSet<Persona>> it = pacientes.values().iterator();
		if(codigobebe > 0) 
		{
		while(it.hasNext() && !encontrado) {
			SortedSet<Persona> bebes = it.next();
			Iterator<Persona> itBebes = bebes.iterator();
			while(itBebes.hasNext() && !encontrado) {
				Persona bebe = itBebes.next();
				if(bebe.getCodigo()==codigobebe) {
					encontrado = true;
					bebeElegido = bebe;
				}
			}
		}
		
			if(encontrado) {
				Iterator<Persona> it2 = pacientes.keySet().iterator();
				boolean mamaEncontrada = false;
			
				while(it2.hasNext() && !mamaEncontrada) {
					Persona p = it2.next();
				
				if(pacientes.get(p).contains(bebeElegido)) {
					numerohabitacionmadre = p.getHabitacion();
				}else throw new MaternidadException("No se ha encontrado la mama del bebe con ese codigo");				
				
				}
			
			}else throw new MaternidadException("No se ha encontrado el bebe con ese codigo");
			
		
		}else throw new MaternidadException("El codigo del bebe a buscar no es correcto");
			
		
		return numerohabitacionmadre;	
		
	}
		
}
