class Solution {
    public int minTime(int[] arr, int k) {
        // code here
        
        return splitArray(arr,k);
    }
    
    public int splitArray(int[] nums, int k) {
        int[] maxSumValue = maxSumArray(nums);

        int s = maxSumValue[0];
        int e = maxSumValue[1];
        int ans = Integer.MAX_VALUE;
        while(s<=e){
            int mid = s + (e-s)/2;

            int value = findSplit(nums,mid,k);
            if (value==-1){
                s = mid+1;
            }else{
                ans = Math.min(ans,value);
                e = mid-1;
            }
            
        }
        return ans;
    }

    public int findSplit(int[] nums,int mid,int k){
        int sum = 0;
        int splittedInto = 0;
        int max = -100;
        for(int i:nums){
            if(sum+i>mid){
                splittedInto++;
                max = Math.max(max,sum);
                sum=i;
            }else{
                sum+=i;
            }

            if(splittedInto>k) return -1;
        }


        max = Math.max(max,sum);
        splittedInto++;
        if(splittedInto>k) return -1;

        return max;

    }

    public int[] maxSumArray(int[] nums){
        int sum = 0;
        int max = -1;

        for(int i: nums){
            sum+=i;
            max=Math.max(max,i);
        }

        return new int[]{max,sum};
    }
}
