package primerapractica;

public class Mesa {
	
	private Jarra j1;
	private Jarra j2;
	
	public Mesa(int c1, int c2) {
		
		j1 =  new Jarra(c1);
		j1.vacia();
		j2 = new Jarra(c2);
		j2.vacia();
		
	}
	public Mesa(Jarra j1, Jarra j2) {
		
		this.j1 = j1;
		this.j2 = j2;
	}

	
	public Jarra getJarra(int id) {
		Jarra laJarra = null;
		
		switch(id) {
		case 1: laJarra = this.j1; break;
		case 2: laJarra = this.j2; break;
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
	
		getJarra(id).capacidad();
	
	}
	
	public void llenaDesde(int id) {
		Jarra emisora = getJarra(id);
		Jarra receptora = (id == 1)?j2:j1;
		receptora.llenaDesde(emisora);
		
		
	}
	@Override
	public String toString() {
		return "M(J1(" + j1.capacidad() + "," + j1.contenido() + "),J2("
				+j2.capacidad() + "," + j2.contenido() +")";
	}
	
	
}
