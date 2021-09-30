
package asteriscos;

import java.util.Scanner;
public class Main {

    
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);

       int n;
       int i;
       int j;
       int m;


       System.out.println("PROGRAMA GENERADOR DE FIGURAS CON ASTERISCOS");
       System.out.println("--------------------------------------------");

    do{

       System.out.print("Introduzca un numero entre 1 y 15 (0 para terminar): ");
       n=sc.nextInt();

       for(j=1;j<=n;j++){
           System.out.println();
       for(i=1;i<=n;i++){
           System.out.print("*");
     
       }

       }
       System.out.println();
    }while(n!=0);
       System.out.println("------------------------------------");
       System.out.println("PROGRAMA REALIZADO POR ANGEL JOAQUIN");
       System.out.println("------------------------------------");
    }

}
