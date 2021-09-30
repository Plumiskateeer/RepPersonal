

package cuenta;
import java.util.Scanner;
public class Main {

  
    public static void main(String[] args)throws InterruptedException {


        Scanner sc= new Scanner(System.in);

        int a;
        int b;
        int r=0;

        System.out.println("SEGUNDA PRUEBA WHILE");
        System.out.println("--------------------");
 
        do {

            System.out.print("Introduzca un PRIMER numero del 1 al 10: ");
             a = sc.nextInt();
         



        }while (a < 1 || a > 10 );

        do {

            System.out.print("Introduzca un SEGUNDO numero del 10 al 20: ");
             b = sc.nextInt();




        }while (b < 10 || b > 20 );


        System.out.println("GENERACION DE RESULTADOS");
        System.out.println("------------------------");


        do{

           r+= a;

           System.out.print(r+",") ;

           Thread.sleep(700);


        }while(r!=b);


        System.out.println("\n\nFIN DEL PROGRAMA");
        System.out.println("------------------");
        System.out.println("\nPrograma realizado por Angel Joaquin");
    }

}
