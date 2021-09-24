import java.lang.reflect.Array;
import java.util.ArrayList;

public class Heuristica {
	
	private ArrayList<ArrayList<Nodo>> solucion;
	private ArrayList<Nodo> cerrados;
	private ArrayList<ArrayList<Nodo>> abiertos;
	private ArrayList<Nodo> familyIni;
	private Nodo nodoFinal;
	private Nodo nodoInicial;
	private Laberinto lab,labaux;
	private int [][] fx;
	private int [][] gx;
	private int [][] hx;
	private int padre = 0;
	private int hijo = 1;

	
	public Heuristica(Laberinto laberinto) {

		this.lab = laberinto;
		this.labaux = laberinto;
		this.nodoInicial = lab.getNodoInicio();
		this.nodoFinal = lab.getNodoFinal();
		this.solucion = new ArrayList<>();
		this.abiertos = new ArrayList<>();
		this.cerrados = new ArrayList<>();
		this.familyIni = new ArrayList<>();
		this.fx = new int [lab.getFilas()][lab.getColumnas()];
		this.gx = new int [lab.getFilas()][lab.getColumnas()];
		this.hx = new int [lab.getFilas()][lab.getColumnas()];


		//Inicializo el nodo incial, y lo añados a abiertos.
		familyIni.add(nodoInicial);
		familyIni.add(nodoInicial);
		abiertos.add(familyIni);
		
		//Tambien inicializo sus valores.
		int filaInicial = this.nodoInicial.getFila();
		int columnaInicial = this.nodoFinal.getColumna();
		gx[filaInicial][columnaInicial] = 0;
		hx[filaInicial][columnaInicial] = funcionManhattan(this.nodoInicial);
		fx[filaInicial][columnaInicial] = gx[filaInicial][columnaInicial]
				+ hx[filaInicial][columnaInicial];
		
		//Llamo a la funcion.
		System.out.println("El nodo Final es: Fila: "
				+  this.nodoFinal.getFila() + " Columna: "
				+ this.nodoFinal.getColumna());
		algoritmo(null, 0);
		completarSolucion();
		System.out.print(labaux.toString());
	}

	public void algoritmo(ArrayList<Nodo> familyAct, int k) {
		boolean terminado = false;
			//Añadimos los sucesores que podamos a la lista
			if (familyAct != null) {
				sucesores(familyAct, k);
			}
			//buscamos el menor de los abiertos si no esta vacío.
			if (!this.abiertos.isEmpty()) {
				System.out.println("-------------------------");
				ArrayList<Nodo> familyMenor = menorAbierto();
				System.out.println
						    ("Elijo: FP: " + familyMenor.get(padre).getFila()
								+ "  CP: " + familyMenor.get(padre).getColumna()
								+ "  FH: " + familyMenor.get(hijo).getFila()
								+ "  CH: " + familyMenor.get(hijo).getColumna());

				//Lo quito de la lista de abiertos, y lo pongo en la de cerrados.
				this.abiertos.remove(familyMenor);
				this.cerrados.add(familyMenor.get(padre));
				this.solucion.add(familyMenor);

				int filaCoste = familyMenor.get(padre).getFila();
				int columnaCoste = familyMenor.get(padre).getColumna();
				if (familyMenor.get(hijo).getFila() == this.nodoFinal.getFila()
						&& familyMenor.get(hijo).getColumna() == this.nodoFinal.getColumna()) {
					System.out.println("Encontre la solucion.");
				} else {
					algoritmo(familyMenor, gx[filaCoste][columnaCoste] + 1); //cambio k + 1
				}
			}
	}

