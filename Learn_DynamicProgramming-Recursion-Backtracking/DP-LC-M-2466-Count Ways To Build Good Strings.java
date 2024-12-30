//O(N)
//O(N)
class Solution {
    int mod = 1000000007;
    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp = new int[100001];
        Arrays.fill(dp,-1);
        return recur(low,high,zero,one,0,dp)%mod;
    }
    public int recur(int low,int high,int zero,int one,int length,int[] dp){
        if(length>high){
            return 0;
        }
        if(dp[length]!=-1) return dp[length];
        int first =  recur(low,high,zero,one,length+zero,dp)%mod;
        int second = recur(low,high,zero,one,length+one,dp)%mod;
        int add = (length>=low && length<=high)?1:0;
        return dp[length]=(first+second+add)%mod;
    }

}
