//O(N) + O(log(max(array)))
//O(1)
class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;

        int s = 1;
        int e = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            e = Math.max(e,nums[i]); 
        }

        while(s<=e){
            int mid = (s+e)/2;
            boolean minAns = bloomConsecutive(nums,mid,threshold,n);
            
            if(minAns==true){
                e=mid-1;
            }else{
                s=mid+1;
            }
        }
        return s;




    }

    public boolean bloomConsecutive(int[] nums,int limit,int k,int n){
        int totalcount = 0;
        
        for(int i=0;i<n;i++){
            int count = 0;
            count = nums[i]/limit;
            if(nums[i]%limit!=0){
                count++;
            }
            totalcount+=count;
        }

        return totalcount<=k;
    }
}
