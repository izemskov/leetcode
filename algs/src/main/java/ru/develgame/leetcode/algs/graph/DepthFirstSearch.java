package ru.develgame.leetcode.algs.graph;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class DepthFirstSearch implements Search {
    private List<Integer> visited = new ArrayList<>();

    @Override
    public void search(Node node) {
        visited.add(node.getVal());

        for (Node neighbor : node.getNeighbors()) {
            if (!visited.contains(neighbor.getVal())) {
                search(neighbor);
            }
        }
    }
}
