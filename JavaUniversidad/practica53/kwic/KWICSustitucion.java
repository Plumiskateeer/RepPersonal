
package kwic;

import java.io.PrintWriter;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Map;
import java.util.Scanner;

public class KWICSustitucion extends KWIC {
	public KWICSustitucion() {
		super();
	}
	@Override
	protected void anyadir(String frase) {
		try (Scanner sc = new Scanner(frase)) {
			sc.useDelimiter(PAL_DELIMITERS);
			while (sc.hasNext()) {
				String pal = sc.next();
				TituloKWIC titulo = new TituloKWICSustitucion(frase, pal);
				this.anyadir(pal, titulo);
			}
		}
	}
	@Override
	protected void anyadir_AlternativoConSplit(String frase) {
		String[] pal = frase.split(PAL_DELIMITERS);
		for (int i = 0; i < pal.length; ++i) {
			if (i > 0 || pal[i].length() > 0) { // ignora el primero si vacío
				TituloKWIC titulo = new TituloKWICSustitucion(frase, pal[i]);
				this.anyadir(pal[i], titulo);
			}
		}
	}
}
