class Solution {
    int maxsum=0;
    int maxlvl=0;
    public int deepestLeavesSum(TreeNode root) {
        // Queue<TreeNode> q = new LinkedList<>();
        // q.add(root);
        // int ans=0;
        // while(!q.isEmpty()){
        //     int n=q.size();
        //     int sum=0;
        //     for(int i=0;i<n;i++){
        //         TreeNode curr = q.poll();
        //         sum+=curr.val;
        //         if(curr.left!=null) q.offer(curr.left);
        //         if(curr.right!=null) q.offer(curr.right);
        //     }
        //     ans=sum;
        // }
        // return ans;
        
        solve(root,0);
        return maxsum;
    }
    public void solve(TreeNode root,int lvl){
        if(root==null) {
            return ;
        }
        if(root.left==null && root.right==null){
            if(maxlvl<lvl){
                maxlvl=lvl;
                maxsum=root.val;
            }
            else if(maxlvl==lvl){
                maxsum+=root.val;
            }

        }

        solve(root.left,lvl+1);
        solve(root.right,lvl+1);
        return ;

    }
}
