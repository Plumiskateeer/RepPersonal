package claseTeoriaColecciones;

import java.util.*;

public class PruebaList {

	public static void main (String[] args)
	{
		//OPERACIONES BÁSICAS
		//1. Declaramos una collección de números enteros
		Collection<Integer> lista1;
	
		//2. Creamos una lista de enteros usando la implementación disponible: ArrayList<T>, invocando el constructor sin parámetros
		lista1 = new ArrayList<>();
		
		//3. Comprobamos si la lista está o no vacía
		if (lista1.isEmpty())
		{
			System.out.println("Lista vacia...");
		}
		
		//4. Añadimos varios elementos a la lista usando el método add. Los añade duplicados porque es una lista
		lista1.add(1);
		lista1.add(2);
		if (lista1.add(2))
		{ 
			System.out.println("Añadido");
		}else{
			System.out.println("El elemento ya estaba. No se ha añadido");
		}
		lista1.add(3);
		
		//5. Eliminamos un elemento de la lista
		if (lista1.remove(2))
		{
			System.out.println("Elemento eliminado");
		}
		lista1.remove(1);
		
		//6. Consultamos el número de elementos en la colección
		System.out.println("El número de elementos es: " + lista1.size());
		
		//7. Añadimos nuevos elementos
		lista1.add(10);
		lista1.add(2);
		lista1.add(7);
		lista1.add(1);
		
		//OPERACIONES CON GRUPOS DE ELEMENTOS
		//8. Creamos una nueva lista
		Set<Integer> lista2 = new HashSet<>();
		
		//9. Añadimos todos los elementos de la otra lista en esta, con una sola operación
		lista2.addAll(lista1);
		
		//10. Eliminamos algún elemento de lista2
		lista2.remove(1);
		
		//11. Creamos una tercera lista a la que le añadimos todos los elementos de la primero y luego le eliminamos todos los de la segunda
		Set<Integer> lista3 = new HashSet<>();
		lista3.addAll(lista1);
		lista3.removeAll(lista2);
		
		//12. Recorremos las tres listas, iterando sobre ellas
		System.out.println("Conjunto 1 ...");
		recorrerColecciónIterador(lista1);
		
		System.out.println("Conjunto 2 ...");
		recorrerColecciónIterador(lista2);

		System.out.println("Conjunto 3 ...");
		recorrerColecciónIterador(lista3);
		
		//13. Recorremos la lista 1 con for-each
		System.out.println("Conjunto 1 con for-each ...");
		for (Integer v: lista1)
		{
			System.out.print(v + " ");
		}
		System.out.println();
	}
	
	public static void recorrerColecciónIterador(Collection<Integer> c){
		Iterator<Integer> it = c.iterator();
		while (it.hasNext())
		{
			System.out.print(it.next() + " ");
		}
		System.out.println();
	}
	
	
}
