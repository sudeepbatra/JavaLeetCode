package com.stoxalpha;

import org.junit.Before;
import org.junit.Test;

public class GraphTest {
    private Graph g;

    @Before
    public void Setup() throws Exception {
        g = new Graph(8);
    }

    @Test
    public void breadthFirstSearch() throws Exception {

        g.addEdge(0, 1);
        g.addEdge(1, 0);
        g.addEdge(1, 4);
        g.addEdge(4, 1);
        g.addEdge(4, 6);
        g.addEdge(6, 4);
        g.addEdge(6, 0);
        g.addEdge(0, 6);
        g.addEdge(1, 5);
        g.addEdge(5, 1);
        g.addEdge(5, 3);
        g.addEdge(3, 5);
        g.addEdge(3, 0);
        g.addEdge(0, 3);
        g.addEdge(5, 2);
        g.addEdge(2, 5);
        g.addEdge(2, 7);
        g.addEdge(7, 2);

        System.out.println("Following is the Breadth First Traversal (starting from vertex 0)");
        g.breadthFirstSearch(0);
    }

    @Test
    public void depthFirstSearch() throws Exception {

        g.addEdge(0, 1);
        g.addEdge(1, 0);
        g.addEdge(1, 4);
        g.addEdge(4, 1);
        g.addEdge(4, 6);
        g.addEdge(6, 4);
        g.addEdge(6, 0);
        g.addEdge(0, 6);
        g.addEdge(1, 5);
        g.addEdge(5, 1);
        g.addEdge(5, 3);
        g.addEdge(3, 5);
        g.addEdge(3, 0);
        g.addEdge(0, 3);
        g.addEdge(5, 2);
        g.addEdge(2, 5);
        g.addEdge(2, 7);
        g.addEdge(7, 2);

        System.out.println("Following is the Depth First Traversal (starting from vertex 0)");
        g.depthFirstSearch(0);
    }

}
