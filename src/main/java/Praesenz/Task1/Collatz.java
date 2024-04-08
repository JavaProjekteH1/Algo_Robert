package Praesenz.Task1;

import java.util.Iterator;

public class Collatz implements Iterable<Integer>{

    private int zahl;
    private boolean isRunning = true;
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            //Position in der forEach-Schleife
            //Erste Position ist das Attribut start
            //der ausseren Klasse.

            @Override
            public boolean hasNext() {
                return  isRunning ;
            }

            @Override
            public Integer next() {
                int res = zahl;
                if(zahl == 1 ){
                    isRunning = false;
                    return 1;
                }
                if(zahl % 2 == 0){
                    zahl /= 2;
                }else{
                    zahl = 3*zahl + 1;
                }
                return res;
            }

        };
    }

    public Collatz(int num){
        this.zahl = num;
    }
}
