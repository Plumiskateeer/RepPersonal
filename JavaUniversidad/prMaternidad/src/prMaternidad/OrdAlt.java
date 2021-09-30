package prMaternidad;

import java.util.Comparator;

public class OrdAlt implements Comparator<Persona>{

	@Override
	public int compare(Persona o1, Persona o2) {

		int res = o1.getNombre().compareToIgnoreCase(o2.getNombre());
		
		if(res == 0) res = o1.getCodigo() - o2.getCodigo();
		
		if(res < 0) res = -1;
		else if(res > 0) res = 1;
		else res = 0;
		
		return res;
	}

}
