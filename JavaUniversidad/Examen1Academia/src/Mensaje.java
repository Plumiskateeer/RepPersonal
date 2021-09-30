
public class Mensaje implements Comparable<Mensaje>{

	private static int cntSecuencia = 1;
	private int secuencia;
	private String emisor, receptor, texto;
	
	public Mensaje(String emisor, String receptor, String texto) {
		
		
		if(emisor == null || emisor == "")throw new AppException();
		if(receptor == null || receptor == "")throw new AppException();
		if(texto == null || texto== "")throw new AppException();
			
		this.emisor = emisor;
		this.receptor = receptor;
		this.texto = texto;
		this.secuencia = Mensaje.cntSecuencia;
		Mensaje.cntSecuencia++;
	}

	public String getEmisor() {
		return emisor;
	}

	

	public String getReceptor() {
		return receptor;
	}

	

	public String getTexto() {
		return texto;
	}

	@Override
	public String toString() {
		return "(" + emisor + "; " + receptor + "; "+ texto + ")";
	}

	@Override
	public int hashCode() {
		
		return this.secuencia + this.emisor.toUpperCase().hashCode()
				+this.receptor.toUpperCase().hashCode();
		
	}

	@Override
	public boolean equals(Object obj) {
		
		if(obj instanceof Mensaje) {
			
			Mensaje otro = (Mensaje)obj; // aqui como sabes que obj es de tipo mensaje creas "otro" para manejar el emisor texto etc, porque no podrias hacer obj.emisor
			return this.secuencia == otro.secuencia
					&& this.emisor.equalsIgnoreCase(otro.receptor)
					&& this.receptor.equalsIgnoreCase(otro.receptor);
		}
		
		return false;
	}

	@Override
	public int compareTo(Mensaje o) {
		
		int res = 0;
		if(secuencia < o.secuencia) res  = -1;
		else if(secuencia > o.secuencia)res = 1;
		else {
			 res = emisor.compareToIgnoreCase(o.emisor);
			 if(res == 0) {
				 res = receptor.compareToIgnoreCase(o.receptor); // si da todo el rato 0 y llega hasta aqui, significa que lo anterior era igual todo porq da 03
			 }
		}
		return res;
	}

	
	
	
	
	
	
}
