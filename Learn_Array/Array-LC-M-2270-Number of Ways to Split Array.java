class Solution {
    //O(N^2)
    //O(1)
    // public int waysToSplitArray(int[] nums) {
    //     int n = nums.length;
    //     int leftSum = 0;
    //     int rightSum = 0;
    //     int ans=0;
    //     for(int i=0;i<n-1;i++){
    //         for(int j=0;j<n;j++){
    //             if(j<=i){
    //                 leftSum += nums[j];
    //             }else{
    //                 rightSum += nums[j];
    //             }
    //         }
    //         if(leftSum>=rightSum) ans++;
    //         leftSum=0;
    //         rightSum=0;
    //     }
    //     return ans;
    // }
    public int waysToSplitArray(int[] nums) {
        //O(N)+O(N)
        //O(1)
        int n = nums.length;
        long totalSum = 0;
        long leftSum = 0;
        long rightSum = 0;
        int ans=0;
        for(int j:nums){
            totalSum+=j;
        }
        for(int i=0;i<n-1;i++){
            leftSum += nums[i];
            rightSum = totalSum-leftSum;
            if(leftSum >= rightSum) ans++;
        }
        return ans;
    }
}
