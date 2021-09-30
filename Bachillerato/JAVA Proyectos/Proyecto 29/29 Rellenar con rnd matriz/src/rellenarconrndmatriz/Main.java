
package rellenarconrndmatriz;
import java.util.*;
import java.util.Scanner;
public class Main {
    public static int [] crearmatriz()
    {
        int[]m=new int[10];
       Random rnd = new Random();
       int i;
            for(i=0;i<m.length;i++) m[i]=rnd.nextInt(100);
       return m;
    }
    public static int nmayor(int []m){
        int i,x=0;
        for(i=0;i<m.length;i++)
            if(m[i]>x)x=m[i];
        return x;
    }
    public static int nmenor(int []m){
        int i,x=100;
        for(i=0;i<m.length;i++)
            if(m[i]<x)x=m[i];
        return x;
    }
    public static void finalizar(){
        System.out.println("--------------------------------------");
        System.out.println("PROGRAMA REALIZADO POR ANGEL JOAQUIN");
        System.out.println("Fin del programa");
        System.out.println("--------------------------------------");
    }
    public static void main(String[] args)
    {
        Scanner sc= new Scanner(System.in);
        System.out.println("PROGRAMA N 29");
        System.out.println("-------------");
        int[]m;
        int i,j;
        do{
        System.out.print("Ejercicio ||1|| Salir ||-1|| :");
        j=sc.nextInt();
        if(j!=-1){
        m=crearmatriz();
        System.out.print("Imprimir matriz aleatoria: ");
        for(i=0;i<m.length;i++)System.out.print(m[i]+" ");
        System.out.println();
        System.out.println("Numero mayor: "+nmayor(m));
        System.out.println("Numero menor: "+nmenor(m));
            }
        }while(j!=-1);
        finalizar();
    }

}
