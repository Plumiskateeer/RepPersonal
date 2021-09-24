package BarberoDormilon;

public class Barbero extends Thread{
    private Barberia b;

    public Barbero(Barberia b){
        this.b = b;
    }

    public void run(){
        while(true){
            try {
                 b.cortar();
                 Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
