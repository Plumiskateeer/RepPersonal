package claseTeoriaColecciones;

import java.util.*;

public class PruebaSet {

	public static void main (String[] args)
	{
		//OPERACIONES B�SICAS
		//1. Declaramos una variable para guardar un conjunto no ordenado de n�meros enteros
		Set<Integer> conj1;
		//�Qu� pasa si cambiamos Set<Integer> por Collection<Integer>?
		//Collection<Integer> conj1;
	
		//2. Creamos un conjunto de enteros usando la implementaci�n disponible: HashSet<T>, invocando el constructor sin par�metros
		conj1 = new HashSet<>();
		
		//3. Comprobamos si el conjunto est� o no vac�o
		if (conj1.isEmpty())
		{
			System.out.println("Conjunto vacio...");
		}
		
		//4. A�adimos varios elementos al conjunto usando el m�todo add. Si lo a�adimos duplicado no lo a�ade porque es un conjunto
		conj1.add(1);
		conj1.add(2);
		if (conj1.add(2))
		{ 
			System.out.println("A�adido");
		}else{
			System.out.println("El elemento ya estaba. No se ha a�adido");
		}
		conj1.add(3);
		
		//5. Eliminamos un elemento del conjunto
		if (conj1.remove(2))
		{
			System.out.println("Elemento eliminado");
		}
		conj1.remove(1);
		
		//6. Consultamos el n�mero de elementos en la colecci�n
		System.out.println("El n�mero de elementos es: " + conj1.size());
		
		//7. A�adimos nuevos elementos
		conj1.add(10);
		conj1.add(2);
		conj1.add(7);
		conj1.add(1);
		
		//OPERACIONES CON GRUPOS DE ELEMENTOS
		//8. Creamos un nuevo conjunto
		Set<Integer> conj2 = new HashSet<>();
		
		//9. A�adimos todos los elementos del otro conjunto en este, con una sola operaci�n
		conj2.addAll(conj1);
		
		//10. Eliminamos alg�n elemento de conj2
		conj2.remove(1);
		
		//11. Creamos un tercer conjunto al que le a�adimos todos los elementos del primero y luego le eliminamos todos los del segundo
		Set<Integer> conj3 = new HashSet<>();
		conj3.addAll(conj1);
		conj3.removeAll(conj2);
		
		//12. Recorremos los tres conjuntos, iterando sobre ellos
		System.out.println("Conjunto 1 ...");
		recorrerColecci�nIterador(conj1);
		
		System.out.println("Conjunto 2 ...");
		recorrerColecci�nIterador(conj2);

		System.out.println("Conjunto 3 ...");
		recorrerColecci�nIterador(conj3);
		
		//13. Recorremos el conjunto 1 con for-each
		System.out.println("Conjunto 1 con for-each ...");
		for (Integer v: conj1)
		{
			System.out.print(v + " ");
		}
		System.out.println();
	}
	
	public static void recorrerColecci�nIterador(Collection<Integer> c){
		Iterator<Integer> it = c.iterator();
		while (it.hasNext())
		{
			System.out.print(it.next() + " ");
		}
		System.out.println();
	}
	
	
}
