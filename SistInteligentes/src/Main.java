public class Main {

	public static void main(String[] args) {
		Laberinto lab = new Laberinto();
        System.out.print(lab.toString());
        Heuristica h = new Heuristica(lab);
	}
}
