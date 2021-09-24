package dataStructures.binPacket; /**
 * Student's name: Angel Manuel Joaquin Yebenes
 *
 * Student's group: 2C
 */

import dataStructures.list.ArrayList;
import dataStructures.list.List;
import dataStructures.list.LinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

class Bin {
    private int remainingCapacity; // capacity left for this bin
    private List<Integer> weights; // weights of objects included in this bin

    public Bin(int initialCapacity) {
        // todo
        remainingCapacity = initialCapacity;
        weights = new LinkedList<>();
    }

    // returns capacity left for this bin
    public int remainingCapacity() {
        // todo
        return this.remainingCapacity;
    }

    // adds a new object to this bin
    public void addObject(int weight) {
        // todo
        if(weight > this.remainingCapacity)
            throw new RuntimeException("No cabe");
        weights.append(weight);
        this.remainingCapacity -= weight;

    }

    // returns an iterable through weights of objects included in this bin
    public Iterable<Integer> objects() {
        // todo
        //  SOLO PARA ALUMNOS SIN EVALUACION CONTINUA
        //  ONLY FOR STUDENTS WITHOUT CONTINUOUS ASSESSMENT
        return null;
    }

    public String toString() {
        String className = getClass().getSimpleName();
        StringBuilder sb = new StringBuilder(className);
        sb.append("(");
        sb.append(remainingCapacity);
        sb.append(", ");
        sb.append(weights.toString());
        sb.append(")");
        return sb.toString();
    }
}

// Class for representing an AVL tree of bins
public class AVL {
    static private class Node {
        Bin bin; // Bin stored in this node
        int height; // height of this node in AVL tree
        int maxRemainingCapacity; // max capacity left among all bins in tree rooted at this node
        Node left, right; // left and right children of this node in AVL tree

        // recomputes height of this node
        void setHeight() {
            // todo
            height = 1 + Math.max(height(this.left), height(this.right));
        }

        // recomputes max capacity among bins in tree rooted at this node
        void setMaxRemainingCapacity() {
            // todo
            if(this.left == null || this.right == null)
                throw new RuntimeException("Hijos nulos");

            this.maxRemainingCapacity = Math.max(this.bin.remainingCapacity(), Math.max(maxRemainingCapacity(left), maxRemainingCapacity(right)));
        }

        // left-rotates this node. Returns root of resulting rotated tree
        Node rotateLeft() {
            // todo
            if(this.right == null){
                return this;
            }else{
                Node oldRight = this.right;
                Node aux = this;
                aux.right = oldRight.left;

                this.right = oldRight.right;
                this.bin = oldRight.bin;
                this.left = aux;

                this.setHeight();
                this.setMaxRemainingCapacity();
            }

            return this;
        }
    }

    private static int height(Node node) {
        // todo
        if(node == null){
            return 0;
        }else{
            return node.height;
        }
    }

    private static int maxRemainingCapacity(Node node) {
        // todo
        if(node == null){
            return 0;
        }else{
            return node.maxRemainingCapacity;
        }
    }

    private Node root; // root of AVL tree

    public AVL() {
        this.root = null;
    }

    // adds a new bin at the end of right spine.
    private void addNewBin(Bin bin) {
        // todo
        root = addNewBinRec(root, bin);
    }

    private Node addNewBinRec(Node node, Bin bin) {
        if(node == null){
            node = new Node();
            node.bin = bin;
            node.setHeight();
        }else{
            node.right = addNewBinRec(node.right, bin);
            node.setHeight();
            if(height(node.right) > height(node.left)+1){
                node = node.rotateLeft();
            }

        }
        return node;
    }

    // adds an object to first suitable bin. Adds
    // a new bin if object cannot be inserted in any existing bin
    public void addFirst(int initialCapacity, int weight) {
        // todo
        if(root == null || root.left == null || root.right == null || weight > root.maxRemainingCapacity){
            Bin b = new Bin(initialCapacity);
            b.addObject(weight);
            this.addNewBin(b);
        }else if(maxRemainingCapacity(root.left) >= weight){
            root.left = addFirstRec(root.left, initialCapacity, weight);
        }else if(root.bin.remainingCapacity() >= weight){
            root.bin.addObject(weight);
        }/*else{
            root = addFirstRec(root.right, initialCapacity, weight);
        }*/
    }

    private Node addFirstRec(Node node, int initialCapacity, int weight) {

        if(node != null && node.left.bin.remainingCapacity() < weight){
            node = addFirstRec(node.left, initialCapacity, weight);
        }else{
            node = new Node();
            node.bin = new Bin(initialCapacity);
            node.bin.addObject(weight);
        }
        return node;
    }

    public void addAll(int initialCapacity, int[] weights) {
        // todo
        for(int w : weights){
            addFirst(initialCapacity, w);
        }
    }

    public List<Bin> toList() {
        // todo
        List<Bin> l = new LinkedList<>();
        toListRec(root, l);
        return l;
    }

    private void toListRec(Node node, List<Bin> l) {
        if(node == null){
            throw new RuntimeException("Nodo null");
        }
        if(node.left != null){
            l.append(node.left.bin);
        }
        l.append(node.bin);
        if(node.right != null){
            l.append(node.right.bin);
        }
    }

    public String toString() {
        String className = getClass().getSimpleName();
        StringBuilder sb = new StringBuilder(className);
        sb.append("(");
        stringBuild(sb, root);
        sb.append(")");
        return sb.toString();
    }

    private static void stringBuild(StringBuilder sb, Node node) {
        if(node==null)
            sb.append("null");
        else {
            sb.append(node.getClass().getSimpleName());
            sb.append("(");
            sb.append(node.bin);
            sb.append(", ");
            sb.append(node.height);
            sb.append(", ");
            sb.append(node.maxRemainingCapacity);
            sb.append(", ");
            stringBuild(sb, node.left);
            sb.append(", ");
            stringBuild(sb, node.right);
            sb.append(")");
        }
    }
}

class LinearBinPacking {
    public static List<Bin> linearBinPacking(int initialCapacity, List<Integer> weights) {
        // todo
        //  SOLO PARA ALUMNOS SIN EVALUACION CONTINUA
        //  ONLY FOR STUDENTS WITHOUT CONTINUOUS ASSESSMENT
        return null;
    }

    public static Iterable<Integer> allWeights(Iterable<Bin> bins) {
        // todo
        //  SOLO PARA ALUMNOS SIN EVALUACION CONTINUA
        //  ONLY FOR STUDENTS WITHOUT CONTINUOUS ASSESSMENT
        return null;
    }
}