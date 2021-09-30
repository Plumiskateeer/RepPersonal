package prBuses;

public class Bus {
	private int codBus;
	private int codLinea;
	private String matricula;
	
	public Bus(int codBus, String matricula) {
		this.codLinea = 0;
		this.codBus = codBus;
		this.matricula = matricula;
	}
	
	public int getCodBus() {
		return codBus;
	}
	public int getCodLinea() {
		return codLinea;
	}
	public String getMatricula() {
		return matricula;
	}
	
	public void setCodLinea (int codLinea) {
		
		
	}
	

	@Override
	public int hashCode() {
		
		return this.codBus + matricula.toUpperCase().hashCode();
	}

	@Override
	public String toString() {
		return "Bus [codBus=" + codBus + ", codLinea=" + codLinea + ", matricula=" + matricula + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Bus) {
			Bus otro = (Bus) obj;
			return this.codBus == otro.codBus && this.matricula.equalsIgnoreCase(otro.matricula);
		}
		
	}
	

}
