class Solution {
    public int minDifference(int[] nums) {
        if(nums.length<=4) return 0;
        Arrays.sort(nums);
        int n=nums.length;
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<4;i++){
            ans=Math.min(ans,nums[n-4+i]-nums[i]);
        }
        return ans;
    }
}

// got some help from here 
//https://leetcode.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves/solutions/730567/java-c-python-straight-forward
