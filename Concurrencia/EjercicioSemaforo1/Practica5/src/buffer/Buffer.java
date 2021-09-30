package buffer;

public class Buffer {
    private final int []elem;
    private int p, c, nelem;
    private final Peterson pet;

    public Buffer(int tam){
        elem = new int[tam];
        p = 0;
        c = 0;
        nelem = 0;
        pet = new Peterson();
    }

    public void insertar(int i){
        //sincronizacion
        while(nelem == elem.length){
            pet.post0();
            System.out.println("Buffer lleno");
            Thread.yield();
            pet.pre0();
        }

        //productor f0
        pet.pre0();

        //SC0
        System.out.println("Insertar: " + i);
        elem[p] = i;
        nelem++;
        p = (p+1)%elem.length;
        pet.post0();
        //System.out.println("Insertar: " + i);
    }

    public void extraer(){
        //sincronizacion
        while(nelem == 0){
            System.out.println("Buffer vacio");
            pet.post1();
            Thread.yield();
            pet.pre1();
        }

        //consumidor f1
        pet.pre1();

        //SC1
        System.out.println("Extraer: " );
        nelem--;
        c = (c+1)%elem.length;
        pet.post1();
    }

    public int getNumElem(){
        return nelem;
    }
    public int getTamElem(){
        return elem.length;
    }

}
