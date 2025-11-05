//Time Complexity: O(n) — Each node is visited once during DFS.
//Space Complexity: O(h) — Recursion stack space, where h is the tree height.
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Pair {
    TreeNode node;
    int height;

    Pair(TreeNode node, int height) {
        this.node = node;
        this.height = height;
    }
}

class Solution {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Pair result = dfs(root);
        return result.node;
    }

    public Pair dfs(TreeNode node) {
        if (node == null) return new Pair(null, 0);

        Pair left = dfs(node.left);
        Pair right = dfs(node.right);

        if (right.height == left.height) {
            return new Pair(node, left.height + 1);
        } else if (right.height > left.height) {
            return new Pair(right.node, right.height + 1);
        } else {
            return new Pair(left.node, left.height + 1);
        }
    }
}
