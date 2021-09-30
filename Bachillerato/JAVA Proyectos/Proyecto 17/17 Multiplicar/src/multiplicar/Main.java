
package multiplicar;
import java.util.Scanner;

public class Main {

 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("GENERADOR DE TABLAS DE MULTIPLICAR");
        System.out.println("----------------------------------");

        int t = 0;
        
        do {
            
        System.out.print("Introduzca la tabla que desea generar , [-1 para terminar]: ");
        t= sc.nextInt();
        int i = 0;
        if (t!=-1){
        do{
        

            System.out.println(t+" x "+i+" = "+(t*i));
        i++;

        
        }while(i!=11);
            }
        }while(t!=-1);

        System.out.println("\n------------------------------------");
        System.out.println("Programa realizado por Angel Joaquin");

    }

}
