class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashSet<Integer> hm = new HashSet<>();
        int ws=0;
        int ans = Integer.MIN_VALUE;
        int sum=0;
        for(int we=0;we<nums.length;we++){
            while(hm.contains(nums[we])){
                hm.remove(nums[ws]);
                sum-=nums[ws];
                ws++;
            }
            hm.add(nums[we]);
            sum+=nums[we];
            ans=Math.max(ans,sum);
            
            
        }
        return ans;
    }
}
