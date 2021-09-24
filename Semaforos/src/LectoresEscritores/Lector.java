package LectoresEscritores;

import java.util.Random;

public class Lector extends Thread{
    private BaseDeDatos b;
    private Random rnd;
    private int id;

    public Lector(int id, BaseDeDatos b){
        this.id = id;
        this.b = b;
        rnd = new Random();
    }
    public void run(){
        while(true){
            try {
                b.entraLector(id);
                Thread.sleep(rnd.nextInt(100));
                b.saleLector(id);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
