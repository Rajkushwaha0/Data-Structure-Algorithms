class Solution {
    int index;
    public TreeNode buildTree(int[] inorder, int[] postorder) { 
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            hm.put(inorder[i],i);
        }
        index=postorder.length-1;
        return solve(postorder, 0,postorder.length-1,hm);
    }
    public TreeNode solve(int[] postorder, int s , int e ,HashMap<Integer,Integer> hm){
        if(index<0 || s>e) return null;

        int data = postorder[index];
        index--;
        TreeNode node = new TreeNode(data);
        int position = hm.get(data);
        node.right = solve(postorder,position+1,e,hm);
        node.left = solve(postorder,s,position-1,hm);
        return node;
    }
}

