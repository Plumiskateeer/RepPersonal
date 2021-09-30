
public class Barco implements Comparable<Barco>{

	protected String nombre;
	protected Posicion posicion;
	protected int rumbo,velocidad;
	
	
	public Barco(String nombre, Posicion posicion, int rumbo, int velocidad) {
		
		this.nombre = nombre;
		this.posicion = posicion;
		if(rumbo <=359 && rumbo >= 0) this.rumbo = rumbo;
		else throw new RegataException("Rumbo feo");
		this.velocidad = velocidad;
	}


	public String getNombre() {
		return nombre;
	}


	public Posicion getPosicion() {
		return posicion;
	}


	public int getRumbo() {
		return rumbo;
	}


	public int getVelocidad() {
		return velocidad;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Barco) {
			Barco aux = (Barco)obj;
			this.nombre.equalsIgnoreCase(aux.nombre);
		}return false;
	}


	public int compareTo(String anotherString) {
		return nombre.compareTo(anotherString);
	}


	void avanza(int mnt) {
		
		this.posicion = posicion.posicionTrasRecorrer(mnt, this.rumbo, this.velocidad);
			
		
	}
	
	@Override
	public String toString() {
		return this.nombre + ": " + "l=" + this.posicion.toString() 
					+ " R= "+ this.rumbo + "V= "+ this.velocidad;
	}


	@Override
	public int compareTo(Barco arg0) {
		
		return this.nombre.compareTo(arg0.nombre);
	}
	
	
	
	
	
	
}
