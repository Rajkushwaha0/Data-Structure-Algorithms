class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int n = q.size();
            int m = Integer.MIN_VALUE;
            for(int i=0;i<n;i++){
                TreeNode tmp = q.poll();
                m=Math.max(tmp.val,m);
                if(tmp.left!=null){
                    q.add(tmp.left);
                }
                if(tmp.right!=null){
                    q.add(tmp.right);
                }
            }
            ans.add(m);
        }
        return ans;
    }
}
