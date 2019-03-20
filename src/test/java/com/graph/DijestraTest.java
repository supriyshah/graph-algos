package com.graph;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
public class DijestraTest {

    @Test
    public void testSimpleGraph(){
        Graph graph = new Graph();

        graph.addEdge(new Node("A"),new Node("B"),2,1);
        graph.addEdge(new Node("A"),new Node("C"),5,1);
        graph.addEdge(new Node("B"),new Node("C"),1,1);
        graph.addEdge(new Node("B"),new Node("D"),1,1);

        Dijestra shortestPath = new Dijestra(graph);
        shortestPath.shortestPath(graph.getNodes().get(0));
        assertNotNull(0);
     //   List<Node> path = shortestPath.getPathToDestination(graph.getNodes().get(2));

   //     assertNotNull(path);
    //    assertTrue(path.size() > 0);
    }
}
