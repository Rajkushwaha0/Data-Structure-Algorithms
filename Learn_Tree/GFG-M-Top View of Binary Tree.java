class Tuple{
    Node root;
    int first;
    int second;
    public Tuple(Node root,int first,int second){
        this.root=root;
        this.first=first;
        this.second=second;
    }
}
class Solution
{
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root)
    {
        // add your code
        Queue<Tuple> q = new LinkedList<>();
        TreeMap<Integer,Integer> hm = new TreeMap<>();
        Tuple tuple = new Tuple(root,0,0);
        q.offer(tuple);
        ArrayList<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
        while(!q.isEmpty()){
            Tuple temp = q.poll();
            Node node = temp.root;
            int hd = temp.first;
            int lvl = temp.second;
            if(!hm.containsKey(hd)){
                hm.put(hd,node.data);
            }
            
            
            
            if(node.left!=null){
                q.offer(new Tuple(node.left,hd-1,lvl+1));
            }
            if(node.right!=null){
                q.offer(new Tuple(node.right,hd+1,lvl+1));
            }
        }
        for (int h : hm.values()){
            
                ans.add(h);
        }
        return ans;
        
    }
}
