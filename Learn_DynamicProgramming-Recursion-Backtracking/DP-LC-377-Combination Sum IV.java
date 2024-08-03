class Solution {
    public int solve(int i,int[] arr,int t,int[][] dp){
            if(t==0){
                return 1;
            }
            if(t<0){
                return 0;
            }
            if(i>=arr.length){
                return 0;
            }
            if(dp[i][t]!= -1) return dp[i][t];
            int take = solve(0,arr,t-arr[i],dp);
            int nottake = solve(i+1,arr,t,dp);
            return dp[i][t]= take+nottake ;
            

    }
    public int combinationSum4(int[] c, int t) {
        int[][] dp = new int[201][1001];
        for(int[] i:dp){
            Arrays.fill(i,-1);
        }
        return solve(0,c,t,dp);
    }
}
