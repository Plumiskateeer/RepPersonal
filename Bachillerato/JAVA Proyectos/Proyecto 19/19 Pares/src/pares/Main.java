

package pares;

import java.util.Scanner;
public class Main {

   
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        int n;
        int i;
        int j;

        System.out.println("PROGRAMA PARA GENERAR PARES DE NUMEROS");
        System.out.println("--------------------------------------");
        do{
            System.out.print("Introduzca un numero positivo (0 para terminar):  ");
            n=sc.nextInt();
            for(i=1;i<=n;i++)
            {
                for (j=1;j<=n;j++)
                {
                    System.out.println("("+i+" , "+j+")");
                }
            } 

        }while(n!=0);
        System.out.println("------------------------------------");
        System.out.println("Programa realizado por Angel Joaquin");
        System.out.println("------------------------------------");

    }

}
