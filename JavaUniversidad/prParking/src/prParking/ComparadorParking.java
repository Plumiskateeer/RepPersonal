package prParking;

import java.util.Comparator;

public class ComparadorParking implements Comparator<Parking> {

	private Vehiculo v;
	
	public ComparadorParking(Vehiculo v) {
		this.v = v;
	}
	
	
	@Override
	public int compare(Parking o1, Parking o2) {
		
		int res = 0;
		double d1 = o1.getPosicion().distancia(v.getPosActual());
		double d2 = o2.getPosicion().distancia(v.getPosActual());
		if( d1 < d2) res = -1;
		else if(d1 > d2) res = 1;
			
		return res;
		
	}

}
