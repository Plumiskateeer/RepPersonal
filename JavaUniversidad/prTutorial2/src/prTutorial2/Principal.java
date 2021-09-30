package prTutorial2;

import java.util.Arrays;

public class Principal implements Comparable<Punto>{

	public static void main(String[] args) {
		Punto [] puntos = new Punto[3];
		puntos[0] = new Punto(1,2);
		puntos[1] = new Punto(8,27);
		puntos[2] = new Punto(1,7);
		
		for(Punto p : puntos) {
			System.out.println(p);
		}
		
		Arrays.sort(puntos);
		System.out.println("Ordenados");
		
		for(Punto p : puntos) {
			System.out.println(p);
		}
		
		System.out.println("Ordenados por X");
		//esto da error pq se llama comparator igual que la clase de q he creadoq tb se llama comparator
		Arrays.sort(puntos, new Comparator<Punto>(){
			//ESTO ES UNA CLASE ANONIMA
			
			@Override
			public int compare(Punto arg0, Punto arg1) {
				if(arg0.getX() < arg1.getX()) return -1;
				else if(arg0.getX() > arg1.getX()) return 1;
				else return 0;
			}
			
			
		
		}
		
		
		);

		}

	@Override
	public int compareTo(Punto o) {
		// TODO Auto-generated method stub
		return 0;
	}}
