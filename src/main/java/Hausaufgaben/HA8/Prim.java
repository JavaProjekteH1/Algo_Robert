package Hausaufgaben.HA8;

import java.sql.SQLOutput;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class Prim {
    public static int getMST(int[][] edges){

        int startNode = 1;
        int sum = 0;
        System.out.println("Waehle "+ startNode + " als Startknoten");

        ArrayList<Integer> visitedNodes = new ArrayList<>();
        ArrayDeque<Integer> nodeHistory = new ArrayDeque<>();
        nodeHistory.add(startNode);
        while(!nodeHistory.isEmpty()){
            int current = nodeHistory.getLast();
            visitedNodes.add(current);
            int nextNode = nextNode(current, visitedNodes, edges);
            if(nextNode != 0){
                System.out.println("Kante hinzugefuegt von " + current+ " zu "+ nextNode);
                sum += edges[current-1][nextNode-1];
                nodeHistory.add(nextNode);
            }else{
                nodeHistory.removeLast();
            }
        }
        return sum;
    }

    private static int nextNode(int currentNode, ArrayList<Integer> visitedNodes, int[][] edges) {
        int cheapestEdge = Integer.MAX_VALUE;
        int nextNode = 0;
        for(int i = 0; i < edges[0].length; ++i){
            if(edges[currentNode-1][i] != 0 && edges[currentNode-1][i] < cheapestEdge && !visitedNodes.contains(i+1)){
                cheapestEdge = edges[currentNode-1][i];
                nextNode = i+1;
            }
        }
        return (cheapestEdge < Integer.MAX_VALUE)? nextNode : 0;
    }

    public static void main(String[] args){
        int[][] adjazenzmatrix = {  { 0, 3, 0, 2, 0, 0 },
                                    { 3, 0, 2, 0, 3, 0 },
                                    { 0, 2, 0, 1, 6, 0 },
                                    { 2, 0, 1, 0, 0, 0 },
                                    { 0, 3, 6, 0, 0, 5 },
                                    { 0, 0, 0, 0, 5, 0 } };

        int[][] adjazenzmatrix2 = {  { 0, 5, 4, 0, 0, 0 },
                { 5, 0, 0, 1, 2, 0 },
                { 4, 0, 0, 3, 3, 0 },
                { 0, 1, 3, 0, 0, 3 },
                { 0, 2, 3, 0, 0, 2 },
                { 0, 0, 0, 3, 2, 0 } };
        System.out.println("resultierende kosten: " + getMST(adjazenzmatrix2));
    }
}
