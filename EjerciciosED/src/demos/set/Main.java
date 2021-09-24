package demos.set;

import dataStructures.set.Set;
import dataStructures.set.SortedArraySet;

public class Main {
    public static void main(String[] args) {
        Set<String> set = new SortedArraySet<>();
        set.insert("hola");
        set.insert("como");
        set.insert("tras");
        set.insert("dado");
        System.out.println(set);
        set.delete("dado");
        System.out.println(set);

    }
}
