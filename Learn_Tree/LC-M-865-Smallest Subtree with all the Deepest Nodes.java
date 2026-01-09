class Pair {
    TreeNode node;
    int height;

    Pair(TreeNode node, int height) {
        this.node = node;
        this.height = height;
    }
}
class Solution {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
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
