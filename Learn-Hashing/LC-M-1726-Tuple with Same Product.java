//O(n^2)
//O(n^2)
class Solution {
    public int tupleSameProduct(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int ans = 0;
        int n = nums.length;
        for (int i = 0; i < n ; i++)
            for (int j = i+1; j < n ; j++) {
                int product = nums[i] * nums[j];
                ans += 8 * hm.getOrDefault(product, 0);
                hm.put(product, hm.getOrDefault(product, 0) + 1);
            }
        return ans;
    }
}
