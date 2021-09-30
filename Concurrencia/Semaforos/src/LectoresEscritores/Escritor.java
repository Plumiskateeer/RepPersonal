package LectoresEscritores;

import java.util.Random;

public class Escritor extends Thread{
    private BaseDeDatos b;
    private Random rnd;
    private int id;

    public Escritor(int id, BaseDeDatos b){
        this.id = id;
        this.b = b;
        rnd = new Random();
    }
    public void run(){
        while(true){
            try {
                b.entraEscritor(id);
                Thread.sleep(rnd.nextInt(100));
                b.saleEscritor(id);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
