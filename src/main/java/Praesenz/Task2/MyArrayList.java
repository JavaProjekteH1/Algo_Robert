package main.java.Praesenz.Task2;

public class MyArrayList<T>{
    private int index = 0;
    int currentSize = 10;
    T[] arr;


    public MyArrayList(){
        arr =  (T[]) new Object[currentSize];
    }

    public void add(T elem){

        if(index == currentSize){
            currentSize *= 2;
            T[] tmp =  (T[]) new Object[currentSize];
            System.arraycopy(arr, 0, tmp, 0, arr.length);
            arr = tmp;
        }
        arr[index] = elem;
        ++index;
    }

    public T auslesen(int i){
        if(i >= index || i < 0){
            throw new IndexOutOfBoundsException();
        }
        return arr[i];
    }


    public void clear(){
        arr = (T[]) new Object[10];
    }


    public void addFirst(T elem){
        if(index + 1 < currentSize){
            T[] tmp =  (T[]) new Object[currentSize];
            System.arraycopy(arr, 0, tmp, 1, arr.length);
            tmp[0] = elem;
            arr = tmp;
        }
    }



}
