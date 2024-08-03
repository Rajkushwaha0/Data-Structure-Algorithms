class Solution
{   
    int count=-1;
    public int kthAncestor(Node root, int k, int node)
    {
        //Write your code here
        List<Integer> l = new ArrayList<>();
        inorder(root,k,l,node);
        return count;
    }
    
    
    public void inorder(Node root,int k,List<Integer> l,int node ){
        if(root==null){
            return ;
        }
        l.add(root.data);
        inorder(root.left,k,l,node);
        inorder(root.right,k,l,node);
        if(root.data==node && l.size()-1>=k){
            for(int i=l.size()-2;i>=0;i--){
                if(k==0) break;
                count=l.get(i);
                k--;
            }
            
        }
        l.remove(l.size()-1);
        return ;
    }
}
