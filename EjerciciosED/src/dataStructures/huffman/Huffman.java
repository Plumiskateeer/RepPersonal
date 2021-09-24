package dataStructures.huffman;
/**
 * Huffman trees and codes.
 *
 * Data Structures, Grado en Informatica. UMA.
 *
 *
 * Student's name: ANGEL MANUEL JOAQUIN YEBENES
 * Student's group: 2ºC TARDE
 */
import dataStructures.dictionary.AVLDictionary;
import dataStructures.dictionary.Dictionary;
import dataStructures.list.ArrayList;
import dataStructures.list.LinkedList;
import dataStructures.list.List;
import dataStructures.priorityQueue.BinaryHeapPriorityQueue;
import dataStructures.priorityQueue.PriorityQueue;
import dataStructures.tuple.Tuple2;

public class Huffman {

    // Exercise 1 (0.75 puntos)
    public static Dictionary<Character, Integer> weights(String s) {
        Dictionary<Character, Integer> peso = new AVLDictionary<>();
        char[] arr = s.toCharArray();

        for (char c : arr) {
            if (peso.isDefinedAt(c)) {
                peso.insert(c, peso.valueOf(c) + 1);
            } else {
                peso.insert(c, 1);
            }
        }
        return peso;
    }

    // Exercise 2.a (0.75 puntos)
    public static PriorityQueue<WLeafTree<Character>> huffmanLeaves(String s) {
         PriorityQueue<WLeafTree<Character>> pq = new BinaryHeapPriorityQueue<>();
         Dictionary<Character, Integer> peso = weights(s);

         for (Character c : peso.keys()) {
             WLeafTree<Character> hoja = new WLeafTree<>(c, peso.valueOf(c));
             pq.enqueue(hoja);
             }

         return pq;
         }

    // Exercise 2.b (2.50 puntos)
    public static WLeafTree<Character> huffmanTree(String s) {
         WLeafTree<Character> arbol = null;
         Dictionary<Character, Integer> peso = weights(s);

         if (peso.size()<2) {
             throw new HuffmanException("ERROR: La cadena introducida debe tener al menos dos caracteres distintos!!");
             } else {
             PriorityQueue<WLeafTree<Character>> pq = huffmanLeaves(s);
             WLeafTree<Character> fst = pq.first();
             pq.dequeue();

             while (!pq.isEmpty()) {
                 WLeafTree<Character> snd = pq.first();
                 pq.dequeue();
                 WLeafTree<Character> suma = new WLeafTree<>(fst, snd);
                 pq.enqueue(suma);
                  fst = pq.first();
                  pq.dequeue();
                  }

              arbol = fst;
              }

         return arbol;
         }

    // Exercise 3.a (1 punto)
    public static Dictionary<Character, List<Integer>> joinDics(Dictionary<Character, List<Integer>> d1, Dictionary<Character, List<Integer>> d2) {
         Dictionary<Character, List<Integer>> dic = new AVLDictionary<>();

         for (Character c : d1.keys()) {
             dic.insert(c, d1.valueOf(c));
             }
         for (Character c : d2.keys()) {
             dic.insert(c, d2.valueOf(c));
             }

         return dic;
         }

         // Exercise 3.b (1 punto)
         public static Dictionary<Character, List<Integer>> prefixWith(int i, Dictionary<Character, List<Integer>> d) {
             List<Integer> lista = new ArrayList<>();

             for (Character c : d.keys()) {
                 lista = d.valueOf(c);
                 lista.insert(0, i);
             }
             return d;
         }

    // Exercise 3.c (1.50 puntos)
    public static Dictionary<Character, List<Integer>> huffmanCode(WLeafTree<Character> ht) {
         Dictionary<Character, List<Integer>> dic = new AVLDictionary<>();

         if (ht.isLeaf()) {
             List<Integer> lista = new ArrayList<>();
             dic.insert(ht.elem(), lista);
             } else {
             dic = joinDics(prefixWith(0, huffmanCode(ht.leftChild())), prefixWith(1, huffmanCode(ht.rightChild())));
             }

         return dic;
         }

         // Exercise 4 (0.50 puntos)
    public static List<Integer> encode(String s, Dictionary<Character, List<Integer>> hc) {
        List<Integer> codigo = new ArrayList<>();
        List<Integer> aux = new ArrayList<>();
        char[] arr = s.toCharArray();

        for (char c : arr) {
            if (hc.isDefinedAt(c)) {
                aux = hc.valueOf(c);

                for (Integer n : aux) {
                    codigo.append(n);
                }
            }
        }
        return codigo;
    }
    // Exercise 5 (2 puntos)
    public static String decode(List<Integer> bits, WLeafTree<Character> ht) {
         String mensaje = "";
         WLeafTree<Character> aux = ht;

         for (Integer n : bits) {
             if (n == 1) {
                 aux = aux.rightChild();
                 } else {
                 aux = aux.leftChild();
                 }

             if (aux.isLeaf()) {
                 mensaje = mensaje + aux.elem();
                 aux = ht;
                 }
             }

         return mensaje;
         }
}
