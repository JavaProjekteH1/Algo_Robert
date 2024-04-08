package Praesenz.Task1;

import java.util.Iterator;

public class Chars implements Iterable<Character>{

    private String s;
    private int counter = 0;
    @Override
    public Iterator<Character> iterator() {
        return new Iterator<Character>() {
            //Position in der forEach-Schleife
            //Erste Position ist das Attribut start
            //der ausseren Klasse.

            @Override
            public boolean hasNext() {
                return  s.length() > counter;
            }

            @Override
            public Character next() {
                return s.charAt(counter++);
            }

        };
    }

    public Chars(String s){

        this.s = s;
    }
}
