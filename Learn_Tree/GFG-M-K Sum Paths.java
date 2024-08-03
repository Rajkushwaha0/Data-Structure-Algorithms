class Solution
{
   
    int count=0;
    public int sumK(Node root,int k)
    {
        
        // code here 
        
        List<Integer> l = new ArrayList<>();
        inorder(root,k,l);
        return count;
    }
    public void inorder(Node root,int k,List<Integer> l ){
        if(root==null){
            return ;
        }
        l.add(root.data);
        
        inorder(root.left,k,l);
        
        inorder(root.right,k,l);
        
        int sum=0;
        for(int i=l.size()-1;i>=0;i--){
            sum+=l.get(i);
            if(sum==k) {
                count++;
            }
        }
        l.remove(l.size()-1);
        return ;
    }
}
