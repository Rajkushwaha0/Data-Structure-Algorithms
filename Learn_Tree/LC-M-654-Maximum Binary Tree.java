class Solution {
    public int m(int[] nums,int s,int e){
        int max = Integer.MIN_VALUE;
        for(int i=s;i<=e;i++){
            max=Math.max(max,nums[i]);
        }
        return max;
    }
    public int find(int[] nums,int max , int s,int e){
        int ans = 0;
        for(int i=s;i<=e;i++){
            if(max==nums[i]) {
                ans = i;
                break;
            }
        }
        return ans;
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int n = nums.length;
        return solve(nums,0,n-1);
    }
    public TreeNode solve(int[] nums , int s , int e){
        if(s>e) return null;

        int max = m(nums,s,e);
        TreeNode root = new TreeNode(max);
        int index = find(nums,max,s,e);
        

        root.left = solve(nums,s,index-1);
        root.right = solve(nums,index+1,e);
        return root;
    }
}