	public void sucesores(ArrayList<Nodo> familyAct, int k) { // 4 posibles movimientos.
		
		int fh = familyAct.get(hijo).getFila();
		int ch = familyAct.get(hijo).getColumna();
		int fp = familyAct.get(padre).getFila();
		int cp = familyAct.get(padre).getColumna();

		//Arriba
		if(esValido(fh-1, ch)) {
			//Variable global para las familias.
			ArrayList<Nodo> familyNew = new ArrayList<>();
			//Miramos si esta en la lista de abiertos.
			int posicionAbierto = esAbierto(fh-1, ch);
			//Si devbuelve un numero mayor que el tamaño de los abiertos, es que no esta.
			if(posicionAbierto >= abiertos.size()) {
				//Padres e hijos nuevos.
				Nodo npadre = new Nodo(fh, ch);
				Nodo nhijo = new Nodo(fh-1, ch);
				//Guardamos todos los costes.
				gx[fh-1][ch] = k; //Profundidad
				hx[fh-1][ch] = funcionManhattan(nhijo); //Euristica.
				fx[fh-1][ch] = gx[fh-1][ch] + hx[fh-1][ch]; //Funcion.
				//Se crea la familia.
				familyNew.add(npadre);
				familyNew.add(nhijo);
				//Se añade a la lista de abiertos.
				abiertos.add(familyNew);
				//Se limpian las variables.

			}
			//Si es lo contrario, es que estara en abiertos.
			else {
				if(pruebaPaternidad(fp, cp, posicionAbierto)) {
					//Cogemos al padre pasado.
					Nodo padrePasado = abiertos.get(posicionAbierto).get(padre);
					int fpp = padrePasado.getFila();
					int cpp = padrePasado.getColumna();
					//Vamos comparando los padres.
					int costeActual = gx[fp][cp];
					int costePasado = gx[fpp][cpp];
					if(costeActual < costePasado) {
						System.out.println("VOY A CAMBIAR EL PADRE.");
						//Se sustituye y recalcula sus funciones, ademas del padre.
						Nodo padreNew = new Nodo(fp, cp);
						this.abiertos.get(posicionAbierto).set(padre, padreNew);
						gx[fh-1][ch] = k;
						hx[fh-1][ch] = gx[fh-1][ch] + hx[fh-1][ch];
					}
				}
			}
		}

		//Abajo
				if(esValido(fh+1, ch)) {
					//Variable global para las familias.
					ArrayList<Nodo> familyNew = new ArrayList<>();
					//Miramos si esta en la lista de abiertos.
					int posicionAbierto = esAbierto(fh+1, ch);
					//Si devbuelve un numero mayor que el tamanyo de los abiertos, es que no esta.
					if(posicionAbierto >= abiertos.size()) {
						//Padres e hijos nuevos.
						Nodo npadre = new Nodo(fh, ch);
						Nodo nhijo = new Nodo(fh+1, ch);
						//Guardamos todos los costes.
						gx[fh+1][ch] = k; //Profundidad
						hx[fh+1][ch] = funcionManhattan(nhijo); //Euristica.
						fx[fh+1][ch] = gx[fh+1][ch] + hx[fh+1][ch]; //Funcion.
						//Se crea la fammilia.
						familyNew.add(npadre);
						familyNew.add(nhijo);
						//Se añade a la lista de abiertos.
						abiertos.add(familyNew);

						//Se limpian las variables.

					}
					//Si es lo contrario, es que estara en abiertos.
					else {
						if(pruebaPaternidad(fp, cp, posicionAbierto)) {
							//Cogemos al padre pasado.
							Nodo padrePasado = abiertos.get(posicionAbierto).get(padre);
							int fpp = padrePasado.getFila();
							int cpp = padrePasado.getColumna();
							//Vamos comparando los padres.
							int costeActual = gx[fp][cp];
							int costePasado = gx[fpp][cpp];
							if(costeActual < costePasado) {
								System.out.println("VOY A CAMBIAR EL PADRE.");
								//Se sustituye y recalcula sus funciones, ademas del padre.
								Nodo padreNew = new Nodo(fp, cp);
								this.abiertos.get(posicionAbierto).set(padre, padreNew);
								gx[fh+1][ch] = k; // 	REVISAR ESTO.
								hx[fh+1][ch] = gx[fh+1][ch] + hx[fh+1][ch];
							}
						}
					}
				}

				//Izquierda
				if(esValido(fh, ch-1)) {
					//Variable global para las familias.
					ArrayList<Nodo> familyNew = new ArrayList<>();
					//Miramos si esta en la lista de abiertos.
					int posicionAbierto = esAbierto(fh, ch-1);
					//Si devbuelve un numero mayor que el tamanyo de los abiertos, es que no esta.
					if(posicionAbierto >= abiertos.size()) {
						//Padres e hijos nuevos.
						Nodo npadre = new Nodo(fh, ch);
						Nodo nhijo = new Nodo(fh, ch-1);
						//Guardamos todos los costes.
						gx[fh][ch-1] = k; //Profundidad
						hx[fh][ch-1] = funcionManhattan(nhijo); //Euristica.
						fx[fh][ch-1] = gx[fh][ch-1] + hx[fh][ch-1]; //Funcion.
						//Se crea la fammilia.
						familyNew.add(npadre);
						familyNew.add(nhijo);
						//Se añade a la lista de abiertos.
						abiertos.add(familyNew);

						//Se limpian las variables.

					}
					//Si es lo contrario, es que estara en abiertos.
					else {
						if(pruebaPaternidad(fp, cp, posicionAbierto)) {
							//Cogemos al padre pasado.
							Nodo padrePasado = abiertos.get(posicionAbierto).get(padre);
							int fpp = padrePasado.getFila();
							int cpp = padrePasado.getColumna();
							//Vamos comparando los padres.
							int costeActual = gx[fp][cp];
							int costePasado = gx[fpp][cpp];
							if(costeActual < costePasado) {
								System.out.println("VOY A CAMBIAR EL PADRE.");
								//Se sustituye y recalcula sus funciones, ademas del padre.
								Nodo padreNew = new Nodo(fp, cp);
								this.abiertos.get(posicionAbierto).set(padre, padreNew);
								gx[fh][ch-1] = k; // 	REVISAR ESTO.
								hx[fh][ch-1] = gx[fh][ch-1] + hx[fh][ch-1];
							}
						}
					}
				}

				//Derecha
				if(esValido(fh, ch+1)) {
					//Variable global para las familias.
					ArrayList<Nodo> familyNew = new ArrayList<>();
					//Miramos si esta en la lista de abiertos.
					int posicionAbierto = esAbierto(fh, ch+1);
					//Si devbuelve un numero mayor que el tamanyo de los abiertos, es que no esta.
					if(posicionAbierto >= abiertos.size()) {
						//Padres e hijos nuevos.
						Nodo npadre = new Nodo(fh, ch);
						Nodo nhijo = new Nodo(fh, ch+1);
						//Guardamos todos los costes.
						gx[fh][ch+1] = k; //Profundidad
						hx[fh][ch+1] = funcionManhattan(nhijo); //Euristica.
						fx[fh][ch+1] = gx[fh][ch+1] + hx[fh][ch+1]; //Funcion.
						//Se crea la fammilia.
						familyNew.add(npadre);
						familyNew.add(nhijo);
						//Se añade a la lista de abiertos.
						abiertos.add(familyNew);

						//Se limpian las variables.

					}
					//Si es lo contrario, es que estara en abiertos.
					else {
						if(pruebaPaternidad(fp, cp, posicionAbierto)) {
							//Cogemos al padre pasado.
							Nodo padrePasado = abiertos.get(posicionAbierto).get(padre);
							int fpp = padrePasado.getFila();
							int cpp = padrePasado.getColumna();
							//Vamos comparando los padres.
							int costeActual = gx[fp][cp];
							int costePasado = gx[fpp][cpp];
							if(costeActual < costePasado) {
								System.out.println("VOY A CAMBIAR EL PADRE.");
								//Se sustituye y recalcula sus funciones, ademas del padre.
								Nodo padreNew = new Nodo(fp, cp);
								this.abiertos.get(posicionAbierto).set(padre, padreNew);
								gx[fh][ch+1] = k; // 	REVISAR ESTO.
								hx[fh][ch+1] = gx[fh][ch+1] + hx[fh][ch+1];
							}
						}
					}
				}
	}

	
	public boolean esValido(int fila, int columna) {
		boolean exito = true;
		int maxColumnas = this.lab.getColumnas() - 1;
		int maxFilas = this.lab.getFilas() - 1;
		        if(fila < 0 || columna < 0
				|| fila > maxFilas || columna > maxColumnas
				|| this.lab.getHueco(fila, columna) == '*'
				|| esCerrado(fila, columna)) {
			exito = false;
		}
		return exito;
	}
	
