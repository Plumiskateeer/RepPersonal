import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Principal {

	public static void main(String[] args) {
		
		List<Punto> l = new ArrayList<>();
		Random rnd =  new Random();
		
		for(int i = 0; i<100; i++) {
			
			Punto p = new Punto(rnd.nextInt(10),rnd.nextInt(10));
			
			if(!l.contains(p)) {
				l.add(p);
				
			}
			System.out.println("Hay" + l.size() + "puntos");
			
			
			Iterator<Punto> it = l.iterator();
			
			while(it.hasNext()) {
				Punto punto =  it.next();
				System.out.println(p);
			}
			
			
			
		}

	}

}
