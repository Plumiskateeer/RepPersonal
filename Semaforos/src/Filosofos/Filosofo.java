package Filosofos;

import java.util.Random;

public class Filosofo extends Thread{
    private int id;
    private Random rnd = new Random();
    private Tenedor izq, der;
    private Silla silla;

    public Filosofo(int id, Tenedor izq, Tenedor der, Silla s){
        this.id = id;
        this.izq = izq;
        this.der = der;
        this.silla = s;
    }

    public void run(){
        while(true){
            try {
                Thread.sleep(rnd.nextInt(100));
                silla.cojoSilla(id);
                izq.cojoTenedor(id);
                der.cojoTenedor(id);
                Thread.sleep(rnd.nextInt(100));
                izq.sueltoTenedor(id);
                der.sueltoTenedor(id);
                silla.sueltoSilla(id);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
