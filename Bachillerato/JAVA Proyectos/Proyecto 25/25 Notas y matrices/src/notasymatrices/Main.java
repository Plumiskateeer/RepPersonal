package notasymatrices;
import java.util.Scanner;
public class Main {
//**----------------------------------------------------------------------------
    public static void notas(int []x)
    {
        Scanner sc=new Scanner(System.in);
        int n;
        do{
           System.out.print("Introduzca una nota,(-1 para terminar): ");
            n=sc.nextInt();
           if((n>-1)&&(n<10)&&(n!=-1)) x[n]++;
        }while(n!=-1);
    }
//**----------------------------------------------------------------------------
    public static void asteriscos(int x)
    {
        int i;
        for(i=1;i<=x;i++)System.out.print("* ");
        
    }
//**----------------------------------------------------------------------------
    public static void finalizar()
    {
        System.out.println("-------------------------------------");
        System.out.println("Finalizado");
        System.out.println("Programa realizado por Angel Joaquin");
        System.out.println("-------------------------------------");
    }
//**----------------------------------------------------------------------------
    public static void main(String[] args)
    {
        Scanner sc= new Scanner(System.in);
        int []m=new int[11];
        int i,j=1;
        System.out.println("PROGRAMA QUE ALMACENA NOTAS");
        System.out.println("---------------------------");
        do{
        notas(m);
        for(i=0;i<m.length;i++){
            System.out.print(i+" ");
            asteriscos(m[i]);
            System.out.println();
        }
        System.out.print("||0 PARA TERMINAR||: ");
        j=sc.nextInt();
        
       }while(j!=0);
        finalizar();
    }
}
//**----------------------------------------------------------------------------