package com.graph;

import java.util.*;
import java.util.stream.Collectors;


public class ShortestPath {

    Graph graph;
    Set<Node> settledNodes;
    Set<Node> unSettledNodes;
    Map<Node, Node> shortestEdge; //Stores the shortest edge between two nodes
    Map<Node, Long> shortestDistance; // Shortest Distance from start Node to this Node
    List<Node> nodes; //Nodes of the graph
    List<Edge> edges; //Edges of the graph

    ShortestPath(Graph graph) {
        this.graph = graph;
        this.settledNodes = new HashSet<>();
        this.unSettledNodes = new HashSet<>();
        this.shortestEdge = new HashMap<>();
        this.shortestDistance = new HashMap<>();
        this.nodes = graph.getNodes();
        this.edges = graph.getEdges();
    }


    public void getShortestPathsBetweenNodes(Node start) {
        shortestDistance.put(start, 0L);
        unSettledNodes.add(start);

        while (unSettledNodes.size() > 0) {
            Node node = getMinNode(unSettledNodes);
            settledNodes.add(node);
            unSettledNodes.remove(node);
            findMinDistance(node);
        }
    }

    public List<Node> getPathToDestination(Node destination) {
        List<Node> path = new LinkedList<>();
        Node node = destination;
        long capacity = 0L;

        if (shortestEdge.get(node) == null) {
            return null;
        }
        path.add(node);
        while (shortestEdge.get(node) != null) {
            Node temp = node;
            node = shortestEdge.get(node);
            System.out.println(node.getName()+ "->" +temp.getName()+"(Remaining Capacity: "+(graph.findEdge(node, temp).getCapacity()-1)+")");
            capacity += graph.findEdge(node, temp).getCapacity();
            path.add(node);
        }

        System.out.println("Shortest Distance is " + shortestDistance.get(destination));
        return path;
    }

    private void findMinDistance(Node node) {
        List<Node> neighbours = getNeighbors(node);

        for (Node target: neighbours){
        if (getShortestDistance(target) > getShortestDistance(node) + getDistance(node, target)){
                shortestDistance.put(target, getShortestDistance(node)+getDistance(node, target));
                shortestEdge.put(target, node);
                unSettledNodes.add(target);
            }
        }
//        neighbours.stream().filter(target -> getShortestDistance(target) > getShortestDistance(node) + getDistance(node, target))
//                .forEach(target -> {
//            shortestDistance.put(target, getShortestDistance(node) + getDistance(node, target));
//            shortestEdge.put(target, node);
//            unSettledNodes.add(target);
//        });
    }

    private long getDistance(Node node, Node target) {
        for (Edge edge : edges) {
            if (edge.getStart().equals(node) && edge.getEnd().equals(target)) {
                return edge.getCost();
            }
        }
        return Long.MAX_VALUE;
    }

    private List<Node> getNeighbors(Node node) {
        List<Node> neighbors = edges.stream().filter(edge -> edge.getStart().equals(node) && !isSettled(edge.getEnd()))
                                .map(Edge::getEnd)
                                .collect(Collectors.toList());
        return neighbors;
    }

    /*
    Given a set of nodes, finds the node with shortest distance using getShortestDistance
     */
    private Node getMinNode(Set<Node> Nodes) {
        Node minNode = null;
        for (Node Node : Nodes) {
            if (minNode == null) {
                minNode = Node;
            } else {
                if (getShortestDistance(Node) < getShortestDistance(minNode)) {
                    minNode = Node;
                }
            }
        }
        return minNode;
    }

    private Boolean isSettled(Node Node) {
        return settledNodes.contains(Node);
    }

    private long getShortestDistance(Node destination) {
        Long d = shortestDistance.get(destination); // If node already exists in shortestDistance
        if (d == null) {
            return Long.MAX_VALUE;
        } else {
            return d;
        }
    }


}
