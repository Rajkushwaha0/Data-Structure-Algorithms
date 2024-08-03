class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n=nums.length;
        int[] prefixSum =new int[n];
        HashMap<Integer,Integer> hm = new HashMap<>();
        int count=0;
        for(int i=0;i<n;i++){
            if(i>0){
                prefixSum[i]=prefixSum[i-1]+nums[i];
                if(prefixSum[i]==goal) count++;
                if(hm.containsKey(prefixSum[i]-goal)) count+=hm.get(prefixSum[i]-goal);
                hm.put(prefixSum[i],hm.getOrDefault(prefixSum[i],0)+1);
                
            }
            else{
                prefixSum[i]=nums[i];
                if(prefixSum[i]==goal) count++;
                hm.put(prefixSum[i],hm.getOrDefault(prefixSum[i],0)+1);
                
            }
        }

        // for(int k:hm.keySet()){
        //     if(hm.containsKey(k-goal)){
        //         count+=hm.get(k-goal);
        //     }
        // }
        
        
        return count;


    }
}
