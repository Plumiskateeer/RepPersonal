package prTutorialMapa;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Principal {

	public static void main(String[] args)  {
		
		   
		Map<Integer,Set<Punto>> hola = new TreeMap<>();
		
		/// meter puntos
		
		Random rnd = new Random();
		
		for(int i = 0 ; i < 100 ; i++) {
			Punto p = new Punto(rnd.nextInt(20)-10,rnd.nextInt(20)-10);
			
			Set<Punto> c = hola.getOrDefault(p.getX()+p.getY(), new HashSet<>());
			
			c.add(p);
			hola.put(p.getX()+p.getY(), c);
		}
		
		System.out.println(hola.size());
		
		
		int numpuntos = 0;
		
		for(Set<Punto> c  : hola.values()) {
			numpuntos += c.size();
			for(Punto p : c) {
				System.out.println(p);
			}
		}
		System.out.println(numpuntos);
		System.out.println(hola.size());
		
		
		for(Integer i : hola.keySet()) { //////////////////esto 
			System.out.println(i);
			Set<Punto> c = hola.get(i);
			for(Punto p : c) {
				System.out.println("\t"+p);
			}
		}
		
		for(Map.Entry<Integer, Set<Punto>> kv : hola.entrySet()) { ////////////// y esto hacen lo mismo, pero esto va de key value en key value, y el otro recorre todo
			System.out.println(kv.getKey());
			for(Punto p : kv.getValue()) {
				System.out.println("\t"+p);
			}
		}
		
		hola.clear();
		
		try (Scanner sc = new Scanner(new File("fichero.txt"))){
			
			while(sc.hasNextLine()) {
				String linea = sc.nextLine();
				Scanner scLinea = new Scanner(linea);
				scLinea.useDelimiter(" ");
				while(scLinea.hasNext()) {
					Punto p = new Punto(scLinea.nextInt(),sc.nextInt());
					
					int key = p.getX()+p.getY();
					Set<Punto> c = hola.getOrDefault(key, new HashSet<>());
					c.add(p);
					hola.put(key, c);				}
				scLinea.close();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		for(Map.Entry<Integer, Set<Punto>> kv : hola.entrySet()) {
			System.out.println(kv.getKey());
			for(Punto p : kv.getValue()){
				System.out.println("\t" + p);
			}
		}
	}

}
