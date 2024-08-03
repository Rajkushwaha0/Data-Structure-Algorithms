class Solution {
    int ans = 0;
    public int sumNumbers(TreeNode root) {
        if(root==null) return 0;
        solve(root,0,10);
        return ans;
    }
    public boolean solve(TreeNode root,int sum,int multiple){
        if(root==null){
            return true;
        }
        sum+=root.val;
        if(root.left==null && root.right==null){
            // System.out.println(sum);
            ans+=sum;
        }
        boolean left = solve(root.left,sum*10,multiple);
        boolean right = solve(root.right,sum*10,multiple);
        if(left && right){
            sum/=10;
            return true;
        }
        return false;

    }
}
