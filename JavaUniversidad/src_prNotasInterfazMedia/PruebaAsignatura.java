import prNotas.Alumno;
import prNotas.AlumnoException;
import prNotas.Asignatura;
import prNotas.MediaAritmetica;

public class PruebaAsignatura {

	public static void main(String[] args) {
		String[] datos ={"12455666F;Lopez Perez,Pedro;6.7",
						"33678999D;Merlo Gomez, Isabel;5.8",
						"23555875G;Martinez Herrera, Lucia;9.1"};
		Asignatura poo = new Asignatura("POO",datos);
		
		try{
			System.out.println("Media aritmetica = " + poo.getMedia(new MediaAritmetica()));
			for (Alumno al : poo.getAlumnos()){
				System.out.println(al.getDni());
			}
			System.out.println("La calificacion del alumno Lopez Perez es " + 
							 	poo.getCalificacion(new Alumno("Lopez Perez,Pedro","12455666F")));
		}catch (AlumnoException e){
			System.out.println("Error -> " + e.getMessage());
		}

	}

}
