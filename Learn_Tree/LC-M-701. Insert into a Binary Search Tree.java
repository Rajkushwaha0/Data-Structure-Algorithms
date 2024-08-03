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
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        solve(root,val);
        if(root==null){
            return new TreeNode(val);
        }
        return root;
    }
    public void solve(TreeNode root,int val ){
        if(root==null) return ;
        if(root.val<val){
            if(root.right!=null){
                solve(root.right,val);
            }
            else{
                root.right = new TreeNode(val);
            }
        }
        else{
            if(root.left!=null){
                solve(root.left,val);
            }
            else{
                root.left = new TreeNode(val);
            }

        }
        return ;
    }
}
