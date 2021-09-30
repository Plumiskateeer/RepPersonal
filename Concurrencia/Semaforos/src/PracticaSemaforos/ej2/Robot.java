package PracticaSemaforos.ej2;

import java.util.Random;

public class Robot extends Thread{
    private Random rnd = new Random();
    public void run(){
        while(true){
            try {
                Thread.sleep(rnd.nextInt(100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
