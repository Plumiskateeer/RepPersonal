package PracticaSemaforos.ej1;

public class Principal {
    public static void main(String[]args) throws InterruptedException {
        Dispositivo d = new Dispositivo(3);
        Sensor [] s = new Sensor[3];
        Trabajador t = new Trabajador(d);

        for(int i = 0; i<s.length; i++){
            s[i] = new Sensor(d,i);
        }
        for(int i = 0; i<s.length; i++){
            s[i].start();
        }
        t.start();
        for(int i = 0; i<s.length; i++){
            s[i].join();
        }
        t.join();

    }
}
