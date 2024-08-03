class Solution {
    List<Integer> l = new ArrayList<>();
    int count=0;
    public int goodNodes(TreeNode root) {
        // solve(root);
        optimized(root,Integer.MIN_VALUE);
        return count;
        
    }
    public void solve(TreeNode root){
        if(root==null) return ;
        l.add(root.val);
        solve(root.left);
        solve(root.right);
        boolean flag = true;
        for(int i=0;i<l.size()-1;i++){
            if(l.get(i)>root.val) {
                flag=false;
                break;
            }
        }
        if(flag==true) count++;
        l.remove(l.size()-1);
        
        return ;
    }
    public void optimized(TreeNode root,int max){
        if(root==null) return ;
        if(root.val>=max){
            max=root.val;
            count++;
        }
        optimized(root.left,max);
        optimized(root.right,max);
        return ;
    }
}
