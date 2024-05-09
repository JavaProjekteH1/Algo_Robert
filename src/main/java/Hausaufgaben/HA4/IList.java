package main.java.Hausaufgaben.HA4;

public interface IList{
    public void insertAt(int index, int value);
    public boolean removeAt(int index);
    public int getAt(int index);
    public int search(int value);
    public void clear();
    public int getCount();
}
