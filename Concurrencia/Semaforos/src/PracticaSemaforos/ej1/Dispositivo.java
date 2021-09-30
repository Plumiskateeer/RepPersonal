package PracticaSemaforos.ej1;

import java.util.concurrent.Semaphore;

public class Dispositivo {
    private int numSensores, numfijoSensores;
    private Semaphore mutex = new Semaphore(1);
    private Semaphore sensoresLeidos = new Semaphore(0);

    public Dispositivo(int n){
        numSensores = n;
        numfijoSensores = n;
    }

    public void leerSensor(int id) throws InterruptedException {
        mutex.acquire();

        System.out.println("Se ha leido el sensor " + id + ", SENSORES LEIDOS: " + (numfijoSensores-numSensores+1));
        numSensores--;
        if(numSensores == 0) sensoresLeidos.release();
        mutex.release();
    }
    public void realizarTarea() throws InterruptedException {
        sensoresLeidos.acquire();
        mutex.acquire();
        numSensores = numfijoSensores;
        System.out.println("Se ha realizado la tarea con los 3 sensores.");
        mutex.release();
    }
}
