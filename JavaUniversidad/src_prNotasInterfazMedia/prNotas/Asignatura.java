package prNotas;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Asignatura {
	private String nombre;
	private Alumno[] alumnos;
	private String [] errores;
	
	public Asignatura(String n, String [] datos) {
		nombre = n;
		alumnos = new Alumno[datos.length];
		errores = new String[datos.length];
		int numAlumnos = 0;
		int numErrores = 0;
		
		for(String dato: datos) {
			try (Scanner sc = new Scanner(dato)) {
				sc.useDelimiter("[;]");
				sc.useLocale(Locale.ENGLISH);
				String d = sc.next();
				String nn = sc.next();
				double c = sc.nextDouble();
				Alumno al = new Alumno(nn, d, c);
				alumnos[numAlumnos] = al;
				numAlumnos++;
			} catch (InputMismatchException e) {
				errores[numErrores] = "Error, nota no numérica " + dato;
				numErrores++;				
			} catch  (NoSuchElementException e) {
				errores[numErrores] = "Error, faltan datos en " + dato;
				numErrores++;
			} catch (AlumnoException e) {
				errores[numErrores] = "Error, "+ e.getMessage()+ " en " + dato;
				numErrores++;
			}
		}
		alumnos = Arrays.copyOf(alumnos, numAlumnos);
		errores = Arrays.copyOf(errores, numErrores);
	}
	
	public double getCalificacion(Alumno al) throws AlumnoException {
		int i = 0;
		while (i < alumnos.length && !alumnos[i].equals(al)) {
			i++;
		}
		if (i == alumnos.length) {
			throw new AlumnoException("Alumno " + al + " no encontrado");
		}
		//PD i < alumnos.length
		return alumnos[i].getCalificacion();
	}

	public Alumno[] getAlumnos() {
		return alumnos;
	}

	public String[] getErrores() {
		return errores;
	}

	
	public double getMedia(CalculoMedia media) throws AlumnoException{
		return media.calcular(getAlumnos());
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(nombre);
		sb.append(Arrays.toString(alumnos));
		sb.append(Arrays.toString(errores));
		return sb.toString();
	}
}
