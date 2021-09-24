package PracticaSemaforos.ej1;

import java.util.Random;

public class Trabajador extends Thread{
    private Dispositivo d;
    private Random rnd = new Random();

    public Trabajador(Dispositivo d){
        this.d = d;
    }
    public void run(){
        while(true){
            try {
                Thread.sleep(rnd.nextInt(100));
                d.realizarTarea();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
