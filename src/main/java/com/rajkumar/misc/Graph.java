package com.rajkumar.misc;

import java.util.LinkedList;
import java.util.stream.IntStream;

public class Graph {

    LinkedList<Integer> theGraph[];

    public Graph(int size) {
        theGraph = new LinkedList[size];
        IntStream.range(0, size).forEach( x -> {
            theGraph[x] = new LinkedList<>();
        });
    }

    public void addEdge(int src, int dest) {
        theGraph[src].add(dest);
    }

    public static void main(String[] args) {

        Graph g = new Graph(4);
        g.addEdge(2,0);
        g.addEdge(2,3);
        g.addEdge(0,1);
        g.addEdge(0,2 );
    }
}
