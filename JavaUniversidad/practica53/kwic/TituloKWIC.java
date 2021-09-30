
package kwic;

public class TituloKWIC implements Comparable<TituloKWIC> {
	private String frase;
	public TituloKWIC(String f) {
		frase = f;
	}
	@Override
	public String toString() {
		return frase;
	}
	@Override
	public boolean equals(Object o) {
		boolean ok = false;
		if (o instanceof TituloKWIC) {
			TituloKWIC x = (TituloKWIC)o;
			ok = this.frase.equalsIgnoreCase(x.frase);
		}
		return ok;
	}
	@Override
	public int hashCode() {
		return frase.toLowerCase().hashCode();
	}
	@Override
	public int compareTo(TituloKWIC o) {
		return frase.compareToIgnoreCase(o.frase);
	}
}
