package prJarras;

public class Mesa {

	Jarra j1;
	Jarra j2;
	
	public Mesa(int capacidad1, int capacidad2) {
		
		j1 =  new Jarra(capacidad1);
		j2 =  new Jarra(capacidad2);
		
	}
	
	public Mesa(Jarra j1, Jarra j2) {
		this.j1 = j1;
		this.j2 = j2;
	}
	
	public int capacidad(int jarra) {
		if(jarra == 1) {
			
			return j1.capacidad();
			
			}
		else if(jarra == 2)
		{
				return j2.capacidad();
				
				}else { 
					throw new RuntimeException();
				}
		
	}
}
