We can do with any traversal technique

class Tree
{
    int countLeaves(Node node) 
    {
         // Your code  
         return levelorder(node);
    }
    
    public static int levelorder(Node root){
        int count=0;
        Queue<Node> q = new LinkedList<>();
            q.add(root);
            while(!q.isEmpty()){
                int level = q.size();
                for(int i=0;i<level;i++){
                    Node temp = q.poll();
                    if(temp.left== null && temp.right==null) count++;
                    if(temp.left!=null){
                        q.add(temp.left);
                    }
                    if(temp.right!=null){
                        q.add(temp.right);
                    }
                }

            }
            return count;
    }
    
    
    public static int preorder(Node root){
     if(root == null) return 0;
    int count=0;

    if(root.left == null && root.right== null) return 1;
    count+=preorder(root.left);
    count+=preorder(root.right);
    return count;
  }
}
