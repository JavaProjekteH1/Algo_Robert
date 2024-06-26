package Hausaufgaben.HA3;

import java.util.ArrayList;
import java.util.Collections;

/**
 * This class is used to test the functionality of the MyHashSet class.
 */

public class Test {
    public static void main(String[] args){
        MyHashSet<Integer> myHash = new MyHashSet<>();
        for (int i = 0; i < 30; i++) {
            myHash.add(i);
        }
        System.out.println(myHash.contains(5)); // true
        myHash.delete(5);
        System.out.println(myHash.contains(5)); // false
        ArrayList<Integer> el = myHash.getElements();
        System.out.println(el); // Zahlen 0..29 ausser der 5 unsortiert
        Collections.sort(el);
        System.out.println(el); // 0,1,2,3,4,6,7,....,29
    }
}
