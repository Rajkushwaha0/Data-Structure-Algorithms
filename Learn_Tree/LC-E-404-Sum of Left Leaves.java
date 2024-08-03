class Solution {
    int sum=0;
    public int sumOfLeftLeaves(TreeNode root) {
        solve(root);
        return sum;
    }
    public void solve(TreeNode root){
        if(root==null) return ;
        
        solve(root.left);
        if(root.left!=null) {
            if(root.left.left==null && root.left.right==null)
            sum+=root.left.val;
        }
        solve(root.right);
        
        return ;
    }
}
