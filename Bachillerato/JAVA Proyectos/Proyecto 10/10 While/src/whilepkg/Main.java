
package whilepkg;




public class Main {


    public static void main(String[] args) {
 
       char p; 

        System.out.println("PRIMERA PRUEBA DE WHILE ");
        System.out.println("----------------------- ");

 
       try{ 
  
        do {

         System.out.print("Escriba x o X para finalizar: ");

         p = (char) System.in.read();

           System.in.read();
           System.in.skip(p);
           System.in.available();



        } while(p!='x');

       
         }catch(Exception e){}
     
          System.out.println("\nFIN DEL PROGRAMA");
          System.out.println("\nPrograma realizado por Angel Joaquin");

    }

}
