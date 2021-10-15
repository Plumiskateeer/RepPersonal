import javax.swing.*;

public class Ejercicio5_CP4 {
    public static void main(String[]args){
        int i = 0, num = 1, suma = 0;

        while(num!=0){
            num = Integer.parseInt(JOptionPane.showInputDialog("Introduce un numero para hacer la media: "));
            if(num>0){
                suma+=num;
                i++;
            }
        }
        if(i>0) System.out.println("La media es: " + suma/i);
        else System.out.println("No se han introducido numeros.");
        
    }
}
