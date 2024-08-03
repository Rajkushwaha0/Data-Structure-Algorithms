class Solution {
    int sum=0;
    public TreeNode bstToGst(TreeNode root) {
        return solve(root);
        // return root;
    }
    public TreeNode solve(TreeNode root){
        if(root == null) return null;
        solve(root.right);
        sum+=root.val;
        root.val = sum;
        solve(root.left);
        return root;
    }
}

// TC --> O(N)
