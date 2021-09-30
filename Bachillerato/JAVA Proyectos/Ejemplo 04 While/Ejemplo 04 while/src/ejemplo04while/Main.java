
package ejemplo04while;


public class Main {


    public static void main(String[] args) {


        
        System.out.print("Escribeme algo: ");


        while (true){
          
         try {char b;
          
                    
            b = (char)System.in.read();
            if ((int)b!=32 )System.out.println("El codigo ASCII de " + b + " es " + (int)b);

           if (System.in.available()==0)
                  System.out.println("Sigue escribiendo...... ");

             
         } catch (Exception jaja){}
         
         
         
         
            
            
            
 
            
            
            
        }










    }

}
