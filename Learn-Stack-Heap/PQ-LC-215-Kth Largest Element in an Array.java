//Using PQ
//TC - O(nLogk)
//SC - O(K)
//quick select
//TC - O(N)
//SC - (1)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        // PriorityQueue<Integer> pq = new PriorityQueue<>();
        // for(int i:nums){
        //     pq.offer(i);
        //     if(pq.size()>k){
        //         pq.poll();
        //     }
        // }
        // return !pq.isEmpty() ? pq.poll() : -1;

        int target = nums.length - k;
        return quickselect(nums, 0, nums.length - 1, target);
    }

    public int quickselect(int[] nums, int left, int right, int k) {
        if (left == right) return nums[left];

        int pivotIndex = partition(nums, left, right);

        if (pivotIndex == k) {
            return nums[pivotIndex];
        } else if (pivotIndex < k) {
            return quickselect(nums, pivotIndex + 1, right, k);
        } else {
            return quickselect(nums, left, pivotIndex - 1, k); 
        }
    }

    public int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int i = left;

        for (int j = left; j < right; j++) {
            if (nums[j] <= pivot) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
            }
        }

        int tmp = nums[i];
        nums[i] = nums[right];
        nums[right] = tmp;

        return i;
    }
}
