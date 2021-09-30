package masmatrices;
import java.util.*;
public class Main {
    public static int [] crearmatriz(int size)
    {
        int[]m=new int[size];
       Random rnd = new Random();
       int i;
       
       for(i=0;i<m.length;i++) m[i]=rnd.nextInt(299)+1;
       
       return m;
    }
    public static int[] elegir(int[]m,int nacabar){
        int i,ct=0,k=0;

        for(i=0;i<m.length;i++)
            if(m[i]%10==nacabar)ct++;

        int []end=new int[ct];
        System.out.println("Hay "+ct+" numeros que acaban en " +nacabar+":");
        for(i=0;i<m.length;i++){
            if(m[i]%10==nacabar) {
                end[k]=m[i];
                k++;
            }
        }
        return end;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,i,n2;
        int []m1;
        int []m2;
        System.out.println("PROGRAMA QUE REALIZA MATRICES FINALIZANDO EN EL NUMERO QUE DESEAS");
        System.out.println("-----------------------------------------------------------------");
        do{
        System.out.print("Tamaño de la matriz || -1 para terminar ||: ");
        n=sc.nextInt();
        if(n!=-1){
        m1=crearmatriz(n);

     
        System.out.print("Numero en el cual quieres que el resto acaben: ");
        n2=sc.nextInt();


        m2=elegir(m1,n2);

        for(i=0;i<m2.length;i++)System.out.print(m2[i]+" ");
            }
        }while(n!=-1);
        System.out.println("-------------------------");
        System.out.println("Fin del programa");
        System.out.println("Creado por Angel Joaquin");
        System.out.println("-------------------------");
}
}
