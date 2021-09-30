package prLaboratorios;

public class PruebaPeticionAsignacion {

	public static void main(String[] args) {
		PeticionAsignacion peticion1 = new PeticionAsignacion("Juan Lopez", new FranjaHoraria("Lunes","Primera"),"POO");
		PeticionAsignacion peticion2 = new PeticionAsignacion("Maria Gomez", new FranjaHoraria("Lunes","Primera"),"FP");
		
	
		System.out.println(peticion1);
		System.out.println(peticion2);
		
		if(peticion1.equals(peticion2))
			System.out.println("Conflicto: " + peticion1.getFranja().getDia()
					+ " a " + peticion1.getFranja().getHora() + " hora.");
	
	}
}
