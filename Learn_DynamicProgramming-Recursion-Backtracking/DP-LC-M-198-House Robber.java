class Solution {
    public int rob(int[] nums) {
        // return solve(nums,0,nums.length);
        // int[] dp = new int[nums.length];
        // Arrays.fill(dp,-1);
        // return memo(nums,0,nums.length,dp);
        return tab(nums,nums.length);
    }
    public int solve(int[] nums,int i,int n){
        if(i>=n){
            return 0;
        }
        int include = nums[i]+solve(nums,i+2,n);
        int exclude = solve(nums,i+1,n);
        return Math.max(include,exclude);
    }
    public int memo(int[] nums,int i,int n,int[] dp){
        if(i>=n) return 0;
        if(dp[i]!=-1) return dp[i];
        int include = nums[i]+memo(nums,i+2,n,dp);
        int exclude = memo(nums,i+1,n,dp);
        return dp[i] = Math.max(include,exclude);
    }
    public int tab(int[] nums,int n){
        int[] dp = new int[n];
        dp[0]=nums[0];
        for(int i=1;i<n;i++){
            int pick = nums[i];
            if(i>1){
                pick+=dp[i-2];
            }
            int notpick = dp[i-1];
            dp[i]=Math.max(pick,notpick);
        }
        return dp[n-1];
    }
}
