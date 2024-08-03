class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permute(nums,0,result);
        return result;
    }
    public static void permute(int[] nums , int start , List<List<Integer>> result){
		if(start==nums.length-1){
           List < Integer > ds = new ArrayList < > ();
            for (int i = 0; i < nums.length; i++) {
                ds.add(nums[i]);
            }
            result.add(ds);
		}
		for(int i=start;i<nums.length;i++){
			swap(nums,i,start);
			permute(nums,start+1,result);
			swap(nums,i,start);
		}
	}
    public static void swap(int[] nums, int i, int j ){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
