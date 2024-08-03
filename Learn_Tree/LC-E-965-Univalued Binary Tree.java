class Solution {
    public boolean isUnivalTree(TreeNode root) {
        int val = root.val;
        return solve(root,val);
    }
    public boolean solve(TreeNode root,int k){
        if(root==null) return true;
        boolean left = solve(root.left,k);
        boolean right= solve(root.right,k);
        boolean check = root.val==k;
        return check&&left&&right;
    }
}
