class Solution {
    ArrayList<Integer> l = new ArrayList<>();
    public int findSecondMinimumValue(TreeNode root) {
        
        inorder(root);
        if(l.size()<2) return -1;
        Collections.sort(l);
        

        
        
        return l.get(1);
        
        
    }
    public void inorder(TreeNode root){
        if(root==null) return ;
        inorder(root.left);
        if(!l.contains(root.val)) l.add(root.val);
        inorder(root.right);
        return ;
    }

}
