
public class Asignatura implements Comparable<Asignatura>{
	private String nombre;
	private int horascreditos;
	private int codigo;
	private int codigocentro;
	
	public Asignatura(String nombre, int horascreditos, int codigo, int codigocentro) throws DocenciaException {
		
		this.nombre = nombre;
		if(horascreditos<=0) throw new DocenciaException("El numero de horas/creditos es incorrecto");
		else {
		this.horascreditos = horascreditos;
		}
		this.codigo = codigo;
		this.codigocentro = codigocentro;
	}

	public String getNombre() {
		return nombre;
	}

	public int getHorascreditos() {
		return horascreditos;
	}

	public int getCodigoAsig() {
		return codigo;
	}

	public int getCodigoCentro() {
		return codigocentro;
	}

	@Override
	public String toString() {
		return nombre + ":" + horascreditos + ":" + codigo + ":" + codigocentro;
	}

	@Override
	public int hashCode() {
		return this.horascreditos;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Asignatura) {
			Asignatura aux = (Asignatura)obj;
			if(aux.codigo == this.codigo && aux.horascreditos == this.horascreditos) return true;
			
		}
		return false;
	}

	@Override
	public int compareTo(Asignatura o) {

		if(this.horascreditos < o.horascreditos) return -1;
		else if (this.horascreditos > o.horascreditos) return 1;
		else if(this.horascreditos == o.horascreditos) {
			if(this.codigo < o.codigo) return -1;
			else if(this.codigo > o.codigo) return 1;
		}
		return 0;
	}
	
	
	
	
	
}
