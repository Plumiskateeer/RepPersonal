
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

	@Override
	public String toString() {
		return "Punto [x=" + x + ", y=" + y + "]";
	}

	@Override
	public int compareTo(Punto p) {
		
		if(((this.x-p.x)+(this.y-p.y))==0) return 0;
		if(((this.x-p.x)+(this.y-p.y))>0) return 1;	
		if(((this.x-p.x)+(this.y-p.y))<0) return -1;
		return 0;	
	
	}
	
	
	
	
	
	
	
}
