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
    String s="";
    int c=0;
    TreeNode temp ;
    public String tree2str(TreeNode root) {
        // s+=root.val;
        // temp = root;
        solve(root);
        // solve1(root);
        
        return s.substring(1,s.length()-1);
        
    }
    public void solve(TreeNode root){
        if(root==null) 
        {
            return ;
        }
        
        s+='(';
        s+=root.val;
        if(root.left==null && root.right!=null){
            s+='(';
            s+=')';    
        }
        solve(root.left);
        solve(root.right);
        s+=')';
        return ;
        
    }
}
