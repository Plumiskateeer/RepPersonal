
package mayor;

import java.util.Scanner;


public class Main
{
 public static void main(String[] args)  {

     Scanner sc= new Scanner(System.in);
     int pass;
do {
     System.out.print("INTRODUZCA CONTRASEÑA (1234): ");
     pass = sc.nextInt();


     if (pass == 1234)
     {
       System.out.println("PROGRAMA PARA PROBAR CONDICIONES");
       System.out.println("--------------------------------");

       System.out.print("Introduzca 1º numero: ");
       int n1 = sc.nextInt();

       System.out.print("Introduzca 2º numero: ");
       int n2 = sc.nextInt();

       System.out.print("Introduzca 3º numero: ");
       int n3 = sc.nextInt();

        if (n1 >= n2 ){
             if (n1 >= n3){
            System.out.println("\nEl primer numero es el mayor: "+n1);
        }
        if (n2 >= n1 )
        {
               if (n2 >= n3){
                    System.out.println("\nEl segundo numero es el mayor: "+n2);
                }

                if (n3 >= n2 )
                {
                      if (n3 >= n1)
                      {
                        System.out.println("\nEl tercer numero es el mayor: "+n3);
                      }
                }
            }
       }

   }

} while (pass!=1234);

     System.out.println("\nFIN DEL PROGRAMA");
     System.out.println("\nPrograma realizado por Angel Joaquin");


    }
 }




