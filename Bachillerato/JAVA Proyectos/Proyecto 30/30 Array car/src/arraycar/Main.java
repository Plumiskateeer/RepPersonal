
package arraycar;
import java.util.Scanner;
public class Main {
    public static void finalizar(){
        System.out.println("--------------------------------------");
        System.out.println("PROGRAMA REALIZADO POR ANGEL JOAQUIN");
        System.out.println("Fin del programa");
        System.out.println("--------------------------------------");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,i,k=-1;
        char[]letras=new char[1000];
        System.out.println("PROGRAMA QUE INDICA LA LETRA CORRESPONDIENTE A CADA NUMERO");
        System.out.println("----------------------------------------------------------");

        do{
          System.out.print("Introduzca un numero (0-25)||-1 para terminar||: ");
          n= sc.nextInt();
          if((n>=0)&&(n<=25))
            letras[++k] = (char) (n+ 'A');
          else if (n!=-1)System.out.println("ERROR");

        }while(n!=-1);

        for(i=0;i<=k;i++)
            System.out.print(letras[i]+" ");

        System.out.println();
        if(k!=0)System.out.println((k+1)+" letras");
        else System.out.println("1 solisima letra");

        finalizar();
    }

}
