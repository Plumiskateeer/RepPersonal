package prBuses;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Servicio {
	
	private Bus[] buses;
	private static final int TAM= 10;
	private String ciudad;
	
	public Servicio (String nombreCiudad) {
		
		this.ciudad = nombreCiudad;
	    buses = new Bus[0];
		
		
	}
	public String getCiudad() {
		return ciudad;
	}
	
	public void agregaBuses (String file) 
			throws FileNotFoundException {
		try (Scanner sc = new Scanner(new File(file))){
          
			agregaBuses(sc);
			
		}
		
	}
public void agregaBuses (Scanner sc) {
	
	buses = new Bus[TAM];
	int numbuses = 0;
	
	while (sc.hasNextLine()) {
		
		String linea =  sc.nextLine();
		
		try (Scanner scLinea = new Scanner(linea)){
	
		scLinea.useDelimiter(",");
		Bus b = new Bus(scLinea.nextInt(), scLinea.next());
		b.setCodLinea(scLinea.nextInt());
		if (numbuses == buses.length) {
			buses = Arrays.copyOf(buses, buses.length*2);
		}
		buses[numbuses] = b;
		numbuses ++;
		
		}catch (Exception exc) {
			System.out.println(linea + ":\n\t" + exc.getMessage() + "\n");
		}
		
		}// termina while
		buses = Arrays.copyOf(buses, numbuses);
	}// termina agregaBuses

public Bus[] filtra (Criterio c) {
	Bus [] res  = new Bus[buses.length];
	int numbuses=0;
	for (int i = 0; i < buses.length; i++) {
		if ( c.esSeleccionable(buses[i]) ) {
			
			res[numbuses]= buses[i];
			numbuses ++;
			
		}// termina if
		
	}
	
	 return res= Arrays.copyOf(res, numbuses);
}

public void guarda (String file,Criterio  c)
		throws FileNotFoundException {
	try ( PrintWriter pw = new PrintWriter(new File(file))){
		guarda (pw,c);
	}
}

public  void guarda ( PrintWriter pw, Criterio c) {
	pw.println(c.toString());
	Bus[] res = filtra (c);
	for ( Bus b : res) {
		pw.println(b.toString());
		
	}
	
	
}


}
