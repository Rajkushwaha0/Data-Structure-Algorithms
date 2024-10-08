class Solution {
    //O(n*n)
    //O(n+n)
    public int maxSatisfaction(int[] s) {
        int n = s.length;
        int[][] dp = new int[n+1][n+1];
        for(int[] i: dp){
            Arrays.fill(i,-1);
        }
        
        Arrays.sort(s);
        return solve(s,0,dp,1);
    }
    public int solve(int[] arr, int i,int[][] dp,int k){
        if(i>=arr.length){
            return 0;
        }

        if(dp[i][k]!= -1) return dp[i][k];

        int pick = (arr[i]*k)+solve(arr,i+1,dp,k+1);
        int notpick = solve(arr,i+1,dp,k);
        dp[i][k]=Math.max(pick,notpick);
        return dp[i][k];
    }
}
