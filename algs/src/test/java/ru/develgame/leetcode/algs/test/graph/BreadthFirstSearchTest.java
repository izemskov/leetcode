package ru.develgame.leetcode.algs.test.graph;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.develgame.leetcode.algs.graph.BreadthFirstSearch;
import ru.develgame.leetcode.algs.graph.Node;
import ru.develgame.leetcode.algs.graph.Search;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BreadthFirstSearchTest {
    private Search breadthFirstSearch;

    @BeforeEach
    void setUp() {
        breadthFirstSearch = new BreadthFirstSearch();
    }

    public static Stream<Arguments> sourceTest1() {
        return Stream.of(
                Arguments.of(new int[][]{{2,4}, {1,3}, {2,4}, {1,3}}, new int[]{1, 2, 4, 3}),
                Arguments.of(new int[][]{{}, {}}, new int[]{1}),
                Arguments.of(new int[][]{{2, 3}, {1}, {1, 4, 5, 6}, {3, 7}, {3, 7}, {3, 8}, {4}, {6}},
                        new int[]{1, 2, 3, 4, 5, 6, 7, 8}));
    };

    @ParameterizedTest
    @MethodSource("sourceTest1")
    void test1(int[][] graph, int[] expected) {
        breadthFirstSearch.search(Node.createGraph(graph));
        Assertions.assertEquals(Arrays.stream(expected)
                .boxed()
                .collect(Collectors.toList()), breadthFirstSearch.getVisited());
    }
}
