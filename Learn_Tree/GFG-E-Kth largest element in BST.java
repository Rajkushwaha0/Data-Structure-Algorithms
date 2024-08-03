class Solution
{
    // return the Kth largest element in the given BST rooted at 'root'
    PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->a-b);
    public int kthLargest(Node root,int K)
    {
        //Your code here
        solve(root,K);
        return pq.poll();
        
    }
    public void solve(Node root,int k){
        if(root==null) return ;
        pq.offer(root.data);
        if(pq.size()>k){
            pq.poll();
        }
        solve(root.left,k);
        solve(root.right,k);
        return ;
    }
}
