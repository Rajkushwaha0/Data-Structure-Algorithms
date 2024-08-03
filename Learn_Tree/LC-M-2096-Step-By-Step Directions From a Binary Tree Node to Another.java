class Solution {
    StringBuilder sb;
    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder result  = new StringBuilder();
        TreeNode LCA = lca(root,startValue,destValue);
        sb = new StringBuilder();
        solve(LCA,startValue);
        for(int i=0;i<sb.length();i++){
            result.append("U");
        }
        sb = new StringBuilder();
        solve(LCA,destValue);
        result.append(sb);
        return result.toString();
    }
    public TreeNode lca(TreeNode root,int s,int e){
        if(root == null) return null;
        if(root.val==s || root.val==e) return root;

        TreeNode left = lca(root.left,s,e);
        TreeNode right = lca(root.right,s,e);

        if(left!=null && right==null) return left;
        if(left==null && right==null) return null;
        if(left==null && right!=null) return right;
        return root;
    }
    public  Boolean solve(TreeNode root,int val){
        if(root == null) return false;

        if(root.val==val){
            return true;
        }
        sb.append('L');
        if (solve(root.left, val)) {
            return true;
        }
        sb.deleteCharAt(sb.length() - 1);

        sb.append('R');
        if (solve(root.right, val)) {
            return true;
        }
        sb.deleteCharAt(sb.length() - 1);

        return false;        
    }
}
