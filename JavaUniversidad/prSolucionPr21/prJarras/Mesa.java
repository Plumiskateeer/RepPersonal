package prJarras;

public class Mesa {
	private Jarra jarra1;
	private Jarra jarra2;
	
	public Mesa(int capacidad1, int capacidad2) {
		jarra1 = new Jarra(capacidad1);
		jarra2 = new Jarra(capacidad2);
	}
	
	public Mesa(Jarra j1, Jarra j2) {
		jarra1 = j1;
		jarra2 = j2;
	}
	
	private Jarra getJarra(int id) {
		Jarra laJarra = null;
		switch (id) {
			case 1: laJarra = jarra1; break;
			case 2: laJarra = jarra2; break;
			default: throw new RuntimeException();
		}
		return laJarra;
	}
	
	public int capacidad(int id) {
		return getJarra(id).capacidad();
	}
	
	public int contenido(int id) {
		return getJarra(id).contenido();
	}
	
	public void llena(int id) {
		getJarra(id).llena();
	}
	
	public void vacia(int id) {
		getJarra(id).vacia();
	}
	
	public void llenaDesde(int idEmisora) {
		Jarra emisora = getJarra(idEmisora);
		Jarra receptora = (idEmisora == 1)?jarra2:jarra1;
		receptora.llenaDesde(emisora);
	}
	
	@Override
	public String toString() {
		return "M("+ jarra1 + "," + jarra2 + ")";
	}
}
