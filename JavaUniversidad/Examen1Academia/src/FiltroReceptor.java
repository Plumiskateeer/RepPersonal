
public class FiltroReceptor implements Filtro {

	private String receptor;
	
	public FiltroReceptor(String s) {
		this.receptor = s;
	}
	
	@Override
	public boolean select(Mensaje m) {
			
		return m.getReceptor() == this.receptor;
	}

}
