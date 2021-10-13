import java.util.Scanner;

public class Ejercicio3_CP4 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int i = 0, suma = 0, num;
        do{
            System.out.println("Introduce el numero: ");
            num = sc.nextInt();

            suma+=num;
            i++;
        }while(i<10);

        System.out.println("La suma es: " + suma);
    }
}
