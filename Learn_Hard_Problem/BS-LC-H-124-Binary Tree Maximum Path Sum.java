class Solution {
    //O(N)
    //O(1)
    public static int maxPathSum(TreeNode root) {
        int[] max = new int[1];
        max[0]=Integer.MIN_VALUE;
        solve(root,max);
        return max[0];
        
    }
    public static int solve(TreeNode root , int[] max){
        if(root==null) return 0;

        int leftsum = Math.max(0,solve(root.left,max));
        int rightsum = Math.max(0,solve(root.right,max));
        max[0]= Math.max(max[0],leftsum+rightsum+root.val);

        return Math.max(leftsum,rightsum)+root.val;
    }
}
