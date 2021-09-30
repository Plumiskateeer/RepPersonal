package factorial;
import java.util.Scanner;
public class Main {
//* ------------------------------------------
    public static long pedirN()
    {
        Scanner sc=new Scanner(System.in);
        long n;
        System.out.print("Introduzca un numero(0 para terminar): ");
         n= sc.nextLong();
        return n;
    }
//* ------------------------------------------
    public static long factorial(long r)
    {
       /* long i,n=1;
        for(i=pedirN(n);i>=1;i--)r = r*i;
        return r;
       */
      if (r==0)return 1;
      else return (r* factorial(r-1));
    }
//* ------------------------------------------
    public static void finalizar()
    {
        System.out.println("------------------------------------");
        System.out.println("Programa realizado por Angel Joaquin");
        System.out.println("------------------------------------");
    }
//* ------------------------------------------
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("PROGRAMA PARA CALCULAR EL FACTORIAL DE UN NUMERO");
        System.out.println("------------------------------------------------");
        long n=1;
        int s;
        do{
            n =pedirN();
            if (n!=0)
            System.out.println(factorial(n));
           
          }while(n!=0);
          finalizar();
    }
}
//* ------------------------------------------