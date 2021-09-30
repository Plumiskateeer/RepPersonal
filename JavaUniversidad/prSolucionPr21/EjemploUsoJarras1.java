import prJarras.Jarra;

public class EjemploUsoJarras1 {

	public static void main(String[] args) {
		Jarra jarraA = new Jarra(7);
		Jarra jarraB = new Jarra(4);
		jarraA.llena();
		System.out.println("Jarra A: " + jarraA + "\t Jarra B: " + jarraB);
		jarraB.llenaDesde(jarraA);
		System.out.println("Jarra A: " + jarraA + "\t Jarra B: " + jarraB);
		jarraB.vacia();
		System.out.println("Jarra A: " + jarraA + "\t Jarra B: " + jarraB);
	}

}
