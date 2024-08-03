class Solution {
    public int countNicePairs(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int ans=0;
        int mod = 1000000007; 
        for(int i = 0;i<nums.length;i++){
            int  n = rev(nums[i]);
            int a = hm.getOrDefault(nums[i]-n,0);
            ans = (ans + a)%mod;
            hm.put(nums[i]-n,a+1);
        }
        return ans%mod;
        
    }
    public int rev(int n){
        String s1 = Integer.toString(n);
        StringBuilder s = new StringBuilder(s1);
        s.reverse();
        return Integer.parseInt(s.toString());
    }
}
