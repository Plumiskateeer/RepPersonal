package prExSept2016;

import java.util.SortedSet;
import java.util.TreeSet;

public class PruebaEquipo {

	public static void main(String[] args) {

		SortedSet<Equipo> C = new TreeSet<>();
		C.add(new Equipo("Parque Litoral",3,10));
		C.add(new Equipo("Centro Padel",2,6));
		C.add(new Equipo("Padel Palo",3,8));
		
		System.out.println("Orden natural: ");
		for(Equipo e : C) {
			System.out.println(e);
		}
		
		SortedSet<Equipo> Calt = new TreeSet<>(new OrdenAltEquipo());
		Calt.add(new Equipo("Parque Litoral",3,10));
		Calt.add(new Equipo("Centro Padel",2,6));
		Calt.add(new Equipo("Padel Palo",3,8));
		
		System.out.println("Orden alternativo: ");
		for(Equipo e : Calt) {
			System.out.println(e);
		}
	}

}
