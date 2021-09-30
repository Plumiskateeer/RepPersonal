
package calcularprimos;
import java.util.Scanner;
public class Main {
//* ------------------------------------------
    public static boolean esPrimo(long x)
    {
        long i;
        for(i=2;i<=(x/2);i++)
            if(x%i==0) return false;
        return true;
    }
//* ------------------------------------------
    public static void finalizar()
    {
        System.out.println("---------------------------");
        System.out.println("Fin del programa");
        System.out.println("Realizado por Angel Joaquin");
        System.out.println("---------------------------");
    }
//* ------------------------------------------
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

         long n,i;
         
       do{
         System.out.print("Introduzca un numero(0 para terminar): ");
            n=sc.nextLong();
       for(i=1;i<=n;i++) {
           esPrimo(i);
           if(esPrimo(i)==true){
           System.out.println(i);
           }
       }
      
       }while(n!=0);
         finalizar();
    }

}
//* ------------------------------------------