package prTutorialGenericidad;


public class Principal {

	public static void main(String[] args) {
		
		IPila<Integer> p = new Pila<>();
		
		try {
			p.push(3);
			p.push(5);
			p.push(2);
			
			p.ordena();
			
			System.out.println(p.pop());
			System.out.println(p.pop());
			System.out.println(p.pop());
			System.out.println(p.pop());
			
		} catch (PilaLlena e) {
			System.out.println("Pila llena");
		
		}catch(PilaVacia e){
		
			System.out.println("Pila vacia");
	}
	
		
		
	}
}
