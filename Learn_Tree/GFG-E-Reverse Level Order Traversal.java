class Tree
{
    ArrayList<Integer> l = new ArrayList<>();
    public ArrayList<Integer> reverseLevelOrder(Node node) 
    {
        solve(node);
        return l;
    }
    public void solve(Node node){
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        
        while(!q.isEmpty()){
            ArrayList<Integer> ll = new ArrayList<>();
            int n = q.size();
            for(int i =0;i<n;i++){
                Node temp = q.poll();
                ll.add(temp.data);
                if(temp.left!=null){
                    q.add(temp.left);
                }
                if(temp.right!=null){
                    q.add(temp.right);
                }
            }
            for(int j = ll.size()-1 ; j>=0 ; j--){
                l.add(0,ll.get(j));
            }
        }
    }
}      
