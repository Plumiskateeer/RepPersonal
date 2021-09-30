package prTutorialGenericidad;

public interface IPila <T extends Comparable<T>> {
	
	void push (T b) throws PilaLlena, PilaVacia;
	T pop() throws PilaVacia;
	
	void ordena();
	
}
		///  T SE CONVIERTE EN LO QUE LE LLEGUE, BOOL, CHAR, INT.....