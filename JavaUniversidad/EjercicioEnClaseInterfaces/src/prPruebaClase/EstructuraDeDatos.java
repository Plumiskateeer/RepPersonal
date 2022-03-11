package prPruebaClase;

public interface EstructuraDeDatos {

	void meter(int elem);
	int sacar();
	int tamano();
	default boolean estaVacia() {
		return(tamano()==0);
	}
}
