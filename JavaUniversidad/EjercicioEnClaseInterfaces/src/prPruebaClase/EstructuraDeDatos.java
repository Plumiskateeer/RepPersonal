package prPruebaClase;

public interface EstructuraDeDatos {

	void meter(int elem);
	int sacar();
	int tama�o();
	default boolean estaVacia() {
		return(tama�o()==0);
	}
}
