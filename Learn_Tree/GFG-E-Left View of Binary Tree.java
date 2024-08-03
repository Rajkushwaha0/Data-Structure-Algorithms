class Tree
{
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
      // Your code here
      ArrayList<Integer> ans = new ArrayList<Integer>();
      if(root==null) return ans;
      Queue<Node> q = new LinkedList<>();
      q.add(root);
      while(!q.isEmpty()){
          int an=-1;
          int n=q.size();
          for(int i=0;i<n;i++){
              Node temp = q.peek();
              if(temp.left!=null) q.add(temp.left);
              if(temp.right!=null) q.add(temp.right);
              if(an== -1){
                  an=q.peek().data;
              }
              q.poll();
          }
          ans.add(an);
      }
      return ans;
    }
}
