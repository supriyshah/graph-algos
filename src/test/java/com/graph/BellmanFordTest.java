package com.graph;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
public class BellmanFordTest {

    @Test
    public void createGraph(){
        Graph graph = new Graph();

        graph.addEdge(new Node("N11"),new Node("N12"),8,2);
        graph.addEdge(new Node("N12"),new Node("N13"),-5,1);
        graph.addEdge(new Node("N13"),new Node("N14"),3,2);

        graph.addEdge(new Node("N21"),new Node("N22"),2,2);
        graph.addEdge(new Node("N22"),new Node("N23"),2,2);
        graph.addEdge(new Node("N23"),new Node("N24"),9,2);

        graph.addEdge(new Node("N31"),new Node("N32"),4,2);
        graph.addEdge(new Node("N32"),new Node("N33"),3,2);
        graph.addEdge(new Node("N33"),new Node("N34"),3,2);

        graph.addEdge(new Node("N11"),new Node("N21"),1,1);
        graph.addEdge(new Node("N12"),new Node("N22"),4,2);
        graph.addEdge(new Node("N13"),new Node("N23"),1,2);
        graph.addEdge(new Node("N14"),new Node("N24"),4,2);

        graph.addEdge(new Node("N21"),new Node("N31"),3,2);
        graph.addEdge(new Node("N22"),new Node("N32"),6,1);
        graph.addEdge(new Node("N23"),new Node("N33"),6,1);
        graph.addEdge(new Node("N24"),new Node("N34"),4,2);

        BellmanFord bellmanFord = new BellmanFord(graph);
        bellmanFord.shortestPath(graph.getNodes().get(0));
        System.out.println(bellmanFord.getPath(graph.getNodes().get(11)));
        assertNotNull(0);
//        shortestPath.getShortestPathsBetweenNodes(graph.getNodes().get(0));
//        //  List<Node> path = shortestPath.getPathToDestination(graph.getNodes().get(11));
//        List<Node> path = shortestPath.getPathToDestination(graph.getNodes().get(1));
//        assertNotNull(path);
//        assertTrue(path.size() > 0);
    }

    @Test
    public void testSimpleGraph(){
        Graph graph = new Graph();

        graph.addEdge(new Node("A"),new Node("B"),2,1);
        graph.addEdge(new Node("A"),new Node("C"),5,1);
        graph.addEdge(new Node("B"),new Node("C"),1,1);
        graph.addEdge(new Node("B"),new Node("D"),1,1);

        BellmanFord bellmanFord = new BellmanFord(graph);
        bellmanFord.shortestPath(graph.getNodes().get(0));
        bellmanFord.getPath(graph.getNodes().get(5));
        assertNotNull(0);
//        ShortestPath shortestPath = new ShortestPath(graph);
//        shortestPath.getShortestPathsBetweenNodes(graph.getNodes().get(0));
//        List<Node> path = shortestPath.getPathToDestination(graph.getNodes().get(2));
//
//        assertNotNull(path);
//        assertTrue(path.size() > 0);
    }
}
