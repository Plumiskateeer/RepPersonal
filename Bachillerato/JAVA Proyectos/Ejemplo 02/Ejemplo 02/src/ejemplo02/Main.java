
package ejemplo02;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);

        System.out.print("Introduce numero del mes: ");
        int mes= sc.nextInt();

       System.out.print("Introduce año: ");
       int año= sc.nextInt();

        if (((año % 4 == 0)&&( año % 100 != 0)) || (año%400==0))
        {


        switch(mes){
                case 1: case 3: case 5: case 7: case 9: case 11:

            System.out.println("Este mes tiene 31 dias");
            System.out.println("Este año es bisiesto");
            break;

                case 4: case 6: case 8: case 10: case 12:

            System.out.println("Este mes tiene 30 dias");
            System.out.println("Este año es bisiesto");

            break;
                case 2:

             System.out.println("Este mes tiene 29 dias");
             System.out.println("Este año es bisiesto");

            break;
        }

        }
        else
        {
            switch(mes){
                case 1: case 3: case 5: case 7: case 9: case 11:

            System.out.println("Este mes tiene 31 dias");
            break;

                case 4: case 6: case 8: case 10: case 12:

            System.out.println("Este mes tiene 30 dias");

            break;
                case 2:

             System.out.println("Este mes tiene 28 dias");

            break;
        }
        }

   }

}
