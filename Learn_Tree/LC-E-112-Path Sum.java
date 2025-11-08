class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return solve(root,0,targetSum);
    }

    boolean solve(TreeNode root,int sum,int target){
        if(root==null) return false;

        sum+=root.val;
        if(root.left==null && root.right==null){
            if(sum==target) return true;
            else return false;
        }

        boolean left = solve(root.left,sum,target);
        boolean right = solve(root.right,sum,target);
        return left||right;
    }
}
