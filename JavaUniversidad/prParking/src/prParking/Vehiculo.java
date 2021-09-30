package prParking;

public class Vehiculo {

	private String matricula;
	private Posicion posActual;
	private int horaEntrada, horaSalida;
	
	
	public Vehiculo(String matricula, Posicion posActual, int horaEntrada, int horaSalida) {
		
		this.matricula = matricula;
		this.posActual = posActual;
		
		if(horaSalida > horaEntrada) {
			
		if(horaEntrada >=0 && horaEntrada <=23) this.horaEntrada = horaEntrada;
		else throw new ParkingException("La hora de entrada es incorrecta");
		
		if(horaSalida >=1 && horaSalida <= 24) this.horaSalida = horaSalida;
		else throw new ParkingException("La hora de salida es incorrecta");
		
		}else throw new ParkingException("La franja horaria establecida es incorrecta");
		
	}
	
	@Override
	public String toString(){
		return "Vehiculo :" + this.matricula + ", " + posActual.toString() + ", " 
				+ "horas: (" + this.horaEntrada + ", " + this.horaSalida + ")";		
	}
	
	public String getMatricula() {
		return matricula;
	}
	public int getHoraEntrada() {
		return horaEntrada;
	}
	public int getHoraSalida() {
		return horaSalida;
	}
	public Posicion getPosActual() {
		return posActual;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		boolean res = false;
		if(obj instanceof Vehiculo) {
			Vehiculo aux = (Vehiculo) obj;
			res = aux.getMatricula() == this.matricula;
		}
		
		return res;
	}
	
}
