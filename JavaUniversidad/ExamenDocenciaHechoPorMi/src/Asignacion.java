import java.io.File;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Asignacion {
	protected Map<Docente, Set<Asignatura>>asignacion;
	
	public Asignacion()  {
		asignacion = new TreeMap<Docente, Set<Asignatura>>();
	}
	
	public Asignacion(String s) {
		this();
		leeAsignacionFichero(s);
		
	}
	
	protected String leeAsignacionFichero(String fichero) {
		
		StringBuilder sb = new StringBuilder(fichero);
		
		
		
		
	}
	protected Scanner leeAsignacion(Scanner sc) {
		
	}
	
	public Docente leerDocente(String s) {
		
	}
	
	protected Asignatura leerAsignatura(String s) {
		
	}
	
	public void insertaAsignacionProfesor(Docente docente, Set<Asignatura>asignaturas) {
		if(asignacion.containsKey(docente)) {
			asignacion.getOrDefault(docente,asignaturas);
			int sumacreditosasignaturas = 0;
			for(Asignatura a : asignaturas) {
				sumacreditosasignaturas += a.getHorascreditos();
			}
			docente.setCarga(sumacreditosasignaturas);
			}else {
				int sumacreditosasignaturas = 0;
				for(Asignatura a : asignaturas) {
					sumacreditosasignaturas += a.getHorascreditos();
				}
				docente.setCarga(sumacreditosasignaturas);
			}
	}

	@Override
	public String toString() {
		return asignacion.toString();
	}
	
	
	
}
