class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        // return solve(n);
        return memo(n,dp);
    }
    public int solve(int n){
        if(n==1) return 1;
        int ans = Integer.MIN_VALUE;
        for(int i=1;i<=n-1;i++){
            int prod= i *Math.max(n-i ,solve(n-i));
            ans=Math.max(prod,ans);
        }
        return ans;
        
    }
    public int memo(int n,int[] dp){
        if(n==1) return 1;
        if(dp[n]!=-1) return dp[n];
        int ans = Integer.MIN_VALUE;
        for(int i=1;i<=n-1;i++){
            int prod= i *Math.max(n-i ,memo(n-i,dp));
            ans=Math.max(prod,ans);
        }
        return dp[n]=ans;
        
    }
}
