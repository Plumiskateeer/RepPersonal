

package palabras;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;
//import java.util.StringTokenizer;
import java.io.*;
public class ContadorPalabras {
	/**
	 * Contiene un array redimensionable de objetos Palabra
	 */
	private PalabraEnTexto [] palabras;
	private int numPalabras;
	private static final int TAM_INICIAL = 10;
	
	/**
	 * Construye instancias de la clase con el array palabras de tama�o n
	 * @param n
	 */
	public ContadorPalabras(int n) {
		palabras = new PalabraEnTexto[n];
		numPalabras = 0;
	}
	
	/**
	 * Construye instancias de la clase con el array palabras de tama�o TAM_INICIAL
	 */
	public ContadorPalabras() {
		this(TAM_INICIAL);
	}
	
	/**
	 * Incluye una palabra en el contador.
	 * Si ya est� la palabra, incrementa el n�mero de apariciones.
	 * Si no est�, la incluye en el array. 
	 * @param pal La palabra a incluir
	 */
	protected void incluye(String pal) {
		int i = esta(pal);
		if (i == -1) {
			// Si i==-1, habra que crear una nueva palabra, y a�adirla. Puede ser necesario
			if (numPalabras == palabras.length) {
				palabras = Arrays.copyOf(palabras, palabras.length*2);
			}
			palabras[numPalabras] = new PalabraEnTexto(pal);
			numPalabras++;
		} else { 
			// Si i>=0 , el array ya contiene la palabra, y basta con incrementar las apariciones
			palabras[i].incrementa();
		}
	}
	
	/**
	 * Incluye todas las palabras que se encuentran en la cadena pals utilizando los delimitadores del
	 * @param pals	Cadena de caracteres con palabras
	 * @param del	Delimitadores para separar las palabras
	 
	public void incluyeTodas(String pals, String del) {
		StringTokenizer st = new StringTokenizer(pals, del);
		while (st.hasMoreTokens()) {
			String pal = st.nextToken();
			incluye(pal);
		}	
	}*/
	
	/**
	 * Incluye todas las palabras que se encuentran en la cadena pals utilizando los delimitadores del
	 * con Scanner
	 * @param pals	Cadena de caracteres con palabras
	 * @param del	Delimitadores para separar las palabras
	 **/
	private void incluyeTodas(String pals, String del) {
		try (Scanner stk = new Scanner(pals)) {
			stk.useDelimiter(del);
			while (stk.hasNext()) {
				String pal = stk.next();
				incluye(pal);
			}
		}
	}
		
	/**
	 * Incluye todas las palabras que se encuentran en cada cadena del array pals.
	 * Las cadenas se separan con los delimitadores del
	 * @param apals	Array de cadenas de caracteres conteniendo palabras
	 * @param del	Delimitadores para separar las palabras
	 */
	public void incluyeTodas(String [] apals, String del) {
		for (String linea : apals) {
			incluyeTodas(linea, del);
		}
	}
		
	private void leerFichero(Scanner sc, String del) throws FileNotFoundException {
		while (sc. hasNextLine()){
			String linea=sc.nextLine();
			incluyeTodas(linea, del);
			
		}
	}
	
	/**
	 * Incluye todas las palabras que se encuentran en cada cadena del fichero nomFil.
	 * Las cadenas se separan con los delimitadores del
	 * @param apals	Array de cadenas de caracteres conteniendo palabras
	 * @param del	Delimitadores para separar las palabras
	 */
	public void incluyeTodasFichero(String nomFil, String del) throws FileNotFoundException {
		try (Scanner sc=new Scanner (new File (nomFil))) {
			leerFichero(sc,del);
		}
	}
	
	/**
	 * Devuelve una palabra dada la cadena. Si no esta lanza una excepcion
	 * @param pal   La cadena
	 * @return 		La instancia de PalabraEnTexto que corresponde con pal
	 */
	public PalabraEnTexto encuentra(String pal) {
		int i = esta(pal);
		if (i == -1) {
			throw new NoSuchElementException("No existe la palabra " + pal);
		}
		return palabras[i];
	}
	
	/**
	 * M�todo auxiliar para realizar la busqueda de la cadena en el array de palabras
	 * @param pal
	 * @return	La posici�n del array ocupada por la palabra pal.
	 */
	private int esta(String pal) {
		int pos = 0;
		PalabraEnTexto pa = new PalabraEnTexto(pal);
		while ( pos < numPalabras && !palabras[pos].equals(pa) ) {
			pos++;
		}
		return pos < numPalabras ? pos : -1;
	}
	
	/**
	 * ToString utilizando StringBuilder. No saca la coma tras el �ltimo elemento
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		int i = 0;
		while (i < numPalabras) {
			sb.append(palabras[i]);
			if (i != numPalabras - 1) {
				sb.append(", ");
			}
			i++;
		}
		sb.append("]");
		return sb.toString();
	}

	public void presentaPalabras(String filSal) throws FileNotFoundException{
		try (PrintWriter pw=new PrintWriter(filSal)) {
			presentaPalabras(pw);
		}
	}
	
	public void presentaPalabras(PrintWriter pw){
		for (int i = 0; i < numPalabras; i++) {
			pw.println(palabras[i]);
		}
	}
}
