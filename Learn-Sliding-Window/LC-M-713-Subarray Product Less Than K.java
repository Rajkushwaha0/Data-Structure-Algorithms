class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k==1) return 0;
        int ws=0;
        int count=0;
        int pro=1;
        for(int we=0;we<nums.length;we++){
            pro*=nums[we];
            while(ws<nums.length && pro>=k){
                pro=pro/nums[ws];
                ws++;
            }
            if(pro<k){
                count+=(we-ws+1);
                
            }
        }
        return count;
    }
}
