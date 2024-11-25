class Solution {
    public int nthRoot(int n, int m) {
        // code here
        if(n==1) return m;
        if(m==1) return 1;
        int s=1;
        int e=m/2;
        while(s<=e){
            int mid = (s+e)/2;
            // int num = mul(n,mid);
            // int num = mulOptimized(n,mid);
            int num = mul(n,mid,m);
            if(num==1) return mid;
            if(num==2) e=mid-1;
            else s=mid+1;
        }
        return -1;
        
    }
    public long mulOptimized(int n,int mid){  //O(log n * log m/2)
        //But has integer overflow problem 
        long ans=1;
        while(n>0){
            if(n%2==1){
                ans = ans*mid;
                n=n-1;
            }else{
                mid =mid*mid;
                n=n/2;
            }
        }
        return ans;
    }
    public int mul(int n,int i,int m){  //O(n*log m/2)
        int ans=1;
        for(int j=0;j<n;j++){
            ans*=i;
            if(ans>m) return 2;
        }
        if(ans==m) return 1;
        return 0;
    }
}
