//BruteForce
class Solution {
    public int index (int[] inorder,int target){
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==target) return i;
        }
        return -1;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n=inorder.length;
        return solve(preorder,inorder,0,n-1);
        
    }
    int index=0;
    public TreeNode solve(int[] preorder , int[] inorder  , int s , int e){
        if(s>e){
            return null;
        }

        int data = preorder[index++];
        TreeNode root = new TreeNode(data);
        int position = index(inorder,data);

        root.left=solve(preorder,inorder,s,position-1);
        root.right=solve(preorder,inorder,position+1,e);
        return root;


    }
}



//Using MAP more optimize
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        if(n!=inorder.length) return null;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(inorder[i],i);
        }
        return solve(preorder,0,n-1,map,n);
    }
    int i=0;
    public TreeNode solve(int[] pre , int start , int end, HashMap<Integer,Integer>map,int n){
        if(start>end || i>=n){
            return null;
        }
        int data = pre[i++];
        int position = map.get(data);
        TreeNode root = new TreeNode(data);

        root.left = solve(pre,start,position-1,map,n);
        root.right = solve(pre,position+1,end,map,n);
        return root;
    }
}
