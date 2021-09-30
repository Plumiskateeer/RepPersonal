package SemGeneral;

import java.util.concurrent.Semaphore;

public class SemGeneral {
    private Semaphore mutex = new Semaphore(1);
    private Semaphore espera;
    private int n; //valor del semaforo

    public SemGeneral(int n){
        this.n = n;
        if(n == 0) espera = new Semaphore(0);
        else espera = new Semaphore(n);
    }

    public void acquireGeneral() throws InterruptedException {
        mutex.acquire();
        n++;
        if(n==1) espera.release();
        mutex.release();
    }

    public void releaseGeneral() throws  InterruptedException{
        espera.acquire();
        mutex.acquire();
        n--;
        if(n>0)espera.release();
        mutex.release();

    }
}
