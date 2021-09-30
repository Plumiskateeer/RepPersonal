

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import notas.Alumno;
import notas.AlumnoException;
import notas.Asignatura;

public class Main {
	static String[] als = { "25653443S;Garcia Gomez, Juan;8.1",
			"23322443K;Lopez Turo, Manuel;4.3",
			"24433522M;Merlo Martinez, Juana;5.3",
			"53553421D;Santana Medina, Petra;7.1",
			"55343442L,Godoy Molina, Marina;6.3",
			"342424f2J;Fernandez Vara, Pedro;tr",
			"42424312G;Lopez Gama, Luisa;7.1" };

	public static void main(String[] args) throws FileNotFoundException {
		Asignatura algebra = new Asignatura("Algebra", als);

		try {
			Alumno al1 = new Alumno("Lopez Turo, Manuel", "23322443k");
			Alumno al2 = new Alumno("Fernandez Vara, Pedro", "342424f2J");
			System.out.println("Calificacion de " + al1 + ": "
					+ algebra.getCalificacion(al1));
			System.out.println("Calificacion de " + al2 + ": "
					+ algebra.getCalificacion(al2));
		} catch (AlumnoException e) {
			System.err.println(e.getMessage());
		}
		try {
			System.out.println("Media " + algebra.getMedia());
		} catch (AlumnoException e) {
			System.out.println("Error "+ e.getMessage());
		}
		System.out.println("Alumnos...");
		for (Alumno alumno : algebra.getAlumnos()) {
			System.out.println(alumno + ": " + alumno.getCalificacion());
		}
		System.out.println("Malos...");
		for (String malo : algebra.getErrores()) {
			System.out.println(malo);
		}
		System.out.println(algebra);
	}
}

