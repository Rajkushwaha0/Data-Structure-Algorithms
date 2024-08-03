class Solution
{
    //Function to convert binary tree to doubly linked list and return it.
    List<Node> l = new ArrayList<>(); 
    Node bToDLL(Node root)
    {
	//  Your code here
    	inorder(root);
    // 	if(l.size()==1) return root;
    	Node newroot = l.get(0);
    	Node curr = newroot;
    	for(int i=1;i<l.size();i++){
    	    newroot.right=l.get(i);
    	    l.get(i).left=newroot;
    	    newroot=l.get(i);
    	}
    	newroot.right=null;
    	return curr;
    }
    void inorder(Node root){
        if(root==null) return ;
        inorder(root.left);
        l.add(root);
        inorder(root.right);
        return ;
    }
}
