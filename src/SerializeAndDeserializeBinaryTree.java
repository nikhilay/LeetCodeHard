/**
 * Created by Nikhil on 12/24/16.
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * Serialization is the process of converting a data structure or object into a sequence of bits so that
 * it can be stored in a file or memory buffer, or transmitted across a network connection link to be
 * reconstructed later in the same or another computer environment.
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your
 * serialization/deserialization algorithm should work. You just need to ensure that a binary tree can
 * be serialized to a string and this string can be deserialized to the original tree structure.
 * For example, you may serialize the following tree
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree.
 * You do not necessarily need to follow this format, so please be creative and come up
 * with different approaches yourself.
 */
public class SerializeAndDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "#";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                sb.append("null");
            } else {
                sb.append(node.val);
            }
            sb.append(" ");
            queue.add(node.left);
            queue.add(node.right);
        }

        return sb.toString().trim();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("") || data.equals("null")) return null;
        String[] arr = data.split("\\s+");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.valueOf(arr[0]));
        queue.add(root);
        for (int i = 1; i < arr.length; i++) {
            TreeNode parent = queue.poll();
            if (!arr[i].equals("null")) {
                parent.left = new TreeNode(Integer.valueOf(arr[i]));
                queue.add(parent.left);
            }

            if (!arr[++i].equals("null")) {
                parent.right = new TreeNode(Integer.valueOf(arr[i]));
                queue.add(parent.right);
            }
        }

        return root;
    }
}
