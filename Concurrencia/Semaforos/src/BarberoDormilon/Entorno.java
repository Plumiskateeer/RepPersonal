package BarberoDormilon;

public class Entorno extends Thread{
    private Barberia b;

    public Entorno(Barberia b){
        this.b = b;
    }
    public void run(){
        while(true){
            try {
                b.nuevoCliente();
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
