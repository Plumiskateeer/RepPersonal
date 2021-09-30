package prLaboratorios;

public class PeticionAsignacion implements Comparable<PeticionAsignacion>{
	private String profesor;
	private FranjaHoraria franja;
	private String asignatura;
	
	
	public PeticionAsignacion(String profesor, FranjaHoraria franja, String asignatura) {
		
		this.profesor = profesor;
		this.franja = franja;
		this.asignatura = asignatura;
	}
	
	public String getAsignatura() {
		return asignatura;
	}
	public FranjaHoraria getFranja() {
		return franja;
	}
	public String getProfesor() {
		return profesor;
	}
	
	@Override
	public String toString() {
	
		return this.franja.toString() + " -> " + this.asignatura + " , " + this.profesor + ".";
	}
	
	@Override
	public boolean equals(Object obj) {
		
		boolean res = false;
		
		if(obj instanceof PeticionAsignacion) {
			PeticionAsignacion aux = (PeticionAsignacion) obj;
			res = aux.franja.getDia() == this.franja.getDia() &&
					aux.franja.getHora() == this.franja.getHora();
		}
		
		return res;
	}

	@Override
	public int compareTo(PeticionAsignacion arg0) {
		
		int res = 0;
		if(this.franja.getDia().ordinal() < arg0.franja.getDia().ordinal()) res = -1;
		else if(this.franja.getDia().ordinal() > arg0.franja.getDia().ordinal()) res = +1;
		else if(this.franja.getHora().ordinal() < arg0.franja.getHora().ordinal()) res = -1;
		else if(this.franja.getHora().ordinal() > arg0.franja.getHora().ordinal()) res = +1;
		
		return res;
	}
	

}
