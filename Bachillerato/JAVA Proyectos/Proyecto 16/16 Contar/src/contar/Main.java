
package contar;
import java.util.Scanner;
public class Main {

    public static void main(String[] args)throws InterruptedException {

        Scanner sc= new Scanner(System.in);

        int a;
        int b;
        int r=0;
        int m = 50;

        System.out.println("CONTAR");
        System.out.println("--------------------");


            System.out.print("Introduzca un numero inicial: ");
             a = sc.nextInt();

            System.out.print("Introduzca un numero final: ");
             b = sc.nextInt();


        System.out.println("\n------------------------");


        if ((b-a+1) <= m  ){
        for (r=a;r<=b ;r++){

           System.out.print(r+" ") ;

           Thread.sleep(150);


            }
        }
        else System.out.println("\nSuperado el limite de numeros para contar, max 50");




        System.out.println("\n\nFIN DEL PROGRAMA");
        System.out.println("------------------");
        System.out.println("\nPrograma realizado por Angel Joaquin");










    }

}
