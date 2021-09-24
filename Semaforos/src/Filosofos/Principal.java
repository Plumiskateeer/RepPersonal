package Filosofos;

public class Principal {
    public static void main(String[]args) throws InterruptedException {
        int n = 5;
        Tenedor [] t = new Tenedor[n];
        Filosofo [] f = new Filosofo[n];
        Silla s = new Silla();

        for(int i = 0; i < t.length; i++){
            t[i] = new Tenedor(i);
        }
        for(int i = 0; i < f.length; i++){
            f[i] = new Filosofo(i,t[i],t[(i+1)%n],s);
        }
        for(int i = 0; i < f.length; i++){
            f[i].start();
        }
        for(int i = 0; i < f.length; i++){
            f[i].join();
        }
    }

}
