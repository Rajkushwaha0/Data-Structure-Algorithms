//O(N) + O(log(max(array)-sum(array)))
//O(1)
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int s = 1;
        int e = 0;
        for(int i=0;i<n;i++){
            e+=weights[i];
            s = Math.max(s, weights[i]);
        }
        while(s<=e){
            int mid = (s+e)/2;
            boolean minDays = maxLimit(weights,mid,days,n);
            if(minDays){
                e = mid-1;
            }else{
                s = mid+1;
            }
        }
        return s;
    }
    public boolean maxLimit(int[] weights,int sum,int days, int n){
        int rangeSum =0;
        int daysCount=1;
        for(int i=0;i<n;i++){
            if((rangeSum+weights[i])>sum){
                daysCount+=1;
                rangeSum = weights[i];
            }else{
                rangeSum+= weights[i];
            }
        }
        return daysCount<=days;
    }
}
