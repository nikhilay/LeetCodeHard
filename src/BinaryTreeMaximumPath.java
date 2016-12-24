/**
 * Created by Nikhil on 12/24/16.
 */


/**
 * Given a binary tree, find the maximum path sum.
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree
 * along the parent-child connections. The path must contain at least one node and does not need to go through the root.
 * For example:
 * Given the below binary tree,
 */

/**
 * Inspired from
 * https://discuss.leetcode.com/topic/17823/elegant-java-solution/2g
 */
public class BinaryTreeMaximumPath {
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }

    private int helper(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(helper(node.left), 0);
        int right = Math.max(helper(node.right), 0);
        max = Math.max(max, node.val + left + right);
        return node.val + Math.max(left, right);
    }
}
