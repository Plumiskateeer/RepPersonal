import java.util.Comparator;

public class OrdenAltEquipo implements Comparator<Equipo> {


	@Override
	public int compare(Equipo o1, Equipo o2) {
		
		int res = o1.getCategoria() - o2.getCategoria();
		if(res == 0) res = o1.getNombre().compareToIgnoreCase(o2.getNombre());
		if(res == 0) res = o1.getPuntos() - o2.getPuntos();
		
		return res;

	}

}
