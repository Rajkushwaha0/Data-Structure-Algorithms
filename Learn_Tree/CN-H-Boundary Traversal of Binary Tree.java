import java.util.* ;
import java.io.*; 
/************************************************************

    Following is the Binary Tree node structure:
    
   class TreeNode {
	    int data;
	    TreeNode left;
	    TreeNode right;

	    TreeNode(int data) {
		    this.data = data;
		    this.left = null;
		    this.right = null;
	    }

    }

************************************************************/

import java.util.ArrayList;

public class Solution {
	public static ArrayList<Integer> ans = new ArrayList<>();
	public static  ArrayList<Integer> traverseBoundary(TreeNode node){
		// Write your code here.
		if(node==null){
	        return ans;
	    }
		ans=new ArrayList<>();
	    ans.add(node.data);
	    leftalgo(node.left);
	    leafalgo(node.left);
	    leafalgo(node.right);
	    rightalgo(node.right);
	    return ans;
	}

	public static void leafalgo(TreeNode root){
	    if(root==null) return ;
	    if(root.left==null && root.right==null){
	        ans.add(root.data);
	        return ;
	    }
	    leafalgo(root.left);
	    leafalgo(root.right);
	}
	public static void leftalgo(TreeNode root){
	    if(root==null) return ;
	   if(root.left==null && root.right==null) return ;
	    
	    ans.add(root.data);
	    if(root.left!=null){
	        leftalgo(root.left);
	    }
	    else{
	        leftalgo(root.right);   
	    }
	}
	public static void rightalgo(TreeNode root){
	    if(root == null) return ;
	    if(root.left==null && root.right==null) return ;
	    
	    if(root.right!=null){
	        rightalgo(root.right);
	    }
	    else{
	        rightalgo(root.left);
	    }
	    
	    ans.add(root.data);

	}
}
