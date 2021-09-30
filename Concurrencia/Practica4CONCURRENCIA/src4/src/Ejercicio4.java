import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Ejercicio4 {

    static class Nodo extends Thread{
        Nodo nl1,nl2;

        private List<Integer> lista;

        public Nodo(List<Integer>lista){
            this.lista = lista;
        }

        public List<Integer> getLista(){
            return lista;
        }
        private void añade(List<Integer> l, int desde, int hasta){
            for(int i = desde; i < hasta; i++){
                    l.add(lista.get(i));
            }
        }

        private void mezcla(List<Integer> l1, List<Integer> l2){
                while(l1.size() > 0 && l2.size() > 0){
                    if(l1.get(0) < l2.get(0)){
                        lista.add(l1.get(0));
                        l1.remove(0);
                    }else{
                        lista.add(l2.get(0));
                        l2.remove(0);
                    }
                }
                lista.addAll(l1);
                lista.addAll(l2);
        }

        public void run(){
            if(lista.size() > 1) {
                List<Integer>l1 = new ArrayList<Integer>();
                List<Integer>l2 = new ArrayList<Integer>();
                añade(l1, 0, lista.size()/2);
                añade(l2, lista.size()/2, lista.size());
                nl1 = new Nodo(l1);
                nl2 = new Nodo(l2);

                nl1.start();

                nl2.start();
                try {
                    nl1.join();
                    nl2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lista.clear();
                mezcla(l1,l2);
            }
        }
    }
    public static void main(String[]args) throws InterruptedException {
        List<Integer> l = new ArrayList<>();
        Random rnd = new Random();

        for(int i = 0; i < 20; i++)
            l.add(rnd.nextInt(100));

        System.out.println(l);

        Nodo raiz = new Nodo(l);

        raiz.start();
        raiz.join();

        System.out.print(raiz.getLista());
    }
}
