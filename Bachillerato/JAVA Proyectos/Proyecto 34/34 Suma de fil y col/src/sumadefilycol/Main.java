package sumadefilycol;
import java.util.*;
public class Main {
    public static final int MAX=10;
//---------------------------------------------------------------------------------
    public static void main(String[] args) {   programa();  }
//---------------------------------------------------------------------------------

    public static int [][] crearmatriz(int fil,int col)
    {
        int[][]m=new int[fil][col];
       Random rnd = new Random();
       int i,j;

       for(i=0;i<m.length;i++){
           for(j=0;j<m[0].length;j++)
           m[i][j]=rnd.nextInt(MAX);
       }
        return m;
    }
    public static int [] sumarfilas(int[][]m)
    {
       int []res= new int[m.length];
       int i,j;

      for(i=0;i<m.length;i++)
          for(j=0;j<m[0].length;j++)
          res[i]+=m[i][j];

         return res;
    }
    public static int[] sumarcolumnas(int[][]m)
    {
       int []res= new int[m[0].length];
       int i,j;

     for(i=0;i<m[0].length;i++)
        for(j=0;j<m.length;j++)
          res[i]+=m[j][i];

         return res;
    }
    public static void imprimirmatriz2D(int[][]m){
        int i,j;
        for(i=0;i<m.length;i++){
           for(j=0;j<m[0].length;j++)
              System.out.print(m[i][j]+" ");
           System.out.println();
       }
        System.out.println();
    }
    public static void imprimirmatriz1D(int[]m){
        int i,j;
        for(i=0;i<m.length;i++){
            System.out.print(m[i]+" ");
        }
    }
    public static void programa(){
     Scanner sc = new Scanner(System.in);
        int i;
        int[][]m;
        int[]fil;
        int[]col;

        System.out.print("Nº Filas de la primera matriz: ");
        int f=sc.nextInt();
        System.out.print("Nº Columnas de la primera matriz: ");
        int c=sc.nextInt();
         m=crearmatriz(f,c);
        fil=sumarfilas(m);
        col=sumarcolumnas(m);
        imprimirmatriz2D(m);

        for(i=0;i<fil.length;i++)
        System.out.println(i+1 +"º Fila: "+fil[i]);

        for(i=0;i<col.length;i++)
            System.out.println(i+1 +"º Columna: "+col[i]);
    }
    

}
