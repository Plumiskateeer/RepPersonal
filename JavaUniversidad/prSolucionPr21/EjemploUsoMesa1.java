import prJarras.Mesa;

public class EjemploUsoMesa1 {

	public static void main(String[] args) {
		Mesa m = new Mesa(5,7);
		m.llena(1); 	System.out.println(m);
		m.llenaDesde(1);System.out.println(m);
		m.llena(1);		System.out.println(m);
		m.llenaDesde(1);System.out.println(m);
		m.vacia(2);		System.out.println(m);
		m.llenaDesde(1);System.out.println(m);
		m.llena(1);		System.out.println(m);
		m.llenaDesde(1);System.out.println(m);
	}

}
