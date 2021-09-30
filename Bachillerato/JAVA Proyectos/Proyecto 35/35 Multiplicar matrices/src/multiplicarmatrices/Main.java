
package multiplicarmatrices;
import java.util.*;
public class Main {
    public static final int MAX=10;
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
    public static int [][] multiplicar(int[][]m1,int [][]m2){
        int i,j,z;
        int [][]res;
        res=new int [m1.length][m2[0].length];
        
         for(i=0;i<m1.length;i++){
            for(j=0;j<m2[i].length;j++){
                for(z=0;z<m1[0].length;z++){
                  res[i][j]+=m1[i][z]*m2[z][j];
             }
          }
        }
         return res;
    }
    public static void imprimirmatriz(int[][]m){
        int i,j;
        for(i=0;i<m.length;i++){
           for(j=0;j<m[0].length;j++)
              System.out.print(m[i][j]+" ");
           System.out.println();
       }
    }
    public static void main(String[] args) {
     Scanner sc= new Scanner(System.in);

     int f1,c1,c2;


     int[][]matriz1;
     int[][]matriz2;
     int[][]matrizresultante;

     System.out.print("Nº Filas de la primera matriz: ");
     f1=sc.nextInt();
     System.out.print("Nº Columnas de la primera matriz: ");
     c1=sc.nextInt();
     System.out.print("Nº Filas de la segunda columna: ");
     System.out.println(c1);
     System.out.print("Nº Columnas de la segunda columna: ");
     c2=sc.nextInt();
     System.out.println("----------------------------------");
     System.out.println("DIMENSION MATRIZ RESULTADO: "+f1+"X"+c2);
     
     System.out.print("Primera matriz: \n");
     matriz1=crearmatriz(f1,c1);
     imprimirmatriz(matriz1);

     System.out.println("Segunda matriz: ");
     matriz2=crearmatriz(c1,c2);
     imprimirmatriz(matriz2);

     System.out.println("Multiplicacion: ");
     matrizresultante=multiplicar(matriz1,matriz2);
     imprimirmatriz(matrizresultante);

     System.out.println("FIN DEL PROGRAMA");
     System.out.println("REALIZADO POR ANGEL JOAQUIN");

    }

}
