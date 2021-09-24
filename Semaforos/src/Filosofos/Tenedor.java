package Filosofos;

import java.util.concurrent.Semaphore;

public class Tenedor { // recurso
    private Semaphore mutex = new Semaphore(1);
    private int id;

    public Tenedor(int id){
        this.id = id;
    }

    public void cojoTenedor(int idFilosofo) throws InterruptedException {
        mutex.acquire();
        System.out.println("El filosofo "+ idFilosofo + " coge el tenedor " + this.id );

    }
    public void sueltoTenedor(int idFilosofo) throws InterruptedException {
        mutex.release();
        System.out.println("El filosofo "+ idFilosofo + " suelta el tenedor " + this.id );

    }
}
