package com.graph;

import java.util.*;

public class BellmanFord {


    Graph graph;
    Set<Node> visited;
    Set<Node> pending;

    List<Node> nodes;
    List<Edge> edges;

    Map<Node, String> path;
    Map<Node, Long> shortestDistance;

    BellmanFord(Graph graph){
        this.graph = graph;
        this.nodes = graph.getNodes();
        this.edges = graph.getEdges();
        this.visited = new HashSet<>();
        this.pending = new HashSet<>();
        this.path = new HashMap<>();
        this.shortestDistance = new HashMap<>();

        for (Node target:this.nodes){
            shortestDistance.put(target, Long.MAX_VALUE);
        }
    }

    public void shortestPath(Node node){
        pending.add(node);
        shortestDistance.put(node, 0L);

        for (int i = 0; i<nodes.size()-1; i++){
            for (Edge edge:edges){
                if (shortestDistance.get(edge.getStart()) != Long.MAX_VALUE &&
                        shortestDistance.get(edge.getEnd()) > (shortestDistance.get(edge.getStart()) + edge.getCost())){
                    shortestDistance.put(edge.getEnd(), shortestDistance.get(edge.getStart()) + edge.getCost());
                    path.put(edge.getEnd(), path.getOrDefault(edge.getEnd(),"")+"-"+edge.getStart());
                }
            }
        }
    }

    public String getPath(Node node){
        return path.get(node);
    }
}
