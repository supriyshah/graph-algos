package com.graph;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Node {
    String name;

    @Override
    public boolean equals(Object obj){
        Node node = (Node) obj;
        if (node.getName().equals(this.name)){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    public String toString(){
        return this.name;
    }

    @Override
    public int hashCode(){
        return this.getName().hashCode();
    }
}
