//TC : O(LOG(MAX(candies) * n ))
//SC : O(1)
class Solution {
    public int maximumCandies(int[] candies, long k) {
        int s = 1;
        int e = maxMinValue(candies);

        while(s<=e){
            int mid = s + (e-s)/2;

            if(eachChildGotCandies(candies,k,mid)){
                s = mid+1;
            }else{
                e = mid-1;
            }
        }

        return e;
    }

    public int maxMinValue(int [] candies){
        int max = Integer.MIN_VALUE;

        for ( int i : candies){
            max=Math.max(i,max);
        }

        return max;
    }

    public boolean eachChildGotCandies(int[] candies, long k, int mid){
        long count = 0;
        for(int i : candies){
            int m = i/mid;
            count+=m;
            if(count>=k) return true;
        }

        return count>=k;
    }
}
