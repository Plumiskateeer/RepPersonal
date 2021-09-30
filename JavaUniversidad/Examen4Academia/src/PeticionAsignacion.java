package prExJunio2016;

public class PeticionAsignacion implements Comparable<PeticionAsignacion>{
	private String profesor;
	private String asignatura;
	private FranjaHoraria franja;
	
	public PeticionAsignacion(String np, String na, FranjaHoraria fh )  {
		profesor = np;
		asignatura = na;
		franja = fh;
	}
		 
	public String getProfesor() {
		return profesor;
	}
	
	public String getAsignatura() {
		return asignatura;
	}
	
	public FranjaHoraria getFranja() {
		return franja;
	}
	
	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(franja).append(" -> ");
		sb.append(asignatura).append(", ").append(profesor);
		return sb.toString();
	}
	
	@Override public boolean equals(Object obj) {
		boolean res = obj instanceof PeticionAsignacion;
		PeticionAsignacion pa = res ? (PeticionAsignacion)obj : null;
		return res && franja.getDia().equals(pa.franja.getDia()) &&
				franja.getHora().equals(pa.franja.getHora());
	}
	
	@Override public int hashCode() {
		return franja.getDia().hashCode() + franja.getHora().hashCode();
	}
	
	@Override public  int compareTo(PeticionAsignacion pa) {
		int res = franja.getDia().compareTo(pa.franja.getDia());
		if (res == 0) {
			res = franja.getHora().compareTo(pa.franja.getHora());
		}
		return res;
	}	
}
