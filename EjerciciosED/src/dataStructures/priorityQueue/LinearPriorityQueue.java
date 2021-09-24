/**
 *
 * Hecho por Ángel Manuel Joaquín Yébenes
 *
 **/
package dataStructures.priorityQueue;
/**
 * @param <T>
 */
public class LinearPriorityQueue <T extends Comparable<? super T>> implements PriorityQueue<T>{

    static private class Node<E> {
        E elem;
        Node<E> next;
        public Node(E x) {
            elem = x;
            next = null;
        }
    }


    private Node<T> first;
    private int size;


    /**
     * Creates an empty queue.
     */
    public LinearPriorityQueue() {
        first = null;
        size = 0;
    }

    /**
     * {@inheritDoc}
     * <p>Time complexity: O(1)
     */
    @Override
    public boolean isEmpty() { return size == 0; }

    /**
     * {@inheritDoc}
     * Position of new element in queue depends on its priority.
     * The less the value of the element, the higher its priority.
     * <p>Time complexity: O(n)
     */
    @Override
    public void enqueue(T x) {


    }

    @Override
    public T first() {
        if(isEmpty())
            throw new EmptyPriorityQueueException("first on empty priority queue");
        else
            return first.elem;
    }

    @Override
    public void dequeue() {
        if(isEmpty())
            throw new EmptyPriorityQueueException("dequeue on empty priority queue");
        else {
            first = first.next;
            size--;
        }

    }
}
