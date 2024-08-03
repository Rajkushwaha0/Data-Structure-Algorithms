/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode createBinaryTree(int[][] description) {
        TreeNode root = null;
        HashMap<Integer,TreeNode> hm = new HashMap<>();
        HashSet<Integer> l = new  HashSet<>();
        int parent = -1;
        int child = -1;
        int isLeft=0;
        TreeNode p=null;
        TreeNode c=null;
        for(int i=0;i<description.length;i++){
            isLeft = description[i][2];
            parent  = description[i][0];
            child = description[i][1];
            if(hm.containsKey(parent)){
                p=hm.get(parent);
            }
            else{
                p=new TreeNode(parent);
                hm.put(parent,p);
            }
            if(hm.containsKey(child)){
                c=hm.get(child);
            }
            else{
                c=new TreeNode(child);
                hm.put(child,c);
            }
            if(isLeft == 1){
                p.left=c;
            }
            else{
                p.right=c;
            }
            l.add(child);
            
        }
        for(int i:hm.keySet()){
            if(!l.contains(i)){
                return hm.get(i);
            }
        }
        return null;
    }
}
