package PracticaSemaforos.ej1;

import java.util.Random;

public class Sensor extends Thread{
    private Dispositivo d;
    private int id;
    private Random rnd = new Random();

    public Sensor(Dispositivo d, int id){
        this.d = d;
        this.id = id;
    }

    public void run(){
        while(true){
            try {
                Thread.sleep(rnd.nextInt(100));
                d.leerSensor(id);
                Thread.sleep(rnd.nextInt(100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //realizar mediciones
        }
    }
}
