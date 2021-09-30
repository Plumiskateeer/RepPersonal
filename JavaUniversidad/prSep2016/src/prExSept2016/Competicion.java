ñpackage prExSept2016;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Competicion {

	private SortedMap<Equipo,List<Jugador>> competicion;
	
	
	public Competicion() {
		competicion = new TreeMap<>();
	}

	public Competicion(String fileName) {
		this();
		leerDatos(fileName);
		
	}
	
	public void leerDatos(String fileName) {
		
		competicion.clear();
		
		try(Scanner sc = new Scanner(new File(fileName))){
			String linea;
			
			while(sc.hasNextLine()) {
				linea = sc.nextLine();
				Scanner scLinea = new Scanner(linea);
				scLinea.useDelimiter(":");
				Equipo e = new Equipo(scLinea.next(),scLinea.nextInt(),scLinea.nextInt());
				
				List<Jugador> jugadores = new ArrayList<>();
				while(scLinea.hasNext()) {
					Jugador j = new Jugador(scLinea.next(),scLinea.nextInt(),scLinea.nextInt());
					jugadores.add(j);
				}
				
				insertaJugadoresEquipo(e,jugadores);
				
				scLinea.close();
			}
	} catch (Exception e) {
		throw new CompetitionException(e.getMessage());
	}
		
		
		
	}

	public void insertaJugadoresEquipo(Equipo e, List<Jugador> l) {
		
		
		List<Jugador> jug = competicion.getOrDefault(e, new ArrayList<Jugador>());
		
		for(Jugador j : l) {
			if(!jug.contains(j)) {
				jug.add(j);
			}
		}
		competicion.put(e, l);
		
	}

	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		
		// recorrer pares valor
		//asi se recorre un for each para el tipo de coleccion que es competicion asi chunga
		for(Map.Entry<Equipo, List<Jugador>> kv : competicion.entrySet()) {
			Equipo e =  kv.getKey();
			List<Jugador> jugadores = kv.getValue();
			sb.append(e+"\n");
			for(Jugador j : jugadores) {
				sb.append("\t"+j.toString()+"\n");
			}
		}
		
		return sb.toString();
	}
	
	public void escribirFichero(String file)  throws FileNotFoundException {
		
		try(PrintWriter pw = new PrintWriter(new File(file))){
			escribir(pw);
		}
		
	}
	
	public void escribir(PrintWriter pw) {
		for(Map.Entry<Equipo, List<Jugador>> kv : competicion.entrySet()) {
			Equipo e =  kv.getKey();
			List<Jugador> jugadores = kv.getValue();
			pw.print(e);
			for(Jugador j : jugadores) {
				pw.print(":"+j);
			}
			pw.println();
		}
	}
	
	public void increPartidos(String nombreJugador, int incPartJugados, int incPartGanados) {
		
		
		boolean encontrado = false;
		
		Iterator<List<Jugador>> it = competicion.values().iterator();
		
		while(it.hasNext() && !encontrado) {
			List<Jugador> jugadores = it.next();
			Iterator<Jugador> itJugadores = jugadores.iterator();
			while(itJugadores.hasNext() && !encontrado) {
				Jugador j = itJugadores.next();
				if(j.getNombre().equalsIgnoreCase(nombreJugador)) {
					encontrado = true;
					j.increPartidos(incPartJugados, incPartGanados);
				}
			}
		}
		
		
	}
	
	
}

