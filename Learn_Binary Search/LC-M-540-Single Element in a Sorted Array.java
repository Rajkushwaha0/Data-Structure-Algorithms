class Solution {
    public int singleNonDuplicate(int[] nums) {
        // Brute Force
        // if(nums.length==1) return nums[0];
        // for(int i=0;i<nums.length-1;i+=2){
        //     int j=i+1;
        //     if(nums[i]!=nums[j]) return nums[i];
        // }
        // return nums[nums.length-1];
        




        // int low=0;
        // int high=nums.length-1;
        // while(low<high){
        //     int mid=(low+high)/2;
        //     if(mid>1 && mid<nums.length-1 && nums[mid]!=nums[mid-1] && nums[mid]!=nums[mid+1]) return nums[mid];
        //     if(nums[mid]==nums[mid-1] && mid-low+1%2!=0) {
        //         high=mid-2;
        //     }
        //     else if(nums[mid]==nums[mid-1] && high-mid+1%2!=0){
        //         low=mid+2;
        //     }
            
        // }
        // return 0;

        //most optimized
        int n = nums.length;
        if(n==1){
            return nums[0];
        }
        if(nums[0]!=nums[1]){
            return nums[0];
        }
        if(nums[n-1]!=nums[n-2]){
            return nums[n-1];
        }
        int s=1;
        int e=n-2;
        while(s<=e){
            int mid = s+(e-s)/2;
            if(nums[mid]!=nums[mid-1] && nums[mid]!=nums[mid+1]) return nums[mid];

            if(mid%2==1){
                if(nums[mid]==nums[mid-1]){
                    s=mid+1;
                }
                else if(nums[mid]==nums[mid+1]){
                    e=mid-1;
                }
            }
            else{
                if(nums[mid]==nums[mid+1]){
                    s=mid+2;
                }else if(nums[mid]==nums[mid-1]){
                    e=mid-2;
                }
            }
        }
        
        return -1;
        
    }
}
