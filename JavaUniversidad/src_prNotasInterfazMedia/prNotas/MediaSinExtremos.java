package prNotas;

public class MediaSinExtremos implements CalculoMedia{
	private double min;
	private double max;
	
	public MediaSinExtremos(double min, double max){
		this.min = min;
		this.max = max;
	}

	@Override
	public double calcular(Alumno[] als) throws AlumnoException{
		int n = 0;
		double suma = 0.0;
		
		for(Alumno al : als){
			double nota = al.getCalificacion();
			if (nota >= min && nota <= max ){
				suma += nota;
				n++;
			}
		}
		
		if (n==0){
			throw new AlumnoException("No hay alumnos para calcular la media");
		}
		
		return suma/n;
	}
	
	
}
