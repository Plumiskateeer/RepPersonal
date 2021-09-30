package prPractica21;

public class Mesa extends Jarra{

	public Mesa(int contenido1, int contenido2) {
		super(contenido1);
		Jarra Jarra1 = new Jarra(contenido1);
		Jarra Jarra2 = new Jarra(contenido2);

	}
	public Mesa(Jarra j1, Jarra j2) {
		super(j1.contenido());
	}

	
	
}
