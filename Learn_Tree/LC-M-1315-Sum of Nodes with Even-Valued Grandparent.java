class Solution {
    int maxsum=0;
    public int sumEvenGrandparent(TreeNode root) {
        solve(root);
        return maxsum;
    }
    public void solve(TreeNode root){
        if(root==null) return ;
        if(root.val%2==0){
            if(root.left!=null){
                if(root.left.left!=null) maxsum+=root.left.left.val;
                if(root.left.right!=null) maxsum+=root.left.right.val;
            }
            if(root.right!=null){
                if(root.right.left!=null) maxsum+=root.right.left.val;
                if(root.right.right!=null) maxsum+=root.right.right.val;
            }
        }
        solve(root.left);
        solve(root.right);

    }
}
