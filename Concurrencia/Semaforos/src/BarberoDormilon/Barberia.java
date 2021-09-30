package BarberoDormilon;

import java.util.concurrent.Semaphore;

public class Barberia {
    private volatile int nclientes;
    private Semaphore mutex = new Semaphore(1);
    private Semaphore espera = new Semaphore(0);

    public Barberia(){
        nclientes = 0;
    }

    public void nuevoCliente() throws InterruptedException {
        //productorEntorno
        mutex.acquire();

        //SCProd
        nclientes++;
        System.out.println("Nuevo cliente." + nclientes);

        if(nclientes==0)
            espera.release();

        mutex.release();
    }

    public void cortar() throws InterruptedException {
        //consumidorBarbero

        mutex.acquire();

        //SCProd
        nclientes--;
        if(nclientes == -1){
            System.out.println("Me he pasado");
            mutex.release();
            espera.acquire();
            mutex.acquire();
        }
        System.out.println("Corte realizado." + nclientes);

        mutex.release();
    }
}
