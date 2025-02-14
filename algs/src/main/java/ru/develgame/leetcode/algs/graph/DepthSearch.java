package ru.develgame.leetcode.algs.graph;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class DepthSearch {
    private List<Integer> visited = new ArrayList<>();

    public void deepFirstSearch(Node node) {
        visited.add(node.getVal());

        for (Node neighbor : node.getNeighbors()) {
            if (!visited.contains(neighbor.getVal())) {
                deepFirstSearch(neighbor);
            }
        }
    }
}
