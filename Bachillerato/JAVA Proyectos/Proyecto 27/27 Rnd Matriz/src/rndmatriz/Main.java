package rndmatriz;
import java.util.*;
public class Main {
    public static boolean comprobar(int[]m, int n){
        int ct;
        for(ct=0;ct<m.length;ct++){
            if(m[ct]==n)return true;

        }
            return false;
    }
    public static void main(String[] args) {
        Random rnd= new Random();
        int []m=new int[6 ];
        int n,i;

        for(i=0;i<m.length;i++){
            do{
                n=rnd.nextInt(50)+1;
            }while(comprobar(m,n));
            m[i]=n;
        }
           


         System.out.println("PROGRAMA QUE IMPRIME UN NUMERO DE LA PRIMITIVA");
         System.out.println("----------------------------------------------");
         for(i=0;i<m.length;i++)System.out.print(m[i]+" ");

   }

}
