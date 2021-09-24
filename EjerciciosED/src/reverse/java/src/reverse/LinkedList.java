package reverse.java.src.reverse;

import java.util.ArrayList;
import java.util.StringJoiner;

public class LinkedList<T> {

    private static class Node<E> {
        E elem;
        Node<E> next;

        Node(E elem) {
            this.elem = elem;
            this.next = null;
        }
    }

    private Node<T> first;

    // DO NOT MODIFY CODE ABOVE
    // Please, fill in your data
    //
    // Surname, Name: Joaquin Yebenes, Angel Manuel
    // Group: 2C

    public void reverse() {
        // TODO
        ArrayList<Node<T>> listanodos = new ArrayList<>();
        Node<T> aux = first;
        while(aux.next!=null) {
            listanodos.add(aux.next);
        }
        first = listanodos.get(0);
        for(Node n : listanodos){
            first.next = n;
        }

    }
    /*
    public void reverse() {
        // TODO
        Node <T> aux = first;
        while(first.next!=null){
            first = reverseRec(first.next);
        }


    }
    private Node <T> reverseRec(Node <T> node){
        Node<T> aux = node;

    }
*/
    // DO NOT MODIFY CODE BELOW

    public static LinkedList<Integer> testList() {
        LinkedList<Integer> list = new LinkedList<>();
        Node<Integer> node = new Node<>(0);
        list.first = node;
        for (int i = 1; i < 10; i++) {
            node.next = new Node<>(i);
            node = node.next;
        }
        return list;
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(",", "LinkedList(", ")");
        for (Node<T> node = first; node != null; node = node.next)
            sj.add(node.elem.toString());
        return sj.toString();
    }
}
