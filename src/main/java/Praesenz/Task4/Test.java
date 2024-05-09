package main.java.Praesenz.Task4;

public class Test {
    public static void main(String[] args){
        MyDeque<Integer> list = new MyDeque<>(10);
        list.removeLast();

        System.out.println(list.toArrayList());

    }
}
