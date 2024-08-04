class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int[] sums = new int[(n*(n+1))/2];
        int mod = 1000000007;
        int ind=0;
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=i;j<n;j++){
                sum+=nums[j];
                sums[ind++]=sum;
            }
        }
        Arrays.sort(sums);
        int ans=0;
        for(int i=left;i<=right;i++) {
            ans = (ans+sums[i-1])%mod;
        }
        return ans%mod;
    }
}
