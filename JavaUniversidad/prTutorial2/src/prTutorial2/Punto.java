package prTutorial2;

public class Punto implements Comparable<Punto>{

	private double x,y;
	private MiColor rojo;
	private MiColor color;
	
	
	public Punto() {
		this(0,0,MiColor.Rojo);
	}
	public Punto(int x, int y) {
		this(x,y, MiColor.Verde);
	}
	public Punto(int x, int y,MiColor color) {
		super();
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	@Override
	public int hashCode() {
		return (int)x + (int)y;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Punto) {
			Punto aux = (Punto)obj;
			return x == aux.x && y== aux.y;
		}
		return false;
		
	}

	@Override
	public String toString() {
		return "Punto [x=" + x + ", y=" + y + "]";
	}

	public double distancia(Punto p) {
		
		
		return Math.sqrt(Math.pow(x-p.x,2)+Math.pow(y-p.y, 2));
		
	}
	
	
	@Override
	public int compareTo(Punto arg) {
		Punto p = new Punto();
		
		double miDistancia = this.distancia(p);
		double suDistancia = arg.distancia(p);
		
		if(miDistancia  < suDistancia)return -1;
		else if (miDistancia > suDistancia) return 1;
		else return 0;
	
	}
	
	public void cambiarColor(MiColor nuevocolor) {
		this.color = nuevocolor;
	}
	
	
	
}
