class Solution {
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> l = new ArrayList<>();
        inorder(root,l);
        // System.out.print(l);
        int s=0;
        int e = l.size()-1;
        return solve(l,s,e);
    
    }
    public void inorder(TreeNode root,ArrayList<Integer> l){
        if(root == null) return ;

        inorder(root.left,l);
        l.add(root.val);
        inorder(root.right,l);
        return ;
    }
    public TreeNode solve(ArrayList<Integer> l,int s,int e){
        if(s>e) return null;
        int m=(s+e)/2;
        int value = l.get(m);
        TreeNode node = new TreeNode(value);
        node.left = solve(l,s,m-1);
        node.right = solve(l,m+1,e);
        return node;
    }
}

// TC --> O(N)
// SC --> O(N)
