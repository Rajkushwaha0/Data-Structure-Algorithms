//Asked In Interview
//O(N)
//O(N)
class Solution {
    public int minOperations(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i:nums){
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        int ans=0;
        for(int i:hm.keySet()){
            int freq = hm.get(i);
            if(freq==1) return -1;
            
            ans+= freq/3;
            if(freq%3!=0){
                ans++;
            }

        }   
        return ans;
    }
}
