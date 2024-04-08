package Praesenz.Task1;

import java.util.Iterator;

public class Digit implements Iterable<Integer>{
    private int digit;
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            //Position in der forEach-Schleife
            //Erste Position ist das Attribut start
            //der ausseren Klasse.

            @Override
            public boolean hasNext() {
                return digit > 0;
            }

            @Override
            public Integer next() {
               int res = digit % 10;
               digit /= 10;
               return res;
            }

        };
    }

    public Digit(int zahl){
        this.digit = Math.abs(zahl);
    }
}
