//O(N log(N))
//O(N)
class Solution {
    public int minOperations(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Long> pq = new PriorityQueue();
        for(int i:nums){
            pq.offer((long)i);
        }
        int count = 0;
        while(n>1 && pq.peek()<k){
            long a = pq.poll();
            long b = pq.poll();
            long newValue = ((a*2)+b);
            pq.offer(newValue);
            count++;
            n = pq.size();
        }

        return count;

    }
}

// can be optimized while inserting only less than k values 
// which makes it O(N log K)
