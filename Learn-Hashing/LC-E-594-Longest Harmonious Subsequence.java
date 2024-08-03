class Solution {
    public int findLHS(int[] nums) {
        Map<Integer,Integer> hm = new HashMap<>();
        int ans = 0;
        for(int i:nums){
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        for(int i : hm.keySet()){
            if(hm.containsKey(i+1)){
                ans=Math.max(ans,(hm.get(i)+hm.get(i+1)));
            }
        }
        return ans;
    }
}