	public boolean esCerrado(int fila, int columna) {
		boolean exito =  false;
		//Nodo candidato = new Nodo(fila, columna);
		int i = 0;
		
		while(i < cerrados.size() && !exito) {
			int filaCerr = cerrados.get(i).getFila();
			int columnaCerr = cerrados.get(i).getColumna();
			if(filaCerr == fila && columnaCerr == columna) {
				exito = true;
			}
			i++;
		}
		return exito;
	}
	
	public int esAbierto(int fila, int columna) {
		boolean exito = false;
		//Nodo candidato = new Nodo(fila,columna);
		int i = 0;
		while(i < abiertos.size() && !exito) {
			int filaAb = abiertos.get(i).get(hijo).getFila();
			int columnaAb = abiertos.get(i).get(hijo).getColumna();
			if(filaAb == fila && columnaAb == columna){
				exito = true; 
			}
			else {
				i++;
			}
		}
		return i;
	}
	
	public int funcionManhattan(Nodo nodo) {
		int filaFinal = this.nodoFinal.getFila();
		int columnaFinal = this.nodoFinal.getColumna();
		int filaActual = nodo.getFila();
		int columnaActual = nodo.getColumna();
		
		int resultado = Math.abs(filaActual-filaFinal)
				+ Math.abs(columnaActual-columnaFinal);
		
		return resultado;
	}

