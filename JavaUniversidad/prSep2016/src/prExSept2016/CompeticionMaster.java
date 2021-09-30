package prExSept2016;

import java.util.ArrayList;
import java.util.List;

public class CompeticionMaster extends Competicion{
	
	private int umbral;
	
	public CompeticionMaster(String file, int umbral ) {
		
		super(file);
		this.umbral = umbral;
		
	}
	
	
	@Override
	public void insertaJugadoresEquipo(Equipo e, List<Jugadores> l) {
		
		List<Jugador> l1 = new ArrayList<>();
		
		for(Jugador j : l) {
			if(j.getpGanados() >= umbral) l1.add(j);
		}
		
		
		super.insertaJugadoresEquipo(e, l1);
		
	}

}
