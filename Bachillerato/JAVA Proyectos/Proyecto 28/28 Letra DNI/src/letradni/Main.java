package letradni;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n,i;
        String [] m ={"T","R","W","A","G","M","Y","F","P","D","X","B","N","J","Z","S","Q","V","H","L","C","K","E"};
       do{
            System.out.print("Introduce tu NIF para adivinar la letra correspondiente(0 para terminar): ");
            n= sc.nextInt();
          if(n!=0){
          for(i=0;i<m.length;i++) 
            if(n%23==i)System.out.print(m[i]);
           }
            System.out.println();
          }while(n!=0);
        System.out.println("----------------------------");
        System.out.println("Fin del programa");
        System.out.println("Realizado por Angel Joaquin");
        System.out.println("----------------------------");
    }
}
