class Tree {
    int ans=Integer.MAX_VALUE;
    // Function to return the ceil of given number in BST.
    int findCeil(Node root, int key) {
       solve(root,key);
        // Code here
        if(ans==Integer.MAX_VALUE) return -1;
        return ans;
    }
    void solve(Node root,int x){
        if(root==null) return ;
        if(root.data>=x){
         ans=Math.min(ans,root.data) ;  
        }
        if(x>root.data){
            solve(root.right,x);
        }
        solve(root.left,x);
    }
}
