import java.util.Set;
import java.util.TreeSet;

public class CuentaModerada extends Cuenta{
	
		private Set<String>palabrasbloqueadas;
		private Set<String>mensaje;
		private Cuenta cuenta;
	
	
	public CuentaModerada(String usr, Set<String>c) {
		
		super(usr);
		
		if(usr==null || c.size() ==0 || c == null) {
			
			throw new AppException("Los datos introducidos al crear la cuenta moderada son incorrectos");
		
		}else {
			palabrasbloqueadas = new TreeSet<>();
			mensaje = new TreeSet<>();
			cuenta = new Cuenta(usr);
			
			mensaje.clear();
			
			
			for(@SuppressWarnings("unused") String s  : c) {
				palabrasbloqueadas.add(c.toString().toUpperCase());
			}
		}
		
	}
	
	public void addMsj(String receptor,String txt) {
		
		if(palabrasbloqueadas.contains(txt)) {
			throw new AppException("El texto recibido al añadir mensaje contiene una palabra no permitida");
		}
		else {
			cuenta.addMsj(receptor, txt);
		}
	}
	
	

}
