class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map= new HashMap<>();
        
        for(int data: nums)
            map.put(data, map.getOrDefault(data, 0)+1);
        
        PriorityQueue<Map.Entry<Integer, Integer>> heap= new PriorityQueue<>((a, b)->{
            return (a.getValue() == b.getValue())? b.getKey() - a.getKey() : a.getValue() - b.getValue();
        });
        
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) 
            heap.offer(entry);
        
        int index= 0;
        while(heap.size() != 0)
        {
           Map.Entry<Integer, Integer> temp= heap.poll();
           int val= temp.getKey();
           int freq= temp.getValue();
           for(int i= 0; i< freq; i++) 
               nums[index+i]= val;
           index+= freq;
        }
        return nums;
        
    }
}
