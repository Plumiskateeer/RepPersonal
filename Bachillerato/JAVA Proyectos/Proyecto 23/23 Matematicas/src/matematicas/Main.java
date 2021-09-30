package matematicas;
import java.util.Scanner;
import java.util.*;
public class Main {
//*--------------------------------------------------------------------------
     public static int menu()
     {
         Scanner sc= new Scanner(System.in);
         System.out.println("1: Factorial");
         System.out.println("2: Potencia");
         System.out.println("3: Operación propia- Numero de la suerte");
         System.out.println("4: Finalizar");
         System.out.println("------------------------------");
         System.out.print("Seleccione una opción: ");
         int opc=sc.nextInt();
         return opc;
     }
//*--------------------------------------------------------------------------
     public static long pedirnumero()
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Introduzca un numero: ");
        long n= sc.nextLong();
        return n;
    }
//*--------------------------------------------------------------------------
    public static long Factorial(long r)
    {
        if (r==0) return 1;
        else return (r * Factorial(r-1));
    }
//*--------------------------------------------------------------------------
    public static long potencia(long b,long a)
    {
        long i;
        Scanner sc= new Scanner(System.in);
        do{
        System.out.print("Escriba la base: ");
        b=sc.nextLong();
        }while(b<0);
        do{
        System.out.print("Escriba el exponente: ");
        a=sc.nextLong();
        }while(a<0);
        for(i=1;i<=a;i++)b=b*b;
        System.out.println(b);
        return b;
    }
//*--------------------------------------------------------------------------
   public static boolean comprobarprimo(long p)
   {
        long i;
         for(i=2;i<=(p/2);i++)
         if(p%i==0) return false;
        return true;
     }
//*--------------------------------------------------------------------------
    public static void calcularprimo()
    {
        Scanner sc= new Scanner(System.in);
        long n=1,aleatorio;
        boolean c;
        int fecha;
        Random rnd;
        rnd= new Random();
        do{
        System.out.print("Que dia es tu cumpleaños??: ");
        fecha=sc.nextInt();
        }while((fecha<0)||(fecha>31));
        aleatorio=rnd.nextInt();
        c=comprobarprimo(aleatorio);
        if(c==true)System.out.println("Tu numero de la suerte es: "+aleatorio*fecha);
        else System.out.println("Lo siento, no tienes numero de la suerte");
        
    }
//*--------------------------------------------------------------------------
    public static void Finalizar()
    {
        System.out.println("------------------------------");
        System.out.println("Programa realizado por Angel Joaquin");
        System.out.println("------------------------------");

    }
//*--------------------------------------------------------------------------
    public static void main(String[] args)
    {
      Scanner sc= new Scanner(System.in);
      System.out.println("PROGRAMA QUE HACE MUCHAS COSAS");
      System.out.println("------------------------------");
      int opc=1;
      long n=1,r=1,res=1,a=1,b=1;
     do{
      opc= menu();
      switch(opc){
         case 1:
         {
             n=pedirnumero();
             if(n!=0)
              Factorial(n);
              System.out.println(Factorial(n));
         }
         break;
          case 2:potencia(b,a);
          break;
          case 3:calcularprimo(); 
          break;
      }

     }while(opc!=4);
     Finalizar();
    }

}
//*--------------------------------------------------------------------------