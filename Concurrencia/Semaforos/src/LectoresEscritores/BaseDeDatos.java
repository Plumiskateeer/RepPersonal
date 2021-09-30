package LectoresEscritores;

import java.util.concurrent.Semaphore;

public class BaseDeDatos {
    private int nlectores = 0;
    private int nescritores = 0;
    private Semaphore mutex = new Semaphore(1);
    private Semaphore mutex2 = new Semaphore(1);
    private Semaphore mutex3 = new Semaphore(1);
    private Semaphore leyendo = new Semaphore(1);
    private Semaphore escribiendo = new Semaphore(1);

    public void entraLector(int id) throws InterruptedException {
        mutex3.acquire();
        leyendo.acquire();
        mutex.acquire();
        nlectores++;
        System.out.println("Entra Lector " + nlectores);
        if(nlectores == 1) escribiendo.acquire();
        mutex.release();
        leyendo.release();
        mutex3.release();
    }
    public void saleLector(int id) throws InterruptedException {
        mutex.acquire();
        nlectores--;
        System.out.println("Sale Lector " + nlectores);
        if(nlectores == 0) escribiendo.release();
        mutex.release();

    }
    public void entraEscritor(int id) throws InterruptedException {
        mutex2.acquire();
        nescritores++;
        System.out.println("Entra Escritor " + nescritores);
        if(nescritores == 1) leyendo.acquire();
        mutex2.release();
        escribiendo.acquire();
    }
    public void saleEscritor(int id) throws InterruptedException {
        escribiendo.release();
        mutex2.acquire();
        nescritores--;
        System.out.println("Sale Escritor " + nescritores);
        if(nescritores == 0) leyendo.release();
        mutex2.release();

    }
}
