package prTutorialMapa;

public class Punto implements Comparable<Punto>{
	
	private int x,y;
	
	
	public Punto() {
		this(0,0);
	}
	
	public Punto(int x, int y) {
		this.x = x;
		this.y = y;
	}
	

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public int hashCode() {
		return x+y;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Punto) {
			Punto aux = (Punto)obj;
		 return x == aux.x && y== aux.y;
			
		}
		return false;
	}
	public int getDistancia(Punto p1) {
		return Math.abs(this.x - p1.x) + Math.abs(this.y - p1.y);
	}

	@Override
	public String toString() {
		return "Punto [x=" + x + ", y=" + y + "]";
	}
	@Override
	public int compareTo(Punto p1) {
		Punto p = new Punto();
		
		int Midistancia = getDistancia(p);
		int Sudistancia = getDistancia(p1);
		
		return Midistancia - Sudistancia;
		
	
	}
	
}
