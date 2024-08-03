 class Pair{
     TreeNode node;
     int index;
     public Pair(TreeNode n,int i){
         node=n;
         index=i;
     }
 }
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0));
        int ans=0;
        while(!q.isEmpty()){
            int n=q.size();
            int min=Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for(int i=0;i<n;i++){
                Pair p = q.poll();
                TreeNode temp = p.node;
                int j = p.index;
                min=Math.min(min,j);
                max=Math.max(max,j);
                j=j-min; //To make overflow control optimizes more
                if(temp.left!=null){
                    q.add(new Pair(temp.left,((2*j)+1)));
                }
                if(temp.right!=null){
                    q.add(new Pair(temp.right,((2*j)+2)));
                }
            }
            ans=Math.max(ans,(max-min+1));
        }
        return ans;
    }
}
