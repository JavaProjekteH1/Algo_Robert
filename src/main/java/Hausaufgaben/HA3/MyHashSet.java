package main.java.Hausaufgaben.HA3;

import java.util.ArrayList;

public class MyHashSet<K> {
    private int subLists = 10;
    private int numberOfElements = 0;

    private ArrayList<K>[] content = new ArrayList[subLists];

    public MyHashSet(){
        for(int i = 0; i < subLists; ++i){
            content[i] = new ArrayList<>();
        }
    }

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

    private int calculateId(K element){
        return Math.abs(element.hashCode() % subLists);
    }
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

    public boolean delete(K element){
        if(contains(element)){
            int id = calculateId(element);
            content[id].remove(element);
            return true;
        }
        return false;
    }

    public boolean contains(K element){
        int id = calculateId(element);
        if(content[id].contains(element)){
            return true;
        }
        return false;
    }

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
