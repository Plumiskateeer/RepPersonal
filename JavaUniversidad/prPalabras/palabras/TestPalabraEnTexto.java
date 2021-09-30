package palabras;

public class TestPalabraEnTexto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PalabraEnTexto p1 = new PalabraEnTexto("Maripuri");
		PalabraEnTexto p2 = new PalabraEnTexto("COJONES");
		
		
		p1.incrementa();
		p2.incrementa();
		
		System.out.println(p1.compareTo(p2));
		System.out.println(p2.compareTo(p1));
		
		
		

	}

}
