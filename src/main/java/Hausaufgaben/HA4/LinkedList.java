package main.java.Hausaufgaben.HA4;

public class LinkedList implements IList{
    Node head;
    Node tail;

    public LinkedList(int firstVal){
        Node start = new Node(firstVal, null, null);
        head = start;
        tail = head;
    }
    @Override
    public void insertAt(int index, int value){
        Node tmp = head;
        while(index-- > 0){
            if(tmp == null){
                throw new ArrayIndexOutOfBoundsException();
            }
            tmp = tmp.next;
        }
        if(tmp != null){
            tmp.elem = value;
        }
    }



    @Override
    public boolean removeAt(int index) {
        return false;
    }

    @Override
    public int getAt(int index) {
        return 0;
    }

    @Override
    public int search(int value) {
        return 0;
    }

    @Override
    public void clear() {

    }

    @Override
    public int getCount() {
        return 0;
    }
}

class Node{
    protected int elem;
    protected Node prev;
    protected Node next;
    public Node(int value, Node prev, Node next){
        this.elem = value;
        this.prev = prev;
        this.next = next;
    }
}
