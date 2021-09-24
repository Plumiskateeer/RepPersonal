/******************************************************************************
 * Student's name:
 * Student's group:
 * Data Structures. Grado en Informática. UMA.
******************************************************************************/

package dataStructures.vector;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SparseVector<T> implements Iterable<T> {

    protected interface Tree<T> {

        T get(int sz, int i);

        Tree<T> set(int sz, int i, T x);
    }

    // Unif Implementation

    protected static class Unif<T> implements Tree<T> {

        private T elem;

        public Unif(T e) {
            elem = e;
        }

        @Override
        public T get(int sz, int i) {
            // TODO
            return elem;
        }

        @Override
        public Tree<T> set(int sz, int i, T x) {
            // TODO
            Tree<T> node = null;
            if(elem.equals(x)){
                node  = this;
            } else if(sz == 1){
                node = new Unif<>(x);
            }else {
                int mitad = sz / 2;
                if(i < mitad){
                    node = new Node<>(set(mitad,i,x), new Unif<>(elem));
                } else{
                   //HECHO POR MI//
                    node = new Node<>(new Unif<>(elem),set(mitad,i-mitad,x));

                }
            }
            return node;
        }

        @Override
        public String toString() {
            return "Unif(" + elem + ")";
        }
    }

    // Node Implementation

    protected static class Node<T> implements Tree<T> {

        private Tree<T> left, right;

        public Node(Tree<T> l, Tree<T> r) {
            left = l;
            right = r;
        }

        @Override
        public T get(int sz, int i) {
            // TODO
            T elem;
            int mitad = sz/2;
            if(i < mitad){
                elem = left.get(mitad,i);
            }else{
                elem = right.get(mitad,i-mitad);
            }
            return elem;
        }

        @Override
        public Tree<T> set(int sz, int i, T x) {
            // TODO
            int mitad = sz / 2;
            if (i < mitad){
                left = left.set(mitad,i,x);
            }else{
                right = right.set(mitad,i-mitad,x);
            }
            simplify();
            return this;
        }

        protected Tree<T> simplify() {
            // TODO
            boolean bi = left instanceof Unif<?>;
            boolean bd = right instanceof Unif<?>;
            if (bi && bd){
                Unif<T> ni = (Unif<T>) left;
                Unif<T> nd = (Unif<T>) right;
                if (ni.elem.equals(nd.elem)){
                    return ni;
                }
            }
            return this;
        }

        @Override
        public String toString() {
            return "Node(" + left + ", " + right + ")";
        }
    }

    // SparseVector Implementation

    private int size;
    private Tree<T> root;

    public SparseVector(int n, T elem) {
        // TODO
        if(n<0){
            throw new VectorException("El tamaño introducido es negativo");
        }else {
            size = (int) Math.pow(2, n);
            root = new Unif<>(elem);
        }
    }

    public int size() { return size; }

    public T get(int i) {
        T elem;
        if (i >= 0 && i < size){
            elem = root.get(size, i);
        }else {
            throw new VectorException("El indice del elemento a buscar no es valido");
        }
        return elem;
    }

    public void set(int i, T x) {
        // TODO
        if(i >= 0 && i < size)
        root = root.set(size,i,x);
    }

    public Iterator<T> iterator() {

        return new SparseIterator();
    }
    private class SparseIterator implements Iterator<T>{

        private int current;
        public SparseIterator(){
            current=0;
        }

        @Override
        public boolean hasNext() {
            return current<size;
        }

        @Override
        public T next() {
            T res=root.get(size,current);
            current++;
            return res;
        }
    }



    @Override
    public String toString() {
        return "SparseVector(" + size + "," + root + ")";
    }
}
