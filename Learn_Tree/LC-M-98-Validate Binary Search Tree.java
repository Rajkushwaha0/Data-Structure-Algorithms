class Solution {
    
    public TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        Boolean left = isValidBST(root.left);
        if(prev!=null){
            if(root.val<=prev.val) return false;
        }
        prev = root;
        Boolean right = isValidBST(root.right);
        if(left==true && right==true) return true;
        else return false;
    }
}
