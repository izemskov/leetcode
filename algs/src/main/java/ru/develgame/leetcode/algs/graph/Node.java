package ru.develgame.leetcode.algs.graph;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@EqualsAndHashCode(of = {"val"})
public class Node {
    public int val;

    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }

    public Node(int val) {
        this.val = val;
        neighbors = new ArrayList<>();
    }

    public Node(int val, ArrayList<Node> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }

    public static Node createGraph(int[][] graph) {
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            nodes.add(new Node(i + 1));
        }

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                nodes.get(i).getNeighbors().add(nodes.get(graph[i][j] - 1));
            }
        }

        return nodes.get(0);
    }
}
