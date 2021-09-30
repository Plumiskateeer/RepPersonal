import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class RedSocial {
	private String usuarioactivo;
	private Set<Cuenta>cuentasasociadas;
	
	public RedSocial() {
		cuentasasociadas = new TreeSet<>();
		cuentasasociadas.clear();
		
		Cuenta cuenta = new Cuenta("ADMIN");
		cuentasasociadas.add(cuenta);
		
	}
	
	public void login(String usr) {
		
		Cuenta aux = new Cuenta(usr.toUpperCase());
		
		if(!cuentasasociadas.contains(aux)) {
			throw new AppException("La cuenta a la que intenta acceder no esta registrada");
		}else {
			this.usuarioactivo = usr.toUpperCase();
		}
	}
	
	public void logout() {
		this.usuarioactivo = null;
	}
	
	public void crearCuenta(String usr) {
		
		Cuenta aux = new Cuenta(usr.toUpperCase());
		
		if(usuarioactivo != "ADMIN" || cuentasasociadas.contains(aux)) {
			throw new AppException("No es posible crear una nueva cuenta con ese usuario");
		}else {
			Cuenta nuevacuenta = new Cuenta(usr.toUpperCase());
			cuentasasociadas.add(nuevacuenta);		}
	}
	
	public void addMsj(String receptor, String txt) {
		
		Cuenta cuentaactivo = new Cuenta(usuarioactivo);
		
		cuentaactivo.addMsj(receptor, txt);
				
	}
	
	public SortedSet<Mensaje> getMsjsCon(String usr){
		
		Cuenta comprobar = new Cuenta(usr.toUpperCase());
		Cuenta cuentaactivo = new Cuenta(usuarioactivo.toUpperCase());
		SortedSet<Cuenta>conjuntoordenado = new TreeSet<>();
		
		if(!cuentasasociadas.contains(comprobar)) {
			throw new AppException("La cuenta no existe");
		}else {
			/// te has quedado por aqui con la duda del conjunto ordenado segun orden natural
		}
		
		
		
	}
}