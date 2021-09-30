
package hora;

import java.util.*;
public class Main {

   
    public static void main(String[] args) {

        Calendar cal;


        int hora,minuto,segundo;
        int u = -1;

      do {
            cal = new GregorianCalendar();
            hora = cal.get (cal.HOUR_OF_DAY);
            minuto= cal.get (cal.MINUTE);
            segundo= cal.get (cal.SECOND);


        
             if (u != segundo){

            System.out.println("Hora : "+hora+":"+minuto+":"+segundo);

            u = segundo ;


                        }
          }while (segundo % 10 != 0);
        

          System.out.println("\n------------------------------------");
          System.out.println("Programa realizado por Angel Joaquin");
       

        

    }}


