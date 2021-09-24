package dataStructures.set;

import dataStructures.queue.EmptyQueueException;

import java.util.*;

public class SortedArraySet<T extends Comparable<? super T>> implements Set<T> {
    private T[] elements;
    private int size;
    private static final int TAM_DEFAULT = 10;

    public SortedArraySet() {
        elements = (T[]) new Comparable[TAM_DEFAULT];
        size = 0;
    }
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void insert(T x) {
        int pos = locate(x);
        if (pos == size || !elements[pos].equals(x)) {
            // Hay que meterlo
            ensureCapacity();
            for(int i = size; i > pos; i--) {
                elements[i] = elements[i-1];
            }
            elements[pos] = x;
            size++;
        }
    }

    private void ensureCapacity() {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length*2);
        }
    }

    // indica en qué posición está x o dónde debería estar
    private int locate(T x) {
        int pos = 0;
        while (pos < size && elements[pos].compareTo(x) < 0) {
            pos++;
        }
        return pos;
    }

    @Override
    public boolean isElem(T x) {
        int pos = locate(x);
        return pos < size && elements[pos].equals(x);
    }

    @Override
    public void delete(T x) {
       int pos = locate(x);
        if (pos < size && elements[pos].equals(x)) {
            for (int i = pos ; i < size - 1; i++) {
                elements[i] = elements[i+1];
            }
            size--;
        }
    }

    @Override
    public String toString() {
        String className = getClass().getSimpleName();
        StringJoiner sj =  new StringJoiner(",", className+"(", ")");
        for (int i = 0; i < size; i++) {
            sj.add(elements[i].toString());
        }
        return sj.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new SortedArraySetIterator();
    }

    private class SortedArraySetIterator implements Iterator<T> {
        int current = 0;

        @Override
        public boolean hasNext() {
            return current < size;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T elem = elements[current];
            current++;
            return elem;
        }
    }
}
