
package ejemplofor;

import java.util.Scanner;
public class Main {


    public static void main(String[] args) {
    Scanner sc =  new Scanner(System.in);

       System.out.println("Ejemplo for para imprimir desde a hasta b");
       System.out.println("-----------------------------------------");

      int ct;
      System.out.print("Introduce numero menor: ");
      int a = sc.nextInt();
      System.out.print("Introduce numero mayor limite: ");
      int b = sc.nextInt();


      if (a<=b){

       for (ct=a;ct<=b;ct++){

           System.out.print(ct+" ,");

       }

        }
        else if (a>=b) {
          for (ct=a;ct>=b;ct--){

           System.out.print(ct+" ,");

       }

 }

       System.out.println("\nPrograma realizado por Angel Joaquín");
       


    }

}
