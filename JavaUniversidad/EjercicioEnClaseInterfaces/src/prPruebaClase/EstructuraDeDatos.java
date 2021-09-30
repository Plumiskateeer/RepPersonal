package prPruebaClase;

public interface EstructuraDeDatos {

	void meter(int elem);
	int sacar();
	int tamaño();
	default boolean estaVacia() {
		return(tamaño()==0);
	}
}
