package claseTeoriaColecciones;

import java.util.*;

public class PruebaList {

	public static void main (String[] args)
	{
		//OPERACIONES B�SICAS
		//1. Declaramos una collecci�n de n�meros enteros
		Collection<Integer> lista1;
	
		//2. Creamos una lista de enteros usando la implementaci�n disponible: ArrayList<T>, invocando el constructor sin par�metros
		lista1 = new ArrayList<>();
		
		//3. Comprobamos si la lista est� o no vac�a
		if (lista1.isEmpty())
		{
			System.out.println("Lista vacia...");
		}
		
		//4. A�adimos varios elementos a la lista usando el m�todo add. Los a�ade duplicados porque es una lista
		lista1.add(1);
		lista1.add(2);
		if (lista1.add(2))
		{ 
			System.out.println("A�adido");
		}else{
			System.out.println("El elemento ya estaba. No se ha a�adido");
		}
		lista1.add(3);
		
		//5. Eliminamos un elemento de la lista
		if (lista1.remove(2))
		{
			System.out.println("Elemento eliminado");
		}
		lista1.remove(1);
		
		//6. Consultamos el n�mero de elementos en la colecci�n
		System.out.println("El n�mero de elementos es: " + lista1.size());
		
		//7. A�adimos nuevos elementos
		lista1.add(10);
		lista1.add(2);
		lista1.add(7);
		lista1.add(1);
		
		//OPERACIONES CON GRUPOS DE ELEMENTOS
		//8. Creamos una nueva lista
		Set<Integer> lista2 = new HashSet<>();
		
		//9. A�adimos todos los elementos de la otra lista en esta, con una sola operaci�n
		lista2.addAll(lista1);
		
		//10. Eliminamos alg�n elemento de lista2
		lista2.remove(1);
		
		//11. Creamos una tercera lista a la que le a�adimos todos los elementos de la primero y luego le eliminamos todos los de la segunda
		Set<Integer> lista3 = new HashSet<>();
		lista3.addAll(lista1);
		lista3.removeAll(lista2);
		
		//12. Recorremos las tres listas, iterando sobre ellas
		System.out.println("Conjunto 1 ...");
		recorrerColeccionIterador(lista1);
		
		System.out.println("Conjunto 2 ...");
		recorrerColeccionIterador(lista2);

		System.out.println("Conjunto 3 ...");
		recorrerColeccionIterador(lista3);
		
		//13. Recorremos la lista 1 con for-each
		System.out.println("Conjunto 1 con for-each ...");
		for (Integer v: lista1)
		{
			System.out.print(v + " ");
		}
		System.out.println();
	}
	
	public static void recorrerColeccionIterador(Collection<Integer> c){
		Iterator<Integer> it = c.iterator();
		while (it.hasNext())
		{
			System.out.print(it.next() + " ");
		}
		System.out.println();
	}
	
	
}
