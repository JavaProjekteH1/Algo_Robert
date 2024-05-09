package main.java.Hausaufgaben.HA6;

/**
 * THis is a test class for the Heap class
 */
public class TestClass {


    public static void main(String[] args){
        Heap h = new Heap();

        int[] testNumbers = {1, 6, 8, 18, 23, 5, 17, 20, 26, 21, 9};

        for(int i = 0; i < testNumbers.length; ++i){
            System.out.println(h);
            h.add(testNumbers[i]);
        }
        System.out.println(h +"\n");



        while(!h.isEmpty()){
            System.out.print(h.getMax() + ": ");
            System.out.println(h);
        }


    }
}
