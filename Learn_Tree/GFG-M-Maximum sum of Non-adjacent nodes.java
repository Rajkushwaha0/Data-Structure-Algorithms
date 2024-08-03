class Pair{
    int getKey;  //Include
    int getValue; //Exclude
    public Pair(int a,int b){
        this.getKey=a;
        this.getValue=b;
    }
} 
class Solution
{
    //Function to return the maximum sum of non-adjacent nodes.
    
        
    static int getMaxSum(Node root)
    {
        // add your code here
        Pair ans = solve(root);
        return Math.max(ans.getKey,ans.getValue);
    }
    public static Pair solve(Node root){
        if(root==null) {
            return new Pair(0,0);
        }
        
        Pair left = solve(root.left);
        Pair right = solve(root.right);
        
        
        int n = Math.max(left.getKey,left.getValue);
        int m = Math.max(right.getKey,right.getValue);
        return new Pair(root.data+left.getValue+right.getValue,n+m);                        
    }
}
