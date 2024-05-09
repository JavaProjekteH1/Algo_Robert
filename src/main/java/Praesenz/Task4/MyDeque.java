package main.java.Praesenz.Task4;

import java.util.ArrayList;

public class MyDeque<T> {

    private Node<T> tail;
    private Node<T> head;

    public MyDeque(T start){
        head = new Node(start, null, null);
        tail = head;
    }
    public void addFirst(T elem){
        Node node = new Node(elem, null, head);
        head.prev = node;
        head = node;
    }
    public void addLast(T elem){
        Node node = new Node(elem, tail, null);
        tail.next = node;
        tail = node;
    }
    public T removeFirst(){
        T temp = head.elem;
        head.next.prev = null;
        head = head.next;
        return temp;
    }
    public T removeLast(){
        T temp = tail.elem;
        if(tail.prev != null)//Noch NullPTRException
        tail.prev.next = null;

        tail = tail.prev;
        return temp;
    }

    public ArrayList<T> toArrayList(){
        ArrayList<T> res = new ArrayList<>();

        Node<T> tmp = head;
        while(tmp != null){
            res.add(tmp.elem);
            tmp = tmp.next;
        }
        return res;
    }

    public ArrayList<T> toReverseArrayList(){
        ArrayList<T> res = new ArrayList<>();

        Node<T> tmp = tail;
        while(tmp != null){
            res.add(tmp.elem);
            tmp = tmp.prev;
        }
        return res;
    }
}
 class Node<T>{
    protected T elem;
     protected Node prev;
     protected Node next;
     public Node(T value, Node prev, Node next){
         this.elem = value;
         this.prev = prev;
         this.next = next;
     }
}