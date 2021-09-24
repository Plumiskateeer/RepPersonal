import java.util.Random;

public class Laberinto {
    char[][] laberinto;
    int filas = 0, columnas = 0, prob;
    Random rnd;
    Nodo nodoInicio;
    Nodo nodoFinal;

    public Laberinto(){
        filas = 60;
        columnas = 80;
        laberinto = new char[filas][columnas];
        prob = 30;
        rnd = new Random();
        inicializarLaberinto();
        Inicio();
        Final();
    }
    public Laberinto(int fil, int col, int probabilidad){
        filas = fil;
        columnas = col;
        laberinto = new char[filas][columnas];
        prob = probabilidad;
        rnd = new Random();
        inicializarLaberinto();
        Inicio();
        Final();
    }

    public void inicializarLaberinto() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (rnd.nextInt(100) < prob) {
                    laberinto[i][j] = '*';
                } else {
                    laberinto[i][j] = ' ';
                }
            }
        }
    }

        public String toString() {
        StringBuilder st = new StringBuilder();
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                st.append(laberinto[i][j]);
                st.append(' ');
            }
            st.append("\n");
        }
        return st.toString();
    }

    public void Inicio() throws RuntimeException{
        Random rndfil = new Random();
        Random rndcol = new Random();
        int fil = rndfil.nextInt(filas);
        int col = rndcol.nextInt(columnas);
        if(laberinto[fil][col] == '*'){
            throw new RuntimeException
                    ("El inicio se ha generado " +
                            "en una posicion ya ocupada");
        }else{
        	nodoInicio = new Nodo(fil,col);
            laberinto[fil][col] = 'I';
        }
    }
    public void Final()throws RuntimeException{
        Random rndfil = new Random();
        Random rndcol = new Random();
        int fil = rndfil.nextInt(filas);
        int col = rndcol.nextInt(columnas);
        if(laberinto[fil][col] == '*'){
            throw new RuntimeException
                    ("El final se ha generado " +
                            "en una posicion ya ocupada");
        }else{
        	this.nodoFinal = new Nodo(fil,col);
            laberinto[fil][col] = 'G';
        }
    }
    
    public char getHueco(int fila, int columna) {
    	return laberinto[fila][columna];
    }

    public int getFilas() {
		return filas;
	}
	
	public int getColumnas() {
		return columnas;
	}
	
	public Nodo getNodoInicio() {
		return nodoInicio;
	}
	
	public Nodo getNodoFinal() {
		return nodoFinal;
	}
	
	
}

