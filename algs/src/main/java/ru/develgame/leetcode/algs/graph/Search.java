package ru.develgame.leetcode.algs.graph;

import java.util.List;

public interface Search {
    List<Integer> getVisited();

    void search(Node node);
}
