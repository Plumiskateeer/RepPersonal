package matrices;
import java.util.Scanner;
public class Main {
//*--------------------------------------------------------------------------
    public static void finalizar()
{
        System.out.println("------------------------------");
        System.out.println("Finalizado");
        System.out.println("Programa realizado por Angel Joaquin");
        System.out.println("------------------------------");
}
//*--------------------------------------------------------------------------
   public static int menu()
     {
         Scanner sc= new Scanner(System.in);
         int opc;
         System.out.println("\n1: Crear matriz");
         System.out.println("2: Leer datos de matriz");
         System.out.println("3: Imprimir matriz");
         System.out.println("4: Finalizar");
         System.out.println("------------------------------");
         do{
         System.out.print("Seleccione una opción: ");
         opc=sc.nextInt();
         }while(opc<0);
         return opc;
     }
//*--------------------------------------------------------------------------
   public static void crearmatriz(int opc){
       Scanner sc=new Scanner(System.in);
       int l,i,k=0;
       String x[];
       String m[];
       x=new String [k];
       switch(opc){
   case 1:{
       do{
       System.out.print("Longitud de la matriz: ");
        l= sc.nextInt();
       }while(l<=0);
       x=new String[l];
       }break;
   case 2:{
       m=x.clone();
      for(i=1;i<=m.length;i++)
       {
         System.out.print("Introduce dato nº"+i+" =");
         m[k]=sc.next();
         k++;
       }
        }break;
   case 3:{
       m=x.clone();
       for(i=1;i<=m.length;i++){
           System.out.print(m[k]+" ");
           k++;
       }
   }break;
       }
}
//*--------------------------------------------------------------------------
   public static void main(String[] args) {
       Scanner sc= new Scanner(System.in);
       System.out.println("PROGRAMA CREADOR DE MATRICES");
       System.out.println("----------------------------");
       int a;
       do{
         a = menu();
         
        crearmatriz(a);
       }while(a!=4);
     finalizar();
   }

}
//*--------------------------------------------------------------------------