package prTutorial2;

public class Comparator implements java.util.Comparator<Punto> {

	@Override
	public int compare(Punto arg0, Punto arg1) {
		if(arg0.getX() < arg1.getX()) return -1;
		else if(arg0.getX() > arg1.getX()) return 1;
		else return 0;
	}

}
