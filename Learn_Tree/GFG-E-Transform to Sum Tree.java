class Solution{
    public void toSumTree(Node root){
         //add code here.
         solve(root);
         
         
    }
    public int solve(Node root){
        if(root==null) return 0;
        if(root.left==null && root.right==null){
            int m = root.data;
            root.data=0;
            return m;
        }
        
        int left = solve(root.left);
        int right = solve(root.right);
        
        
        int m = root.data+left+right;
        root.data=left+right;
        return m;
    }
}
