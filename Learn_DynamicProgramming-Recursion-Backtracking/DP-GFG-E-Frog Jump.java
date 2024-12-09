Link:  https://www.codingninjas.com/codestudio/problems/frog-jump_3621012?leftPanelTab=1
class Solution{
    public int minimumEnergy(int arr[],int n){
        //code here 
        // return recursion(arr,n-1); // O(2^N) O(N)
        // int[] dp = new int[n+1];
        // Arrays.fill(dp,-1);
        // return memo(arr,n-1,dp); //O(N) //O(N)+O(N)
        // return tabulation(arr,n); //O(N) O(N)
        return space(arr,n); //O(N) O(1)
        
    }
    public int memo(int[] arr, int n,int[] dp){
        if(n==0){
            return 0;
        }
        if(dp[n]!=-1) return dp[n];
        int secondJump=Integer.MAX_VALUE;
        int firstJump = memo(arr,n-1,dp)+Math.abs(arr[n]-arr[n-1]);
        if(n>1){
         secondJump = memo(arr,n-2,dp)+Math.abs(arr[n]-arr[n-2]);   
        }
        
        return dp[n]= Math.min(firstJump,secondJump);
    }
    public int recursion(int[] arr,int n){
        if(n==0){
            return 0;
        }
        int secondJump=Integer.MAX_VALUE;
        int firstJump = recursion(arr,n-1)+Math.abs(arr[n]-arr[n-1]);
        if(n>1){
         secondJump = recursion(arr,n-2)+Math.abs(arr[n]-arr[n-2]);   
        }
        return Math.min(firstJump,secondJump);
    }
    public int tabulation(int[] arr,int n){
        int[] dp = new int[n];
        for(int i=1;i<n;i++){
            int firstJump = dp[i-1]+Math.abs(arr[i]-arr[i-1]);
            int secondJump = Integer.MAX_VALUE;
            if(i>1){
                secondJump = dp[i-2]+Math.abs(arr[i]-arr[i-2]);
            }
            dp[i]=Math.min(firstJump,secondJump);
        }
        return dp[n-1];
    }
    public int space(int[] arr,int n){
        int prev1 = 0;
        int prev2 = 0;
        int curr = 0;
        
        for(int i=1;i<n;i++){
            int firstJump = prev1+Math.abs(arr[i]-arr[i-1]);
            int secondJump = Integer.MAX_VALUE;
            if(i>1){
                secondJump = prev2+Math.abs(arr[i]-arr[i-2]);
            }
            curr = Math.min(firstJump,secondJump);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}
