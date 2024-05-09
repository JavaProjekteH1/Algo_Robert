package main.java.Praesenz.Task3;

import java.util.Scanner;

public class Main {

public static void main(String[] args){
    Taschenrechner t = new Taschenrechner();

    Scanner in = new Scanner(System.in);
    String z = "";
    while (true) {
        z = in.nextLine();
        if (z.equals("quit")) {
            break;
        }
        if (z.equals("clear")) {
            t.reset();
        }
        System.out.println("task '"+z+"' => "+t.analyze(z));
    }
}

}
