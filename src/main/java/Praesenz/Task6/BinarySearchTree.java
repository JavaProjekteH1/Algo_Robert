package main.java.Praesenz.Task6;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;

/** Ein binaerer Suchbaum mit ganzen Zahlen als Datensatz:
 * Vorlage fuer die A1 von algo-pr06 und fuer die A1 von algo-h07.
 * Als Operationen stehen `contains' und `insert' zur Verfuegung.
 */
public class BinarySearchTree {

    /** Die Knotenklasse als statische innere Klasse. */
    public static class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }

        public String toString() {
            return this.value + " ";
        }

        public int getValue() {
            return this.value;
        }

        public Node getLeft() {
            return this.left;
        }

        public Node getRight() {
            return this.right;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public void setLeft(Node node) {
            this.left = node;
        }

        public void setRight(Node node) {
            this.right= node;
        }

    }

    public String toString(){
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null){
            return "";
        }
        getString(root, res);
        return res.toString();
    }

    private void getString(Node n, ArrayList<Integer> res){

      if(n.left != null){
          getString(n.left, res);
      }
      res.add(n.value);
      if(n.right != null){
          getString(n.right, res);
      }
    }

    /** Baumwurzel */
    protected Node root;

    /**
     * Herausfinden, ob ein gewisser Datensatz schon im binaeren Suchbaum enthalten ist.
     *
     * @param   data  zu suchender Datensatz
     * @return        true: Datensatz ist vorhanden; false: Datensatz ist nicht vorhanden.
     */
    public boolean contains(int data) {
        Node temp = root;
        while(temp != null) {
            if (temp.getValue() == data) {
                return true;
            }
            if (temp.getValue() > data) {
                temp = temp.getLeft();
            } else {
                temp = temp.getRight();
            }
        }
        return false;
    }

    /**
     * Einen neuen Datensatz in den binaeren Suchbaum einfuegen.
     *
     * @param   data  einzufuegender Datensatz
     * @return        true: Datensatz wurde eingefuegt; false: Datensatz war schon vorhanden.
     */
    public boolean insert(int data) {
        if (root == null) {
            root = new Node(data);
            return true;
        }

        Node temp = root;
        while(temp.getValue() != data) {
            if (temp.getValue() > data) {
                if(temp.getLeft() == null) {
                    temp.setLeft(new Node(data));
                    return true;
                }
                temp = temp.getLeft();
            } else {
                if (temp.getRight() == null) {
                    temp.setRight(new Node(data));
                    return true;
                }
                temp = temp.getRight();
            }
        }
        return false;
    }

    public int getElementCount(){
        return getElementCount(root);
    }
    private int getElementCount(Node n){
        if(n == null){
            return 0;
        }
        return getElementCount(n.left) + getElementCount(n.right) +1;
    }

    public int getSum(){
        return getSum(root);
    }

    private int getSum(Node n){
        if(n == null){
            return 0;
        }

        return getSum(n.left) + getSum(n.right) +n.value;
    }

    public int getHeight(){
        if(root == null){
            return 0;
        }
        ArrayList<Integer> results = new ArrayList<>();
         return getHeight(root);
    }

    private int getHeight(Node n){
        int left = 0;
        if(n.left != null){
            left =  1 + getHeight(n.left);
        }
        int right = 0;
        if(n.right != null){
            right =  1 + getHeight(n.right);
        }
        return right > left? right: left;
    }

    public int getLeafCount(){
        if(root == null){
            return 0;
        }
        return getLeafCount(root);
    }

    private int getLeafCount(Node n) {
        if(n == null){
            return 0;
        }
        if(n.left == null && n.right == null){
            return 1;
        }
        return getLeafCount(n.left) + getLeafCount(n.right);
    }

    public boolean hasNodesWithOneChild(){
        return hasNodesWithOneChild(root);
    }

    private boolean hasNodesWithOneChild(Node n) {
        if(n == null){
            return false;
        }
        if((n.left == null || n.right == null) && n.left != n.right){
            return true;
        }
        return hasNodesWithOneChild(n.left) || hasNodesWithOneChild(n.right);
    }

    public boolean isValid(){
        return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isValid(Node n, int minValue, int maxValue) {
        if(n != null){

        }
        return false;
    }

    /** diese Klasse testen
     @param  args  Parameter des Programmaufrufs */
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        for (int i = 0; i < 3; i++) {
            int x = (int) (Math.random() * 50);
            System.out.println(x);
            tree.insert(x);
        }
        for (int i = 0; i < 50; i++) {
            System.out.println(i + ": " + tree.contains(i));
        }
        System.out.println(tree);
        System.out.println(tree.getElementCount());
        System.out.println(tree.getSum());
        System.out.println(tree.getHeight());
        System.out.println(tree.getLeafCount());
        System.out.println(tree.hasNodesWithOneChild());
    }
}

