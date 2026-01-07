//TC O(N)+O(N)
//SC O(H)+O(H)
class Solution {
    static final int MOD = 1000000007;
    public long ans = 0;
    public int maxProduct(TreeNode root) {
        long totalSum = findTotalSum(root);
        splitTreeProduct(root,totalSum);
        return (int)(ans % MOD);
    }

    public long findTotalSum(TreeNode root){
        if(root==null){
            return 0;
        }

        long left = findTotalSum(root.left);
        long right = findTotalSum(root.right);

        return (left+right+root.val);
    }

    public long splitTreeProduct(TreeNode root,long totalSum){
        if(root==null){
            return 0;
        }

        long left = splitTreeProduct(root.left,totalSum);
        long right = splitTreeProduct(root.right,totalSum);

        long sumOfSubTree = (left+right+root.val);
        long multipleValue = (sumOfSubTree*(totalSum-sumOfSubTree));

        ans = Math.max(ans,multipleValue);

        return sumOfSubTree;
    }
}
