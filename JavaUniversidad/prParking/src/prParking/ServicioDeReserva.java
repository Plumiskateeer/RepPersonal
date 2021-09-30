package prParking;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class ServicioDeReserva {

	ArrayList<Parking> parkings;
	
	public ServicioDeReserva() {
	
		parkings = new ArrayList<>();
	}
	
	public ServicioDeReserva(String fileName) throws FileNotFoundException {
		
		super();
		
		try(Scanner sc = new Scanner(new File(fileName))){
		while(sc.hasNext()) {	
			Scanner scLinea = new Scanner(sc.nextLine());
			String identificador = sc.nextLine();
			Posicion pos = new Posicion(scLinea.nextDouble(),scLinea.nextDouble());
			scLinea.close();
			int numplazas = sc.nextInt();
			Parking p = new Parking(identificador,pos,numplazas);
			
			parkings.add(p);
		}
		sc.close();
		}
	
	}
	
	public boolean addParking(Parking p) {
		
		boolean contiene = false;
		
		if(!parkings.contains(p)) {
			parkings.add(p);
			contiene = true;
		}
		
		return contiene;
	}
	
	public boolean reservarPlaza(Vehiculo v, Parking pk) {
		
		boolean reservado = false;
		
		if(pk.reservarPlaza(v, pk.buscarPlaza(v))) {
			pk.reservarPlaza(v, pk.buscarPlaza(v));
			reservado = true;
		}
		
		return reservado;
		
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < parkings.size(); i++) {
			
			sb.append(parkings.get(i).toString());
			sb.append("\n");	
			
		}
		
		return sb.toString();
	}
	
	public Parking parkingLibreMasProximo(Vehiculo v) {
		
		Posicion p = new Posicion(0,0);
		Parking LibreMasProximo = new Parking(null,p,1);
		ComparadorParking comparador = new ComparadorParking(v);
		ArrayList<Parking>libres = new ArrayList<>();
		
		for(int i = 0; i < parkings.size(); i++) {
			
			if(parkings.get(i).reservarPlaza(v, parkings.get(i).buscarPlaza(v)))
				libres.add(parkings.get(i));
			
		}
		
		for(int i = 0; i < libres.size(); i++) {
			
			
			if(comparador.compare(LibreMasProximo, libres.get(i)) == 1) 
				LibreMasProximo = libres.get(i);
			
		}
		
		return LibreMasProximo;
		
	}
	
	public Map<String,String> reservaDePlazas(List<Vehiculo> lv){
		
		Iterator<Vehiculo> it = lv.iterator();
		
		Map<String,String> mapa = new TreeMap<>();
		
		while(it.hasNext()) {
			
			Vehiculo v = it.next();
			Parking p = parkingLibreMasProximo(v);
			mapa.put(v.getMatricula(), p.getId());
		}
		
		return mapa;
	}
}