	public ArrayList<Nodo> menorAbierto(){
		//Variables
		ArrayList<Nodo> candidato = new ArrayList<>();
		int coste = Integer.MAX_VALUE;

		for(ArrayList<Nodo> nodos : this.abiertos) {
			int fila = nodos.get(hijo).getFila();
			int columna = nodos.get(hijo).getColumna();
			//Si lo encontramos, lo guardamos, tanto él como su coste.
			if(fx[fila][columna] < coste ) {
				coste = fx[fila][columna];
				candidato = nodos;
			}
		}
		return candidato;
	}
	
	public boolean pruebaPaternidad(int fp, int cp, int abierto) {
		boolean exito = false;
		int cab = this.abiertos.get(abierto).get(hijo).getColumna();
		int fab = this.abiertos.get(abierto).get(hijo).getFila();
		
		if((Math.abs(fab-fp) + Math.abs(cab-cp)) == 1) {
			exito = true;
		}
		return exito;	
	}

	public void completarSolucion(){

		boolean puerta = true;
		int filaactual = 0;
		int colactual = 0;
		int filaanterior = 0;
		int colanterior = 0;
		int i = solucion.size()-1;

		while(i>0){
			int unomenos = i-1;
			if(puerta) {
				filaactual = solucion.get(i).get(padre).getFila();
				colactual = solucion.get(i).get(padre).getColumna();
			}
			filaanterior = solucion.get(unomenos).get(hijo).getFila();
			colanterior = solucion.get(unomenos).get(hijo).getColumna();
			if( filaactual == filaanterior && colactual == colanterior){
				if (labaux.laberinto[filaactual][colactual] != 'I'
						&& labaux.laberinto[filaactual][colactual] != 'G') {
					labaux.laberinto[filaactual][colactual] = 'o';
					puerta = true;
				}
			}else if(puerta){
				puerta = false;
			}
			i--;
		};
	}
}
