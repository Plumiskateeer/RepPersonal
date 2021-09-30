package prTutorialGenericidad;

import java.util.Arrays;

public class Pila<T extends Comparable<T>> implements IPila<T> {

	private T[] elementos;
	private int longitud;
	
	
	@SuppressWarnings("unchecked")
	public Pila() {
		longitud = 0;
		elementos = (T[]) new Object[100];
	}

	@Override
	public void push(T i) throws PilaLlena {
		if(longitud == elementos.length) throw new PilaLlena();
		
		elementos[longitud] = i;
		longitud++;
	}

	@Override
	public T pop() throws PilaVacia {
		if(longitud == 0)throw new PilaVacia();
		
		longitud --;
		return elementos[longitud];
	}

	
	@Override
	public void push(T i) throws PilaLlena {
		if(longitud == 0)throw new PilaLlena();
		
		longitud ++;
		return elementos[longitud];
		
	}

	@Override
	public void ordena() {
		Arrays.sort(elementos);
		
	}

}
