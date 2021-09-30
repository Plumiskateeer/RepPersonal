package prParking;

public class Parking {
	
	private String identificador;
	private Posicion posicion;
	private final String LIBRE = "libre";
	private String[][] ocupacion;
	private final int HORAS = 23;
	private int numplazas;
	
	
	public Parking(String identificador, Posicion posicion, int numplazas) {
		
		if(numplazas > 0) ocupacion = new String[numplazas][HORAS];
		else throw new ParkingException("El numero de plazas es incorrecto");
		
		this.identificador = identificador;
		this.posicion = posicion;
		this.numplazas = numplazas;
		
		for(int i = 0; i < numplazas ; i++) {
			for(int j = 0; j < HORAS ; j++)
				ocupacion[i][j] = LIBRE;
		}
		
	}
	
	public String getId() {
		return this.identificador;
	}
	
	public Posicion getPosicion() {
		return this.posicion;
	}
	
	private boolean hayHuecoEnPlaza(Vehiculo v, int pz) {
		boolean estaLibre = true;
		
		if(pz >= 0) {
		
		for(int i = v.getHoraEntrada(); i < v.getHoraSalida() ; i++) {
			if(ocupacion[pz][i]!=LIBRE) estaLibre = false;
		}
		
		}else throw new ParkingException("El numero de la plaza es incorrecto");
		
		return estaLibre;
		
	}
	
	public int buscarPlaza(Vehiculo v) {
		int plazalibre = 0;
		
		for(int i= 0; i < this.numplazas; i++) {	
		for(int j= v.getHoraEntrada(); j < v.getHoraSalida(); j++) {
			if(ocupacion[i][j]==LIBRE) {
				plazalibre = i;
			}
			
		}}
		return plazalibre;
		
	}
	
	public boolean reservarPlaza(Vehiculo v, int pz) {
		
		boolean plazareservada = false;
		
		if(pz>=0) {
			if(hayHuecoEnPlaza(v, pz)) {
		
			
			for(int i = v.getHoraEntrada(); i < v.getHoraSalida() ; i++) {
				ocupacion[pz][i] = v.getMatricula();
			}
			plazareservada = true;
			}else {
				plazareservada = false;
			}
		
		}else throw new ParkingException("El numero de la plaza es incorrecto");
		
		return plazareservada;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		boolean res = false;
		
		if(obj instanceof Parking) {
			Parking aux = (Parking) obj;
			res = aux.identificador == this.identificador && 
				  aux.posicion == this.posicion;
		}
		return res;
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(this.identificador +this.posicion.toString());
		sb.append("\n");
		sb.append("[");
		for(int i= 0; i < this.numplazas; i++) {	
			for(int j= 0; j < HORAS; j++) {
				if(j != HORAS - 1) sb.append(ocupacion[i][j] + ",");
				else sb.append(ocupacion[i][j]);
				
			}
			
			}
		sb.append("]");
		return sb.toString();
	}

}
