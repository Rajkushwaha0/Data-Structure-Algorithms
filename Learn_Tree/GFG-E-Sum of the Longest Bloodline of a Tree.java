class Solution{
    public int ans = Integer.MIN_VALUE;
    public int maxLen=0;
    public int sumOfLongRootToLeafPath(Node root)
    {
        //code here
        int sum=0;
        int len=0;
        solve(root,sum,len);
        return ans;
    }
    public void solve(Node node , int sum , int len){
        if(node==null){
            if(len>maxLen){
                ans=sum;
                maxLen=len;
            }
            else if(len==maxLen && ans<sum){
                ans=Math.max(sum,ans);
            }
            return ;
        }
        sum=sum+node.data;
        solve(node.left,sum,len+1);
        solve(node.right,sum,len+1);
        return ;
    }
    
}
