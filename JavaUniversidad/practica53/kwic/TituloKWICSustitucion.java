
package kwic;

public class TituloKWICSustitucion extends TituloKWIC {
	public TituloKWICSustitucion(String frase, String pal) {
		super(sustituye(frase, pal));
	}
	private static String sustituye(String frase, String pal) {
		StringBuilder sb = new StringBuilder(frase);
		if (pal.length() > 0) {
			int i = 0;
			while (i+pal.length() <= sb.length()) {
				String s = sb.substring(i, i+pal.length());
				if (pal.equalsIgnoreCase(s)) {
					sb.replace(i, i+pal.length(), "...");
					i += 3;
				} else {
					++i;
				}
			}
		}
		return sb.toString();
	}
}
