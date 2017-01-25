/**
 * Created by Nikhil on 1/25/17.
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * For example:
 * Given binary tree {1,#,2,3},
 * return [3,2,1].
 */
public class BinaryTreePostOrderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null) stack.add(node.left);
            if (node.right != null) stack.add(node.right);
            list.add(0, node.val);
        }
        return list;
    }
}
