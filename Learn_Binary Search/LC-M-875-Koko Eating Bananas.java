//O(N)+O(log(max(Array)))
//O(1)
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int e = maxValue(piles,n);

        int s = 1;
        while(s<=e){
            int mid = (s+e)/2;
            int requiredTime = requiredTimeForIthHour(piles,mid,n);
            if(requiredTime<=h){
                e = mid-1;
            }else{
                s = mid+1;
            }
        }

        return s;
    }
    public int requiredTimeForIthHour(int[] piles,int hour,int n){
        int hours = 0;
        for(int pile : piles){
            int div = pile / hour;
            hours += div;
            if(pile % hour != 0) hours++;
        }
        return hours;
    }
    public int maxValue(int[] piles,int n){
        int maxValue = 0;
        for(int i =0;i<n;i++){
            maxValue = Math.max(piles[i],maxValue);
        }
        return maxValue;
    }
}
