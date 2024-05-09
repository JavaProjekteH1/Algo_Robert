package main.java.Praesenz.Task2;

import java.util.ArrayList;
import java.util.Collections;

public class TestClass {
    public static void main(String[] args){
        ArrayList<Integer> tmp = new ArrayList<>();
        long start = System.nanoTime();
        for(int i = 0; i < 1000000; ++i){
            tmp.add(i+1);
        }
        long end = System.nanoTime();

        long res = end - start;
        System.out.println("a) " + res);

        start = System.nanoTime();
        for(int i = 0; i < 1000; ++i){
            int r =(int) Math.random()* (10000000 - 1) + 1;
            tmp.indexOf(r);
        }
        end = System.nanoTime();
        System.out.println("b) "+ (end -start));



        start = System.nanoTime();
        for(int i = 0; i < 1000; ++i){
            int r =(int) Math.random()* (10000000 - 1) + 1;
            java.util.Collections.binarySearch(tmp, r);
        }

        end = System.nanoTime();

        System.out.println("C) "+ (end - start));


        binSearch(tmp, 10);
    }

    public static int binSearch(ArrayList<Integer> list, int target){
        Collections.sort(list);
        int left = 0;
        int right = list.size()-1;
        int middle = list.size() /2;

        while(list.get(middle) != target){

            if(list.get(middle) < target){
                right = middle-1;
            }else{
                left = middle+1;
            }
            if(right < left){
                return -1;
            }
            middle = (right - left)/2 + left;
        }
        return middle;
    }



}
