/**
 * Created by Nikhil on 1/29/17.
 */

import java.util.Arrays;
import java.util.List;

/**
 * Inspired from
 * You are given an integer array nums and you have to return a new counts array. The counts array has the property
 * where counts[i] is the number of smaller elements to the right of nums[i].
 */

/**
 * Inspired from
 * https://discuss.leetcode.com/topic/31405/9ms-short-java-bst-solution-get-answer-when-building-bst/2
 */
public class CountOfSmallerNumbers {
    class Node {
        int dup;
        int leftSum;
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
            this.leftSum = 0;
            this.dup = 1;
        }
    }

    public static void main(String[] args) {
        int[] input = {5, 2, 6, 1};
        new CountOfSmallerNumbers().countSmaller(input);
    }

    public List<Integer> countSmaller(int[] nums) {
        Integer[] res = new Integer[nums.length];
        Node root = null;
        for (int i = nums.length - 1; i >= 0; i--) {
            root = insertInBST(res, 0, nums[i], root, i);
        }
        return Arrays.asList(res);
    }

    private Node insertInBST(Integer[] res, int preSum, int num, Node root, int index) {
        if (root == null) {
            root = new Node(num);
            res[index] = preSum;
        } else if (root.val == num) {
            root.dup = root.dup + 1;
            res[index] = preSum + root.leftSum;
        } else if (root.val > num) {
            root.leftSum++;
            root.left = insertInBST(res, preSum, num, root.left, index);
        } else {
            root.right = insertInBST(res, preSum + root.leftSum + root.dup, num, root.right, index);
        }
        return root;
    }

}
