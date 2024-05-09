package main.java.Hausaufgaben.HA6;

import java.util.ArrayList;
import java.util.Collections;

/**
 * This class represents a Heap
 *
 * @author Gruppe12
 */
public class Heap {
    private ArrayList<Integer> content = new ArrayList<>();

    /**
     * Default c-tor
     */
    public Heap(){
        content.add(null);
    }

    /**
     * Checks if the heap is empty
     * @return true if the heap is empty
     */
    public boolean isEmpty(){
        return content.size() <= 1;
    }

    /**
     * Adds an element to the heap
     * @param i element which should be added
     */
    public void add(int i){
        content.add(i);
        upheap();
    }

    /**
     * Restores order after an insert operation
     */
    private void upheap(){
        int currentIndex = content.size() -1;
        while(currentIndex / 2 > 0 && content.get(currentIndex) > content.get(currentIndex/2)){
            Collections.swap(content, currentIndex, currentIndex/2);
            currentIndex /= 2;
        }
    }

    /**
     * removes the max-element from the heap
     * @return max-element
     */
    public int getMax(){
        Collections.swap(content, 1, content.size()-1);
        int res = content.remove(content.size()-1);
        downheap();
        return res;
    }

    /**
     * Restores order after a delete operation
     */
    private void downheap() {
        downheap(1);
    }

    /**
     * Restores order after a delete operation
     */
    private void downheap(int currentIndex){
        int biggestSonIndex = -1;
        if(content.size() > currentIndex * 2){//left son
            biggestSonIndex = currentIndex * 2;
        }
        if(content.size() > currentIndex * 2 + 1 && content.get(biggestSonIndex) < content.get(currentIndex * 2 + 1)){//right son
            biggestSonIndex = currentIndex * 2 +1;
        }
        if(biggestSonIndex == -1 || content.get(currentIndex) >= content.get(biggestSonIndex)){
            return;
        }else{
            Collections.swap(content, currentIndex, biggestSonIndex);
            downheap(biggestSonIndex);
        }
    }

    /**
     * returns the String value of the heap
     * @return the heap as a String
     */
    public String toString(){
        return content.subList(1, content.size()).toString();
    }
}
