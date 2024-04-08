package Praesenz.Task1;

import java.util.Iterator;

public class Range implements Iterable<Integer> {
	
	private int start;
	private int stop;
	
	public Range(int start, int stop) {
		this.start = start;
		this.stop = stop;
	}

	@Override
	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {
			//Position in der forEach-Schleife
			//Erste Position ist das Attribut start
			//der ausseren Klasse.
			private int pos = start;

			@Override
			public boolean hasNext() {
				return pos<stop;
			}

			@Override
			public Integer next() {
				int ret = pos;
				pos = pos + 1;  //Geht eine Position weiter
				return ret;
			}
	
		};
	}

	public static void main(String[] args) {
	// gibt die Zahlen 0, 1, 2, 3, 4 aus
		for (char i: new Chars("Hallo")) {
			System.out.println(i);
		}
	}




}
