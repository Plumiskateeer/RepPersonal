import java.io.*;
import java.util.Scanner;

public class Ejercicio5 {

    static class VariableCompartida{
        private int lista[];

        public VariableCompartida(int num){
            lista = new int[num];
            lista[0] = 1;
            lista[1] = 1;
        }
        public int [] getLista(){
            return this.lista;
        }
        public void setLista(int i, int valor){
            lista[i] = valor;
        }
    }

    static class Hebfib extends Thread {

        int iesimo;
        VariableCompartida vc;

        Hebfib(int i, VariableCompartida vc) {
            iesimo = i;
            this.vc = vc;
        }

        public void run() {
            vc.setLista(iesimo, vc.getLista()[iesimo - 1] + vc.getLista()[iesimo - 2]);
        }

    }

    public static void main(String[] args) throws InterruptedException {

        int num = 0;
        System.out.print("Numero del elemento a calcular de la sucesion de fibonacci: ");
        System.out.println();
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        VariableCompartida vc = new VariableCompartida(num);

        Hebfib hebras[] = new Hebfib[num];
        for (int i = 2; i < num; i++) {
            hebras[i] = new Hebfib(i, vc);
            hebras[i].start();
            hebras[i].join();
        }
        System.out.println("Valor de fibonacci en esa posicion: ");
        System.out.println(vc.getLista()[num-1]);
        }


}
