package encuesta;
import java.util.*;
public class Main {
    public static int [] creardatos(){
        int []m;
        int i,y=0,k=0;
        Random rnd=new Random();
        m= new int [10];
        do{
            y=rnd.nextInt(22);
            if((y==10)||(y==11)||(y==20)||(y==21)){
            m[k++]=y;
            }
        }while(k!=10);
        
        return m;
    }
    public static int[] ordenardatos(int[]datos){
        int i;
        int []nuevosdatos;
        nuevosdatos=new int [4];
        for(i=0;i<datos.length;i++){
            if     (datos[i]==10)nuevosdatos[0]+=1;   //h q no trabajan
            else if(datos[i]==11)nuevosdatos[1]+=1;   //h q si trabajan
            else if(datos[i]==20)nuevosdatos[2]+=1;   //m q no trabajan
            else if(datos[i]==21)nuevosdatos[3]+=1;   //m q si trabajan
        }
        return nuevosdatos;
    }
    public static int[] porcentajes(int []m){
        int [] n = new int [4];

        n[0]=((m[0]+m[1])*10);
        n[1]=((m[2]+m[3])*10);
        n[2]=(m[1]*10);
        n[3]=(m[3]*10);
        return n;
    }
    public static int sueldosH(int[]m){
        int i,y=0,z;
        Random rnd= new Random();
        
        for(i=0;i<m[1];i++){  y+=rnd.nextInt(1400)+600; }
        z=y/2;
        return z;
    }
      public static int sueldosM(int[]m){
        int i,y=0,z;
        Random rnd= new Random();

        for(i=0;i<m[3];i++){  y+=rnd.nextInt(1400)+600; }
        z=y/2;
        return z;
    }
    public static void imprimir(int[]porcentajes,int sm,int sh){
        
        System.out.println("% HOMBRES: "+porcentajes[0]+"%");
        System.out.println("% MUJERES: "+porcentajes[1]+"%");
        System.out.println("% HOMBRES QUE TRABAJAN: "+porcentajes[2]+"%");
        System.out.println("% MUJERES QUE TRABAJAN: "+porcentajes[3]+"%");
        System.out.println("SUELDO PROMEDIO HOMBRES: "+sh);
        System.out.println("SUELDO PROMEDIO MUJERES: "+sm);
        System.out.println();
        System.out.println("-----------------------------------------");
        System.out.println("Fin del programa");
        System.out.println("Programa realizado por Angel Joaquin");
        System.out.println("-----------------------------------------");
    }
    public static void main(String[] args) {
        int sm,sh,i;
        int []porcentajes;
        int []datos;
        int []datos2;
        datos2=new int[4];
        datos=new int[10];
        porcentajes=new int [3];

        datos=creardatos();
        for(i=0;i<datos.length;i++)
        System.out.println(" "+datos[i]);
        datos2=ordenardatos(datos);
        porcentajes = porcentajes(datos2);
        sm = sueldosM(datos2);
        sh = sueldosH(datos2);

          imprimir(porcentajes,sm,sh);
    }

}
