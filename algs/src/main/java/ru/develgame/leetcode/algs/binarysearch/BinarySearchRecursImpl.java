package ru.develgame.leetcode.algs.binarysearch;

public class BinarySearchRecursImpl implements BinarySearch {
    private int[] nums;

    private int binSearch(int startPos, int endPos, int target) {
        int barrierPos = startPos + (endPos - startPos) / 2;
        if (nums[barrierPos] == target)
            return barrierPos;

        if (target < nums[barrierPos]) {
            if (startPos == barrierPos)
                return -1;
            return binSearch(startPos, barrierPos - 1, target);
        }
        else {
            if (barrierPos == endPos)
                return -1;
            return binSearch(barrierPos + 1, endPos, target);
        }
    }

    public int search(int[] nums, int target) {
        this.nums = nums;
        return binSearch(0, nums.length - 1, target);
    }
}
