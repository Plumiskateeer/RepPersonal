package listamatriz;
import java.util.Scanner;
public class Main {
//**----------------------------------------------------------------------------
    public static void finalizar()
    {
        System.out.println("-------------------------------------");
        System.out.println("Finalizado");
        System.out.println("Programa realizado por Angel Joaquin");
        System.out.println("-------------------------------------");
    }
 //**----------------------------------------------------------------------------
    public static void main(String[] args) {
     Scanner sc= new Scanner(System.in);
      System.out.println("PROGRAMA CREADOR DE LISTAS");
      System.out.println("--------------------------");
      int i,j=0;
      int []m=new int[10];

     do{ 
        for(i=0;i<=9;i++){
             System.out.print("Escriba un numero de su lista,10 max: ");
             j=sc.nextInt();
             m[i]=j;
        }

        System.out.println("NUMEROS PARES");
        for(i=0;i<m.length;i++){
             if(m[i]%2==0)System.out.print(m[i]+" ");
        }
        System.out.println("\nNUMEROS IMPARES");
        for(i=0;i<m.length;i++){
              if(m[i]%2!=0)System.out.print(m[i]+" ");
        }
        System.out.println();
        System.out.print("PARA FINALIZAR -> -1: ");
        j=sc.nextInt();
    }while(j!=-1);
      finalizar();
}
}
//**----------------------------------------------------------------------------