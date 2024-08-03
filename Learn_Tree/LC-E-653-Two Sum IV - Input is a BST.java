class Solution {
    boolean ans = false;
    public boolean findTarget(TreeNode root, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        dfs(root,k,hm);
        return ans;
    }
    public void bfs(TreeNode root,int k,HashMap<Integer,Integer> hm){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int n = q.size();
            for(int i=0;i<n;i++){
                TreeNode temp = q.poll();
                
                if(!hm.isEmpty() && hm.containsKey(k-temp.val)) {
                    ans=true;
                    return ;
                }
                hm.put(temp.val,1);
                if(temp.left!=null) {
                    q.add(temp.left);
                }
                if(temp.right!=null){
                    q.add(temp.right);
                }
            }
        }
        return ;
    }
    public void dfs(TreeNode root,int k,HashMap<Integer,Integer> hm){
        if(root==null) return ;
        if(hm.containsKey(k-root.val)){
            ans=true;
        }
        hm.put(root.val,1);
        dfs(root.left,k,hm);
        dfs(root.right,k,hm);
        return ;
    }

}
