package com.rajkumar.misc;

import java.util.ArrayList;
import java.util.List;

public class Node {
    int data;
    boolean visited;
    List<Node> neighbours;

    public Node(int aData) {
        data = aData;
        neighbours = new ArrayList<>();
    }

    public Node addNeighbour(int aData) {
        Node theNode = new Node(aData);
        neighbours.add(theNode);
        return theNode;
    }

    public Node addNeighbour(Node aNode) {
        neighbours.add(aNode);
        return aNode;
    }

    public List<Node> getNeighbours() {
        return neighbours;
    }

    public void print() {
        System.out.print(data);
        neighbours.forEach(x -> System.out.print(" --> "+x));
    }
}
