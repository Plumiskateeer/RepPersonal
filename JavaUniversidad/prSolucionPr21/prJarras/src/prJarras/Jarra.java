/**
 * @author ANGEL MANUEL JOAQUIN YEBENES
 */

package prJarras;

public class Jarra {
	
	private int contenido;
	private final int capacidad;
	
	public Jarra(int capacidad){
		contenido = 0;
		this.capacidad = capacidad;
		
	}
	
	public int capacidad() {
		return capacidad;
	}
	
	public int contenido() {
		return contenido;
	}
	
	public void llena() {
		contenido=capacidad;
	}
	
	public void vacia() {
		contenido=0;
	}

	public void llenaDesde(Jarra j) {
		int queda = capacidad - contenido;
		
		if(j.contenido() > queda){
			this.llena();
			j.contenido -= queda;
		}else{
			this.contenido += j.contenido;
			j.vacia();
			
		}
	}
	
	@Override
	public  String toString() {
	
		return "J("+capacidad + "," + contenido + ")";
		
	}
}
