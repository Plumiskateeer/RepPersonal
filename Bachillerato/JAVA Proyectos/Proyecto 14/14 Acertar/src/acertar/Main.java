

package acertar;

import java.util.Scanner;
import java.util.*;
public class Main {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Acierta un numero al azar del 1 al numero que tu elijas");
        System.out.println("-------------------------------------------------------");

        int n;
        int n2;
        int a=1;
        System.out.print("Inserta un numero: ");
        n = sc.nextInt();

        Random rnd;

        rnd = new Random();

        int p;
        p = rnd.nextInt(n);
        p++;


        System.out.print("Intenta adivinar el numero aleatorio de 1 a "+n+": ");
        int n1=sc.nextInt();

        if (n1==p){
            System.out.println("-------------------------");
            System.out.println("Enhorabuena, has acertado");
            System.out.println("Has necesitado 1 intento, eres adivino");
            System.out.println("\nFin del programa");
            System.out.println("Programa realizado por Angel Joaquin");
        }
        else{
            if (n1 > p)System.out.println("El numero aleatorio es MENOR");
                 else System.out.println("El numero aleatorio es MAYOR");

            do{
                
                a++;
                System.out.print("Intenta adivinar el número: "+"("+ a +"ºintento)");
                 n2=sc.nextInt();
                 if (n2 == p){
                        System.out.println("-------------------------");
                        System.out.println("Enhorabuena, has acertado");
                        System.out.println("Has necesitado "+ a +" intentos");
                        System.out.println("\nFin del programa");
                        System.out.println("Programa realizado por Angel Joaquin");
                 }
                 else if (n2 > p)  System.out.println("El numero aleatorio es MENOR");
                 else System.out.println("El numero aleatorio es MAYOR");
                 


            }while(n2!=p);

           


        }

    }

}
