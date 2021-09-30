package prNotas;

public class MediaArmonica implements CalculoMedia{

	@Override
	public double calcular(Alumno[] als) throws AlumnoException {
		if (als.length == 0){
			throw new AlumnoException("No hay alumnos para calcular la media");
		}
		
		int n = 0;
		double suma = 0.0;
		
		for(Alumno al : als){
			double nota = al.getCalificacion();
			if (nota > 0.0){
				suma += 1/nota;
				n++;
			}
		}
		
		return n/suma;
	}

}
