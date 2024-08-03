import java.util.* ;
import java.io.*; 
/*

    Following is the TreeNode class structure for referance:

    class TreeNode<T> {
        public T data;
        public TreeNode<T> left;
        public TreeNode<T> right;

        TreeNode(T data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

*/

import java.util.ArrayList;

public class Solution{
    static ArrayList<Integer> l ;
    public static ArrayList<Integer> ancestorsInBinaryTree(TreeNode<Integer> root, int k){
        // Write your code here.
        l=new ArrayList<>();
        solve(root,k);
        if(l.size()==0){
            l.add(-1);
            return l;
        }
        return l;
    }
    public static Boolean solve(TreeNode<Integer> root, int k){
        if(root==null) return false;
        if(root.data==k){
            return true;
        }

        l.add(0,root.data);
        Boolean left=solve(root.left, k);
        Boolean right = solve(root.right,k);
       
        if(left==true || right==true){
            return true;
        }
        if(left==false && right == false) {
            l.remove(0);
            return false;
        }
        return false;
    }
}
