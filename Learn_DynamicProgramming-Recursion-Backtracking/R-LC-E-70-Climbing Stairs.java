class Solution {
    //recurssion
    //O(N)
    //O(N) -> recurssion stack
    // public int climbStairs(int n) {
    //     if(n<=0){
    //         return 0;
    //     }
    //     if(n==1 || n==2){
    //         return n;
    //     }
    //     return climbStairs(n-1)+climbStairs(n-2);
    // }

    //optimized
    //O(N)
    //O(N) -> dp
    public int climbStairs(int n){
        int[] dp = new int[n+1];
        if(n==1 || n==2) {
            return n;
        }
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
