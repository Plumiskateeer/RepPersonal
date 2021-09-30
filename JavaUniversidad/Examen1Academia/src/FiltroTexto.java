import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class FiltroTexto implements Filtro {

	private Set <String> claves;
	
	public FiltroTexto(Set<String> c) {
		
		claves = new HashSet<>();
		
		for(String s : c) {
			claves.add(s.toUpperCase());
		}
	}
	
	@Override
	public boolean select(Mensaje m) {
		
		Iterator<String> it = claves.iterator();
		
		boolean encontrado = false;
		while(it.hasNext()) {
			
			String s = it.next();
			encontrado = m.getTexto().toUpperCase().contains(s);
			
		}
		
		return encontrado;
	}
}
