//O(N) + O(log(min-max+1))
//O(1)
class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if(n < (m*k)) return -1;

        int s = Integer.MAX_VALUE;
        int e = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            s = Math.min(s,bloomDay[i]);
            e = Math.max(e,bloomDay[i]); 
        }

        int ans=Integer.MAX_VALUE;
        while(s<=e){
            int mid = (s+e)/2;
            boolean minAns = bloomConsecutive(bloomDay,mid,m,k,n);
            
            if(minAns==true){
                ans=Math.min(ans,mid);
                e=mid-1;
            }else{
                s=mid+1;
            }
        }
        return ans==Integer.MAX_VALUE?-1:ans;




    }

    public boolean bloomConsecutive(int[] bloomDay,int limit,int m,int k,int n){
        int count = 0;
        int totalAns = 0;

        for(int i=0;i<n;i++){
            if(bloomDay[i]>limit){
                totalAns += count/k;
                count = 0;
            }else{
                count++;
            }
        }
        totalAns += count/k;
        return totalAns>=m;
    }
}
