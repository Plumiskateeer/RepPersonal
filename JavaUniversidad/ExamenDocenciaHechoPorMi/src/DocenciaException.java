
public class DocenciaException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DocenciaException(String problema) {
		throw new RuntimeException(problema);
	}
}
