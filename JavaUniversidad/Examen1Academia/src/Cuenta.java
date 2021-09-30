import java.util.SortedSet;
import java.util.TreeSet;

public class Cuenta {

	private String nombreusuario;
	private SortedSet<Mensaje> mensajes;
	
	public Cuenta(String usr) {
		this.nombreusuario = usr;
		mensajes = new TreeSet<>();
	}
	
	public String getUsuario() {
		return nombreusuario;
	}
	
	public void addMsj(String receptor, String txt){
		
		Mensaje m = new Mensaje(this.nombreusuario, receptor, txt);
		mensajes.add(m);
	}
	
	public SortedSet<Mensaje> getMsg(Filtro flt){
		SortedSet <Mensaje> sol =  new TreeSet<>();
		
		if(flt == null) {
			sol.addAll(mensajes);
		}else {
		
		for(Mensaje i : mensajes) {
			if(flt.select(i)) {
				sol.add(i);
			}
		}
		}
		return sol;
	}
	
	@Override
	public String toString() {
		
		return mensajes.toString();
	}
}
