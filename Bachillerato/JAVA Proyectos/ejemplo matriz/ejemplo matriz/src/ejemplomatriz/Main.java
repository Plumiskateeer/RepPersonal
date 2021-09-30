
package ejemplomatriz;
import java.util.Scanner;
public class Main {
    public static void resuelto(){
        Scanner sc= new Scanner(System.in);
        int [] temp = new int [7];
        String [] dias = {"Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo"};
        int i;
        double media=0;
        System.out.println("Escribe la temperatura de cada dia de la semana: ");
        for(i=0;i<temp.length;i++){
            System.out.print(dias[i]+"= ");
            temp[i]=sc.nextInt();
           
        }

        for(i=0;i<temp.length;i++){
            System.out.print(dias[i]+"="+temp[i]+"  ");
            
        }
        for(i=0;i<temp.length;i++){
            media=temp[i]+media;
            
        }
        System.out.println("\nLa temperatura media es ="+media/2);
    }
    public static void main(String[] args) {
        System.out.println("PROGRAMA QUE HACES COSAS");
        resuelto();
    }

}
