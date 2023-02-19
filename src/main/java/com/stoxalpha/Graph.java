package com.stoxalpha;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class Graph {
    private final int V; //No of vertices

    // Array of LinkedList
    private final LinkedList<Integer>[] adj;

    Graph(int v) {
        this.V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    //BFS from a given source s
    public void breadthFirstSearch(int s) {
        //Mark all the vertices as not visited (false)
        boolean[] visited = new boolean[this.V];

        //Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();

        // Mark the current node as visited and enqueue it
        visited[s] = true;
        System.out.println("Staring at: " + s);
        queue.add(s);

        while (queue.size() != 0) {
            s = queue.poll();
            System.out.println("De-queuing it " + s);

            //Get all adjacent vertices of the de-queued vertex s
            //If a adjacent has not been visited, then mark it visited and enqueue it.
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    System.out.println("Queueing " + n);
                    queue.add(n);
                }
            }
        }
    }

    //Depth First from a given source s
    public void depthFirstSearch(int s) {
        boolean[] visited = new boolean[this.V];

        Stack<Integer> stack = new Stack<>();
        stack.add(s);
        visited[s] = true;

        while (!stack.isEmpty()) {
            int current = stack.pop();
            System.out.println(current + " ");

            Iterator<Integer> iterator = adj[current].listIterator();
            while (iterator.hasNext()) {
                int n = iterator.next();
                if (!visited[n]) {
                    stack.add(n);
                    visited[n] = true;
                }
            }
        }
    }
}
