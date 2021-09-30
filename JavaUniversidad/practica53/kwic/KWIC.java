
package kwic;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class KWIC {
	private static final String NOSIG_DELIMITERS = "[\\s]+";
	protected static final String PAL_DELIMITERS = "[,;:.\\s]+";
	private List<String> palabrasNoSig;
	private SortedMap<String, SortedSet<TituloKWIC>> indice;
	public KWIC() {
		palabrasNoSig = new ArrayList<String>();
		indice = new TreeMap<String, SortedSet<TituloKWIC>>();
	}
	public void palabrasNoSignificativas(String nomFich)
		throws FileNotFoundException {
		try (Scanner sc = new Scanner(new File(nomFich))) {
			palabrasNoSignificativas(sc);
		}
	}
	private void palabrasNoSignificativas(Scanner sc) {
		sc.useDelimiter(NOSIG_DELIMITERS);
		while (sc.hasNext()) {
			String pns = sc.next().toUpperCase();
			if (! palabrasNoSig.contains(pns) ) {
				palabrasNoSig.add(pns);
			}
		}
	}
	public void generaIndice(String nomFich) 
		throws FileNotFoundException {
		try (Scanner sc = new Scanner(new File(nomFich))) {
			generaIndice(sc);
		}
	}
	private void generaIndice(Scanner sc) {
		while (sc.hasNextLine()) {
			this.anyadir(sc.nextLine());
		}
	}
	protected void anyadir(String frase) {
		TituloKWIC titulo = new TituloKWIC(frase);
		try (Scanner sc = new Scanner(frase)) {
			sc.useDelimiter(PAL_DELIMITERS);
			while (sc.hasNext()) {
				this.anyadir(sc.next(), titulo);
			}
		}
	}
	protected void anyadir_AlternativoConSplit(String frase) {
		TituloKWIC titulo = new TituloKWIC(frase);
		String[] pal = frase.split(PAL_DELIMITERS);
		for (int i = 0; i < pal.length; ++i) {
			if (i > 0 || pal[i].length() > 0) { // ignora el primero si vacío
				this.anyadir(pal[i], titulo);
			}
		}
	}
	protected void anyadir(String pal, TituloKWIC titulo) {
		pal = pal.toUpperCase();
		if (! palabrasNoSig.contains(pal) ) {
			SortedSet<TituloKWIC> lista = indice.get(pal);
			if (lista == null) {
				lista = new TreeSet<TituloKWIC>();
				indice.put(pal, lista);
			}
			lista.add(titulo);
		}
	}
	public void presentaIndice(String nomFich) 
		throws FileNotFoundException {
		try (PrintWriter pw = new PrintWriter(nomFich)) {
			this.presentaIndice(pw);
		}
	}
	public void presentaIndice(PrintWriter pw) {
		for (Map.Entry<String, SortedSet<TituloKWIC>> e : indice.entrySet()) {
			SortedSet<TituloKWIC> lista = e.getValue();
			pw.println(e.getKey());
			for (TituloKWIC f : lista) {
				pw.println("\t" + f);
			}
		}
	}
}
