package Hausaufgaben.HA3;

import java.util.ArrayList;

/**
 * A custom implementation of a HashSet data structure.
 * This class provides methods to add, delete, and check for the presence of elements in the set.
 * It uses an array of ArrayLists to store the elements, allowing for efficient element retrieval and modification.
 * The number of sublists is dynamically adjusted to maintain a balanced load factor.
 *
 * @param <K> the type of elements to be stored in the set
 */
public class MyHashSet<K> {
    private int subLists = 10;
    private int numberOfElements = 0;

    private ArrayList<K>[] content = new ArrayList[subLists];

    public MyHashSet(){
        for(int i = 0; i < subLists; ++i){
            content[i] = new ArrayList<>();
        }
    }

    /**
     * Rehashes the elements in the hash set when the number of sublists is increased.
     * This method is called internally to reorganize the elements into the new sublists.
     */
    private void rehash(){
        ArrayList<K> elements = getElements();
        subLists *= 2;
        ArrayList<K>[] tmp = new ArrayList[subLists];
        for(int i = 0; i < subLists; ++i){
            tmp[i] = new ArrayList<>();
        }
        for(K elem : elements){
            int id = calculateId(elem);
            tmp[id].add(elem);
        }
        content = tmp;
        System.out.println("sublists: " + subLists);
    }

    /**
     * Calculates the ID of the given element based on its hash code.
     * The ID is calculated by taking the absolute value of the element's hash code
     * and then performing modulo operation with the number of sublists.
     *
     * @param element the element for which to calculate the ID
     * @return the ID of the element
     */
    private int calculateId(K element){
        return Math.abs(element.hashCode() % subLists);
    }

    /**
     * Adds the specified element to this set if it is not already present.
     * If the element is already present, the set remains unchanged.
     * If the load factor exceeds the threshold, the set is rehashed and the element is added again.
     *
     * @param element the element to be added to this set
     * @return true if the element was added to the set, false if the element is already present
     */
    public boolean add(K element){
        if(contains(element)){
            return true;
        }
        if(((numberOfElements + 1) / subLists) > 2){
            rehash();
            add(element);
        }else{
            int id = calculateId(element);
            content[id].add(element);
        }
        ++numberOfElements;
        return false;
    }

    /**
     * Removes the specified element from this set if it is present.
     *
     * @param element the element to be removed from this set
     * @return true if the element was successfully removed, false otherwise
     */
    public boolean delete(K element){
        if(contains(element)){
            int id = calculateId(element);
            content[id].remove(element);
            return true;
        }
        return false;
    }

    /**
     * Checks if the specified element is present in the HashSet.
     *
     * @param element the element to be checked for presence in the HashSet
     * @return true if the element is present, false otherwise
     */
    public boolean contains(K element){
        int id = calculateId(element);
        if(content[id].contains(element)){
            return true;
        }
        return false;
    }

    /**
     * Returns an ArrayList containing all the elements in the MyHashSet.
     *
     * @return an ArrayList containing all the elements in the MyHashSet
     */
    public ArrayList<K> getElements(){
        ArrayList<K> res = new ArrayList<>();
        for(int i = 0; i < subLists; ++i){
            for(K elem : content[i]){
                res.add(elem);
            }
        }
        return res;
    }
}
