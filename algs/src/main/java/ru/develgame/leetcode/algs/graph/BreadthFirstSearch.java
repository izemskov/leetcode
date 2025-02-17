package ru.develgame.leetcode.algs.graph;

import lombok.Getter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Getter
public class BreadthFirstSearch implements Search {
    private List<Integer> visited = new ArrayList<>();
    private LinkedList<Node> queue = new LinkedList<>();

    @Override
    public void search(Node node) {
        queue.addLast(node);

        while (!queue.isEmpty()) {
            Node current = queue.pollFirst();
            visited.add(current.getVal());
            current.getNeighbors().stream()
                    .filter(t -> !visited.contains(t.getVal()))
                    .filter(t -> !queue.contains(t))
                    .forEach(queue::addLast);
        }
    }
}
