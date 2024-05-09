package main.java.Hausaufgaben.HA2;


import java.util.ArrayDeque;





/**
 * This class can be used to check if a string has a legitimate bracketing.
 *
 * @author Gruppe12
 */
public class Brackets {
    /**
     * This static method checks if the given string has a valid bracketing
     * @param s the string to be checked
     * @return true if the bracketing is correct
     */
    public static boolean isValid(String s) {

        char[] chars = s.toCharArray();

        char r1 = '(';
        char r2 = ')';
        char e1 = '[';
        char e2 = ']';
        char g1 = '{';
        char g2 = '}';

        char toBeClosed = ' ';

        ArrayDeque<Character> d = new ArrayDeque<>();

        for (char c : chars) {
            if (c == r1 || c == e1 || c == g1) {
                d.add(c);
            }
            else if (c == r2 || c == e2 || c == g2) {
                if (d.size() == 0) {
                    return false;
                }
                char last = d.peekLast();
                if ((last == r1 && c == r2) || (last == e1 && c == e2) || (last == g1 && c == g2)) {
                    d.removeLast();
                }
                else {
                    return false;
                }
            }
        }

        return d.size() == 0;
    }
}