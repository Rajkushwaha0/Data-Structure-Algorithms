class Solution {
    public int findBottomLeftValue(TreeNode root) {
        if(root==null) return 0;
        if(root.left==null && root.right==null) return root.val;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int left=0;
        int ans=root.val;
        while(!q.isEmpty()){
            int n=q.size();
            left = -1;
            for(int i=0;i<n;i++){
                TreeNode m=q.poll();
                if(m.left!=null){
                    q.add(m.left);
                    if(left == -1 ) {
                        ans =  m.left.val;
                        left = m.left.val;
                    }
                }
                if(m.right!=null){
                    q.add(m.right);
                    if(left == -1 && m.left==null) {
                        ans =  m.right.val;
                        left = m.right.val;
                    }
                }
            }

        }   
        return ans;
    }
}
