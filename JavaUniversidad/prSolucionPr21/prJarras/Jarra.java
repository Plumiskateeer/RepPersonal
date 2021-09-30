/**
 * @author Juan Miguel Ortiz de Lazcano
 * @version 1.0
 */
package prJarras;

public class Jarra {
	private final int capacidad;
	private int contenido;
	
	/**
	 * Construye una jarra vacía de capacidad dada
	 * 
	 * @param capacidad la capacidad de la jarra.
	 */
	public Jarra(int capacidad) {
		this.capacidad = capacidad;
		this.contenido = 0;
	}

	/**
	 * Devuelve la capacidad de la jarra
	 * @return un valor entero con la capacidad de la jarra
	 */
	public int capacidad() {
		return this.capacidad;
	}
	
	/**
	 * Devuelve el contenido actual de la jarra
	 * @return un valor entero con el contenido de la jarra
	 */
	public int contenido() {
		return this.contenido;
	}
	
	/**
	 * LLena el contenido de la jarra al máximo de su capacidad 
	 */
	public void llena() {
		this.contenido = this.capacidad;
	}
	
	/**
	 * Vacía el contenido de la jarra completamente
	 */
	public void vacia() {
		this.contenido = 0;
	}
	/**
	 * Llena el contenido de la jarra actual con el contenido de la jarra que se recibe como parámetro.
	 * @param origen Jarra emisora
	 */
	public void llenaDesde(Jarra origen) {
		int espacioLibre = this.capacidad - this.contenido;
		if (origen.contenido <= espacioLibre) {
			this.contenido += origen.contenido;
			origen.contenido = 0;
		}else {
			this.contenido = this.capacidad;
			origen.contenido -= espacioLibre;
		}
	}
	
	@Override
	public String toString() {
		return "J(" + capacidad + "," + contenido + ")";
	}
}
