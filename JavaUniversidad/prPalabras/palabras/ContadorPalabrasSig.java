
package palabras;

import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;
import java.io.*;

public class ContadorPalabrasSig extends ContadorPalabras {
	// Array que contiene las palabras no significativas (todas en MAY�SCULA)
	private String[] noSignificativas;
	private final static int TAM = 20;
	private int numPalNoSig;

	public ContadorPalabrasSig(int n, String[] palsNS) {
		super(n);
		incluyeNoSignificativasArray(palsNS);
	}

	public ContadorPalabrasSig(Collection<String> palNS) {
		super();
		incluyeNoSignificativasArray(palNS);
	}
	
	private void incluyeNoSignificativasArray(Collection<String> palNS) {
		noSignificativas = new String[palNS.size()];
		palNS.toArray(noSignificativas);
		for (int i = 0; i < palNS.size(); i++) {
			noSignificativas[i] = palNS.iterator(i);
		}
		numPalNoSig = noSignificativas.length;		
	}

	public ContadorPalabrasSig(int n, String filNoSig, String sep) throws FileNotFoundException {
		super(n);
		noSignificativas = new String[TAM];
		numPalNoSig = 0;
		leerFicheroNoSig(filNoSig, sep);
	}

	public ContadorPalabrasSig(String filNoSig, String sep) throws FileNotFoundException {
		super();
		noSignificativas = new String[TAM];
		numPalNoSig = 0;
		leerFicheroNoSig(filNoSig, sep);

	}

	private void leerFicheroNoSig(String filNoSig, String sep) throws FileNotFoundException {
		try (Scanner sc = new Scanner(new File(filNoSig))) {
			leerPalabrasNoSignificativas(sc, sep);
		}
	}

	private void leerPalabrasNoSignificativas(Scanner sc, String sep) {
		while (sc.hasNextLine()) {
			try (Scanner scl = new Scanner(sc.nextLine())) {
				scl.useDelimiter(sep);
				while (scl.hasNext()) {
					String pal = scl.next();
					anadirPalabraNoSignificativaArray(pal);
				}
			}
		}
	}

	private void anadirPalabraNoSignificativaArray(String pal) {
		if (numPalNoSig == noSignificativas.length) {
			noSignificativas = Arrays.copyOf(noSignificativas, noSignificativas.length * 2);
		}
		noSignificativas[numPalNoSig] = pal;
		numPalNoSig++;
	}

	/**
	 * El array que cuenta las palabras solo incluye palabras que sean
	 * significativas.
	 */
	protected void incluye(String pal) {
		// Como las palabras no significativas est�n almacenadas en may�sculas,
		// basta con comprobar
		// que la palabra en may�sculas no est� en el array.
		// if (Arrays.binarySearch(noSignificativas, pal.toUpperCase()) < 0)
		// super.incluye(pal);
		// Otra versi�n
		int i = 0;
		while ((i < numPalNoSig) && (!noSignificativas[i].equalsIgnoreCase(pal))) {
			i++;
		}
		if (i == numPalNoSig) {
			super.incluye(pal);
		}
	}
}
