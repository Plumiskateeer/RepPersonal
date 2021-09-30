package prNotas;

public class MediaAritmetica implements CalculoMedia {

	@Override
	public double calcular(Alumno [] als) throws AlumnoException{
		if (als.length == 0){
			throw new AlumnoException("No hay alumnos para calcular la media");
		}
		
		int n = als.length;
		double suma = 0.0;
		
		for (Alumno al : als){
			suma += al.getCalificacion();
		}
		
		return suma/n;
	}

}
