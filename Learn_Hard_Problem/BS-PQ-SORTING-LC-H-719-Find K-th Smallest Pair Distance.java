class Solution {
    //Brute Force
    // public int smallestDistancePair(int[] nums, int k) {
    //     //O(n2 * log(k))
    //     //O(k)
    //     PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
    //     for(int i=0;i<nums.length-1;i++){
    //         for(int j=i+1;j<nums.length;j++){
    //             pq.add(Math.abs(nums[i]-nums[j]));
    //             if(pq.size()>k){
    //                 pq.poll();
    //             }
    //         }
    //     }
    //     return pq.poll();
    // }

    //Observation -> Simulation
    // public int smallestDistancePair(int[] nums, int k) {
           //O(n+ n^2 + max element)
           //O(max element)
    //     int min=Integer.MAX_VALUE;
    //     int max=Integer.MIN_VALUE;
    //     for(int i:nums){
    //         min=Math.min(min,i);
    //         max=Math.max(max,i);
    //     }
    //     // System.out.print(Math.abs(max-min));
    //     int[] d = new int[Math.abs(max-min)+1];
    //     for(int i=0;i<nums.length-1;i++){
    //         for(int j=i+1;j<nums.length;j++){
    //             d[Math.abs(nums[i]-nums[j])]+=1;
    //         }
    //     }
    //     int ans=0;
    //     for(int i=0;i<d.length;i++){
    //         if(d[i]==0) continue;
    //         k-=d[i];
    //         if(k<=0) return i;
    //     }
    //     return -1;
    // }

    public int smallestDistancePair(int[] nums, int k) {
        //O(nlogn + nlog(max distance))
        //O(1)
        Arrays.sort(nums);
        int n=nums.length;
        int low = 0;
        int high = nums[n-1]-nums[0];
        int result=0;
        while(low<=high){
            int mid = low+ (high-low)/2;
            int count = countPair(nums,mid);
            if(count < k) {
                low=mid+1;
            }else{
                result = mid;
                high=mid-1;
            }
        }
        return result;
    }
    public int countPair(int[] nums,int mid){
        int i=0;
        int n=nums.length;
        int paircount=0;
        for(int j=1;j<n;j++){
            while(nums[j]-nums[i]>mid){
                i++;
            }
            paircount+= (j-i);
        }
        return paircount;
    }
}


//https://leetcode.com/problems/find-k-th-smallest-pair-distance/solutions/5632765/o-n-log-n-n-log-w-binary-search-sliding-window-java-c-python-go-rust-javascript/?envType=daily-question&envId=2024-08-14
