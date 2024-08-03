class Solution {
    boolean ans = false;
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        if (check(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    public boolean check(TreeNode root,TreeNode sub){
        if(root==null && sub!=null) return false;
        if(sub==null && root!=null) return false;
        if(sub==null && root==null) return true;

        boolean left = check(root.left,sub.left);
        boolean right = check(root.right,sub.right);
        boolean checked = root.val==sub.val;
        return left&&right&&checked;
    }

}
