//BF
//O(n)
//O(1)
// class Solution {
//     public int findPeakElement(int[] nums) {
//         int n=nums.length;
//         if(n==1 || nums[0]>nums[1]) return 0;
//         if(nums[n-1]>nums[n-2]) return n-1;
//         for(int i=1;i<n-1;i++){
//             if(nums[i]>nums[i-1] && nums[i]>nums[i+1]) return i;
//         }
//         return 0;
//     }
// }

//Best 
//O(log N)
//O(1)
class Solution{
    public int findPeakElement(int[] nums){
        int n=nums.length;
        if(n==1) return 0;
        if(nums[0]>nums[1]) return 0;
        if(nums[n-1]>nums[n-2]) return n-1;
        int s = 1;
        int e = n-2;
        while(s<=e){
            int mid = s+(e-s)/2;
            if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]){
                return mid;
            }
            if(nums[mid]<nums[mid-1] && nums[mid]<nums[mid+1]) {
                e=mid-1;
            }
            if(nums[mid]>nums[mid+1]){
                e=mid-1;
            }else if(nums[mid-1]<nums[mid]){
                s=mid+1;
            }

        }
        return -1;
    }
}
