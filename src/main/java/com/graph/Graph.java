package com.graph;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
public class Graph {
    List<Node> nodes;
    List<Edge> edges;

    Graph (){
        nodes = new ArrayList<>();
        edges = new ArrayList<>();
    }
    /*
    Check if the nodes already exist in the graph. If no, create nodes and then edge between nodes.
     */
    public Boolean addEdge (Node start, Node end, int cost, int weight){

            if (!this.nodes.contains(start)) {
                nodes.add(start);
            }

            if (!this.nodes.contains(end)) {
                nodes.add(end);
            }

        return edges.add(new Edge(start, end, cost, weight));
    }


    public Edge findEdge (Node start, Node end){
        for (Edge edge:edges){
            if (edge.getStart().getName().equals(start.getName()) && edge.getEnd().getName().equals(end.getName())){
                return edge;
            }
        }

        return null;
    }

    public List<Edge> findNeighbours (Node node){

        List<Edge> neighbours = new ArrayList<>();

        for (Edge edge:edges){
            if (edge.getStart().getName().equals(node.getName())){
                neighbours.add(edge);
            }
        }
        return neighbours;
    }
}
