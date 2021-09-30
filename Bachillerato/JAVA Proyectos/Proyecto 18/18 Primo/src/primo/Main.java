package primo;
import java.util.Scanner;
import java.util.*;
import java.util.Calendar;
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

       System.out.println("DETERMINAR SI UN NUMERO ES PRIMO");
       System.out.println("--------------------------------");

     
       double d;
       double n;
       boolean primo;
       Calendar cal1;
       Calendar cal2;
       long tiempo;
       do{
           System.out.print("Introduzca un numero (0 para terminar): ");
           n = sc.nextDouble();
       
          primo=true;
          if(n>0){
              cal1= new GregorianCalendar();
            for (d=2;d<=(n/2);d++){
                  
                  if(n%d==0) {
                      primo = false;
                      break;
                             }
              }
              cal2= new GregorianCalendar();
              tiempo = cal2.getTimeInMillis()-cal1.getTimeInMillis();

                  if(primo){
                     System.out.println("El numero es primo");
                     System.out.println(tiempo);


                  }
                else{
                      System.out.println("El numero no es primo");
                      System.out.println(tiempo);
                      
                }
 
            
           }
         else {
            System.out.println("Numero inválido");
            

        }
             
         
       }while(n!=0);
         
              System.out.println("---------------------------------------------");
              System.out.println("Fin del programa, realizado por Angel Joaquin");
    
       }

    }
