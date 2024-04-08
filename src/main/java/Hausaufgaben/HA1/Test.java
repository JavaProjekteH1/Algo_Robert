package Hausaufgaben.HA1;

/**
 * Test class
 */
public class Test {
    public static void main(String[] args){
        for (XYPoint p : new Way(new XYPoint(1, 0), new XYPoint(0, 3))) {
            System.out.println(p);
        }
    }
}
