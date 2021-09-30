import prLibreria.*;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Libreria Unitec = new Libreria(10);
		Unitec.addLibro("george orwell", "1984", 8.20);		
		Unitec.addLibro("Philip K. Dick", "¿Sueñan los androides con ovejas eléctricas?", 3.50);
		Unitec.addLibro("Isaac Asimov", "Fundación e Imperio", 9.40);
		Unitec.addLibro("Ray Bradbury", "Fahrenheit 451", 7.40);
		Unitec.addLibro("Aldous Huxley", "Un Mundo Feliz", 6.50);
		Unitec.addLibro("Isaac Asimov", "La Fundación", 7.30);
		Unitec.addLibro("William Gibson", "Neuromante", 8.30);
		Unitec.addLibro("Isaac Asimov", "Segunda Fundación", 8.10);
		Unitec.addLibro("Isaac Newton", "arithmetica universalis", 7.50);
		Unitec.addLibro("George Orwell", "1984", 6.20);
		Unitec.addLibro("Isaac Newton", "Arithmetica Universalis", 10.50);
		
		System.out.println(Unitec);
		
		Unitec.remLibro("Isaac Newton", "Arithmetica Universalis");
		
		System.out.println(Unitec);
		
		System.out.println(Unitec.getPrecioBase("Isaac Asimov", "La Fundación"));
		System.out.println(Unitec.getPrecioFinal("Isaac Asimov", "La Fundación"));
		Libro.setIVA(21);
		System.out.println(Unitec.getPrecioFinal("Isaac Asimov", "La Fundación"));
	}

}
