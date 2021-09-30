package arraynotas;
import java.util.*;
public class Main {
//------------------------------------------------------------------------------
    public static int menu(){
        Scanner sc= new Scanner(System.in);
        int opc;
        System.out.println("---------------------");
        System.out.println("1: Añadir Notas");
        System.out.println("2: Eliminar Nota");
        System.out.println("3: Mostrar Notas");
        System.out.println("4: Nota media");
        System.out.println("5: Salir");
        System.out.println("---------------------");
        System.out.print("Introduce la opcion: ");
        opc=sc.nextInt();
        System.out.println("---------------------");
        return opc;
    }
//------------------------------------------------------------------------------
    public static void añadir(ArrayList<Integer>m){
        Scanner sc= new Scanner(System.in);
        int i;
        do{
        System.out.print("Nota que desea añadir  ||ENTRE 0-10|| : ");
        i=sc.nextInt();
        m.add(i);
        }while((i>=0)||(i<=10));
    }
//------------------------------------------------------------------------------
    public static void eliminar(ArrayList<Integer>m){
        Scanner sc= new Scanner(System.in);
        int opc,i;
        System.out.print("Nota que desea eliminar: ");
        i=sc.nextInt();
        System.out.print("Desea eliminar un solo "+i+"? ->1 "+"Todos los "+i+"->2 ");
        opc=sc.nextInt();
        if(opc==1) m.remove(new Integer(i));
        else {while(m.contains(i)==true){    m.remove(new Integer(i));}  }
        }
//------------------------------------------------------------------------------
    public static void mostrarnotas(ArrayList<Integer>m){
        int i;
        for(i=0;i<m.size();i++)System.out.println("Nota "+i+"= "+m.get(i));
    }
//------------------------------------------------------------------------------
    public static void notamedia(ArrayList<Integer>m){
        int i;
        for(i=0;i<m.size();i++)i+=m.get(i);
        System.out.println("Nota media: "+i/m.size());
    }
//------------------------------------------------------------------------------
    public static void main(String[] args) {
        ArrayList<Integer>m= new ArrayList<Integer>();
        int opc;
        do{
        opc=menu();
        switch(opc){
            case 1: añadir(m); break;
            case 2: eliminar(m); break;
            case 3: mostrarnotas(m); break;
            case 4: notamedia(m); break;
            case 5: finalizar();break;
        }
        }while(opc!=5);
    }

    public static void finalizar(){
    System.out.println("-----------------------------");
    System.out.println("Fin del programa");
    System.out.println("Programa realizado por Angel Joaquin");
    System.out.println("-----------------------------");

}
}
