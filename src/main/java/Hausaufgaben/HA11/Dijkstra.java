package Hausaufgaben.HA11;

import java.util.ArrayList;
import java.util.Arrays;

public class Dijkstra {
    public static void printDijkstra(int[] kanten){
        ArrayList<Integer> visitedNodes = new ArrayList<>();
        visitedNodes.add(1);

        int[][] edges = loadEdges(kanten);
        int[] shortestDistances = new int[kanten[0]+1];
        //System.out.println(Arrays.deepToString(edges));

        for(int i = 0; i < shortestDistances.length; ++i){//init
            shortestDistances[i] = Integer.MAX_VALUE/2;
        }
        int[] previousNodes = new int[kanten[0]+1];

        //Headder
        printHeadder(edges);

        printDijkstra(visitedNodes, loadEdges(kanten), shortestDistances, previousNodes, 0);
    }




    private static void printDijkstra(ArrayList<Integer> visitedNodes, int[][] edges, int[] shortestDistance, int[] previousList, int lastCosts) {
        if(visitedNodes.size() == edges.length){
            return;
        }else{
            int lastNode = visitedNodes.getLast();
            lastCosts = update(shortestDistance, previousList, edges[lastNode], visitedNodes, lastCosts);
            printDijkstra(visitedNodes, edges, shortestDistance, previousList, lastCosts);
        }

    }

    private static int update(int[] shortestDistance, int[] previousList, int[] edges, ArrayList<Integer> visitedNodes,  int lastDistance) {
        int minValue = Integer.MAX_VALUE/2;
        int minIndex = 0;
        for(int i = 2; i< shortestDistance.length; ++i){

            if(shortestDistance[i] > Math.abs(edges[i]+lastDistance) && !visitedNodes.contains(i)){
                previousList[i] = visitedNodes.getLast();
                shortestDistance[i] = edges[i]+lastDistance;
            }
            if(shortestDistance[i] <= minValue && !visitedNodes.contains(i)){
                minIndex = i;
                minValue = shortestDistance[i];
            }
        }
        printNextLine(visitedNodes.getLast(), shortestDistance, previousList);
        visitedNodes.add(minIndex);
        return minValue;
    }

    private static void printHeadder(int[][] edges) {
        StringBuilder res = new StringBuilder();
        res.append("vi\t");
        res.append("|");

        for(int i = 2; i < edges.length; ++i){
            res.append(i);
            if(i <10){
                res.append(" ");
            }
            res.append(" ");
        }
        res.append("|");
        for(int i = 2; i < edges.length; ++i){
            res.append(i);
            if(i <10){
                res.append(" ");
            }
            res.append(" ");
        }
        int length = res.length();
        res.append("\n");
        for(int i = 0; i < length; ++i){
            res.append("-");
        }

        System.out.println(res);
    }

    private static void printNextLine(Integer last, int[] shortestDistance, int[] previousList) {
        StringBuilder res = new StringBuilder();
        res.append(last + "\t");
        res.append("|");

        for(int i = 2; i < shortestDistance.length; ++i){
            res.append(((shortestDistance[i] == Integer.MAX_VALUE/2)? "__" : shortestDistance[i]));
            if(shortestDistance[i] <10){
                res.append(" ");
            }
            res.append(" ");
        }
        res.append("|");
        for(int i = 2; i < previousList.length; ++i){
            res.append((previousList[i] == 0)? "_" : previousList[i]);
            if(previousList[i] <10){
                res.append(" ");
            }
            res.append(" ");
        }

        System.out.println(res);
    }


    private static int[][] loadEdges(int[] kanten) {//x: start Node y: end Node value: costs
        int[][] res = new int[kanten[0]+1][kanten[0]+1];
        for(int i = 0; i < res.length; ++i){
            for(int j = 0; j < res[0].length; ++j){
                res[i][j] = Integer.MAX_VALUE/2;
            }
        }
        for(int i = 1; i < kanten.length; i += 3){
            res[kanten[i]][kanten[i+1]] = kanten[i+2];
        }
        return res;
    }

    public static void main(String[] args){
        printDijkstra(new int[] {4,1,2,2,1,4,5,2,4,1,2,3,4,3,1,1,4,3,1});
        printDijkstra(new int[] {10,1,2,30,1,3,10,2,5,15,2,8,55,3,4,5,3,
                9,35,4,2,10,4,5,45,4,6,10,5,3,20,5,7,15,5,9,25,6,7,5,7,10,20,8,
                10,15,9,8,10,9,10,30});


    }
}
