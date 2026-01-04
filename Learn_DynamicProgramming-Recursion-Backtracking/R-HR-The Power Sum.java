//TC O(2^ SQRT(X))
//SC O(SQRT(X))
class Result {
    public static int powerSum(int X, int N) {
        double range_limit = Math.sqrt(X);
        int ans = solve(X,N, 1,range_limit);
        return ans;
    }
    
    public static int solve(double x,double n,double i, double range_limit){
        if(x==0){
            return 1;
        }
        
        if(i>range_limit){
            return 0;
        }
        
        double powered = Math.pow(i,n);
        if(powered>x){
            return 0;
        }
        
        int taken = solve(x-powered,n,i+1,range_limit);
        int not_taken = solve(x,n,i+1,range_limit);
        
        return taken+not_taken;
    }
}
