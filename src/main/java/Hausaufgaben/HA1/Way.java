package Hausaufgaben.HA1;

import java.util.Iterator;

/**
 * Objects from this class can be used in a foreach loop to print all points between a start and end point
 *
 * @author Gruppe12
 */
public class Way implements Iterable<XYPoint>{
    XYPoint start;
    XYPoint end;
    boolean isIdentiecal = false;

    /**
     * Constructor which sets the start and end
     * @param start starting point
     * @param stop  ending point
     */
    public Way(XYPoint start, XYPoint stop){
        this.start = start;
        this.end = stop;
    }

    /**
     * @return Returns an iterator of type XYPoint
     */
    @Override
    public Iterator<XYPoint> iterator() {//einen seitenschreitt

        return new Iterator<XYPoint>() {
            //Position in der forEach-Schleife
            //Erste Position ist das Attribut start
            //der ausseren Klasse.

            /**
             * Checks if there are some more points between start and end
             * @return true if start and stop are not identical
             */
            @Override
            public boolean hasNext() {
                return !isIdentiecal;
            }

            /**
             * Calculates the next point between the current position and the end point
             * @return the next XYPoint between the current position and the end
             */
            @Override
            public XYPoint next() {
                XYPoint res = start;
                if (start.equals(end)) {
                    isIdentiecal = true;
                }
                if(start.x() < end.x()){
                    start = new XYPoint(start.x() +1, start.y());
                }else if(start.x() > end.x()){
                    start = new XYPoint(start.x()-1, start.y());
                }
                if(start.y() < end.y()){
                    start = new XYPoint(start.x(), start.y()+1);
                }else if(start.y() > end.y()){
                    start = new XYPoint(start.x() , start.y()-1);
                }
                return res;
            }

        };
    }




}
