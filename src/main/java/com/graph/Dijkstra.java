package com.graph;


import java.util.*;

public class Dijestra {

    Graph graph;
    Set<Node> visited;
    Set<Node> pending;

    List<Edge> shortestEdge;
    Map<Node, Long> shortestDistance;

    Dijestra(Graph graph){
        this.graph = graph;
        this.visited = new HashSet<>();
        this.pending = new HashSet<>();
        this.shortestEdge = new ArrayList<>();
        this.shortestDistance = new HashMap<>();
    }

    public void shortestPath(Node node){
        pending.add(node);
        shortestDistance.put(node, 0L);
        while (pending.size() > 0){
            Node temp = getClosestNode(pending);
            visited.add(temp);
            pending.remove(temp);
            checkNeighbours(temp);
        }
       // Map<Edge> neighbours = this.graph.findNeighbours(node);
    }

    public Node getClosestNode (Set<Node> nodes){
        Node temp = null;
        for (Node node:nodes){
            if (temp == null){
                temp = node;
            }else{
                if (getShortestDistance(node) < getShortestDistance(temp)){
                    temp = node;
                }
            }
        }
        return temp;
    }

    public Long getShortestDistance (Node node){
        Long distance = shortestDistance.get(node);

        if (distance == null){
            return Long.MAX_VALUE;
        }
        return distance;
    }

    public void checkNeighbours(Node node){
        List<Edge> connectingEdges = this.graph.findNeighbours(node);

        for (Edge edge:connectingEdges){
            if (getShortestDistance(edge.end) > getShortestDistance(node) + edge.getCost()){
                shortestDistance.put(edge.end, getShortestDistance(node) + edge.getCost());
                shortestEdge.add(edge);
                pending.add(edge.getEnd());
            }
        }
        }

}
