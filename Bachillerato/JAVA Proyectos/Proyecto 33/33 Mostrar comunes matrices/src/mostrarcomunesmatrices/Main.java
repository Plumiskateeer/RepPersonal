
package mostrarcomunesmatrices;
import java.util.*;
public class Main {
    public static int [] crearmatriz()
    {
        int[]m=new int[50];
       Random rnd = new Random();
       int i;
       for(i=0;i<m.length;i++) m[i]=rnd.nextInt(49)+1;
       return m;
    }
    public static void coincidencias(int[]m1,int []m2){
        int i,j,k=0,y=0;
        
        for(i=0;i<m1.length;i++){
            for(j=0;j<m2.length;j++)
                if((k!=m1[i])&&(m1[i]==m2[j])){
                    System.out.print(" "+m1[i]);
                    k=m1[i];
                }
        }
        System.out.println();
        System.out.println("-----------------------------------------");
        System.out.println("Fin del programa");
        System.out.println("Programa realizado por Angel Joaquin");
        System.out.println("-----------------------------------------");
        
 }
    public static void eliminariguales(int[]m1){
        int i,j,k=0,y=0;

        for(i=0;i<m1.length;i++){
            for(j=0;j<m1.length;j++)
                if((k!=m1[i])&&(m1[i]!=m1[j])){
                    System.out.print(" "+m1[i]);
                    k=m1[i];
                }
        }
 }
   public static void ordenar(int[]m){
       int i,k,j;
       
       for(i=0;i<(m.length)-1;i++)
         for(j=0;j<(m.length)-1;j++)
             if(m[j]>m[j+1]){
               k=m[j];
               m[j]=m[j+1];
               m[j+1]=k;
              }
   }
   public static void main(String[] args) {
       int[]m1=new int[50];
       int[]m2=new int[50];
       
       System.out.println("PRIMERA MATRIZ: ");
       m1=crearmatriz();
       ordenar(m1);
       eliminariguales(m1);
       System.out.println("\nSEGUNDA MATRIZ: ");
       m2=crearmatriz();
       ordenar(m2);
       eliminariguales(m2);
       System.out.println("\nCOINCIDENCIAS: ");
       coincidencias(m1,m2);
      
    }

}
