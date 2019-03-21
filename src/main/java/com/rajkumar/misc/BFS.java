package com.rajkumar.misc;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

    Queue<Node> que = new LinkedList<>();

    public void search(Node aNode) {
        que.add(aNode);
        aNode.visited = true;
        while (!que.isEmpty()) {
            Node n = que.poll();
            System.out.print(n.data+" ");
            for(Node theNode : n.getNeighbours()) {
                if(theNode != null && !theNode.visited) {
                    que.add(theNode);
                    theNode.visited=true;
                }
            }
        }
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

        new BFS().search(n1);
    }
}
