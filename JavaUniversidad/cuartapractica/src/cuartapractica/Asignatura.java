package cuartapractica;

import java.util.*;

public class Asignatura  {
	
	private String nombre;
	private String [] errores;
	private Alumno [] alumnos;
	
	public Asignatura(String nombre, String [] datos) {
		
		this.nombre = nombre;
		alumnos  =  new Alumno[datos.length];
		errores = new String[datos.length];
		
		int longalumnos = 0;
		int longerrores = 0;
		
		for(String datos1 : datos) {
			try(Scanner sc  = new Scanner(datos1)){
				sc.useDelimiter(";");
				sc.useLocale(Locale.ENGLISH);
				
				String dni = sc.next();
				String n = sc.next();
				double nota = sc.nextDouble();
				
				Alumno al = new Alumno(n,dni,nota);
				alumnos[longalumnos] = al;
				longalumnos++;

			}catch(AlumnoException e) {
				errores[longerrores] ="Error" + e.getMessage() + " en " + datos1;
				longerrores++;
			} catch (InputMismatchException e) {
				errores[longerrores] = "Error, nota no numérica " + datos1;
				longerrores++;				
			} catch  (NoSuchElementException e) {
				errores[longerrores] = "Error, faltan datos en " + datos1;
				longerrores++;
			}
		}
		
		errores = Arrays.copyOf(errores,longerrores);
		alumnos = Arrays.copyOf(alumnos,longalumnos);
		
	}
	
	public double getCalificacion(Alumno al)throws AlumnoException {
		
		int i = 0;
		
		while(i < alumnos.length && !alumnos[i].equals(al) ) {
			
		}
		
		
	}
	
	public double getMedia(){
		
	}
	
	public Alumno[] getAlumnos() {
		
	}
	
	public String[] getErrores(){
		
	}
	
	public String toString() {
		
	}
}
