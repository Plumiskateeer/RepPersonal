
import notas.Alumno;
import notas.AlumnoException;;
public class PruebaAlumno {
	public static void main(String [] args) {
		try {
			Alumno al1 = new Alumno("Gonzalez Perez, Juan","33456777s",-5.5);
			Alumno al2 = new Alumno("Gonzalez Perez, Juan","33456777S",3.4);
			System.out.println(al1.getNombre() + " " + al1.getCalificacion());
			System.out.println(al2.getNombre() + " " + al2	.getCalificacion());
			System.out.println(al1.equals(al2));
			System.out.println(al1.hashCode());
			System.out.println(al2.hashCode());
		} catch (AlumnoException e) {
			System.err.println("Alumno mal construido "+ e.getMessage());
			//e.printStackTrace();
		}
	}
}
