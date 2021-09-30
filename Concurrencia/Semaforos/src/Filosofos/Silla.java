package Filosofos;

import java.util.concurrent.Semaphore;

public class Silla {
    private int libres = 4;
    private Semaphore mutex = new Semaphore(1);
    private Semaphore hayLibres = new Semaphore(1);

    public void cojoSilla(int idFilosofo) throws InterruptedException {
        hayLibres.acquire();
        mutex.acquire();
        libres--;
        System.out.println("El filosofo " + idFilosofo + " coge una silla, quedan " + libres);
        if(libres > 0) hayLibres.release();
        mutex.release();
    }
    public void sueltoSilla(int idFilosofo) throws InterruptedException {
        mutex.acquire();
        libres++;
        System.out.println("El filosofo " + idFilosofo + " suelta una silla, quedan " + libres);
        if(libres == 1) hayLibres.release();
        mutex.release();


    }
}
