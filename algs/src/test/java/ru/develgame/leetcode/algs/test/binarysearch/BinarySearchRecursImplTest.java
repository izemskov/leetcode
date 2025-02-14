package ru.develgame.leetcode.algs.test.binarysearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.develgame.leetcode.algs.binarysearch.BinarySearch;
import ru.develgame.leetcode.algs.binarysearch.BinarySearchRecursImpl;

import java.util.stream.Stream;

class BinarySearchRecursImplTest {
    private BinarySearch binarySearchRecursImpl;

    @BeforeEach
    void setUp() {
        binarySearchRecursImpl = new BinarySearchRecursImpl();
    }

    public static Stream<Arguments> sourceTest1() {
        return Stream.of(
                Arguments.of(new int[]{-1, 0, 3, 5, 9, 12}, 9, 4),
                Arguments.of(new int[]{-1, 0, 3, 5, 9, 12}, 2, -1));
    };

    @ParameterizedTest
    @MethodSource("sourceTest1")
    void test1(int[] nums, int target, int expected) {
        int actual = binarySearchRecursImpl.search(nums, target);
        Assertions.assertEquals(expected, actual);
    }
}
