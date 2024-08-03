class Solution {
    public int minScoreTriangulation(int[] values) {

        int i=0;
        int j=values.length;
        int[][] dp = new int[j][j];
        for(int[] k:dp){
            Arrays.fill(k,-1);
        }
        return solve(values,i,j-1,dp);
    }
    public int solve(int[] v , int i,int j,int[][] dp){
        if(i+1 ==j ) return 0;
        if(dp[i][j]!= -1) return dp[i][j];
        int ans = Integer.MAX_VALUE;
        for(int k = i+1;k<=j-1;k++){
            ans=Math.min(ans, v[k]*v[i]*v[j]+solve(v,i,k,dp)+solve(v,k,j,dp));
        }
        return dp[i][j]=ans;
    }
}
