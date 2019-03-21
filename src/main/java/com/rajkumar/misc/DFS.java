package com.rajkumar.misc;

import java.util.LinkedList;
import java.util.Stack;

public class DFS {

    public void search(Node aNode) {
        Stack<Node> s = new Stack<>();

//        for(int i=0; i < graph.length; i++) {
//            s.push(start);
//            System.out.print(start+" ");
//
//        }
    }

    public static void main(String[] args) {

        Node n1 = new Node(1);
        Node n2 = n1.addNeighbour(2);
        Node n3 = n1.addNeighbour(3);
        Node n4 = n2.addNeighbour(4);
        Node n5 = n2.addNeighbour(5);
        n3.addNeighbour(n5);
        n4.addNeighbour(n5);
        Node n6 = n4.addNeighbour(6);
        n5.addNeighbour(n6);

        new DFS().search(n1);
    }
}
