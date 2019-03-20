package com.graph;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Edge {
    Node start;
    Node end;
    long cost;
    long capacity;


    @Override
    public boolean equals(Object obj){
        Edge edge = (Edge) obj;
        if (edge.getStart().equals(this.start)&&(edge.getEnd().equals(this.end))){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    public int hashCode(){
        return start.hashCode();
    }
}
