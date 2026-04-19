//O(N) + O(log(min-max+1))
//O(1)
class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if(n < (m*k)) return -1;

        int[] maxminValues  = maxMinValue(bloomDay);
        int s = maxminValues[0];
        int e = maxminValues[1];

        int ans=Integer.MAX_VALUE;
        while(s<=e){
            int mid = s + (e-s)/2;

            if(bouquetsFlowerBloomed(bloomDay,m,k,mid)){
                ans = Math.min(ans,mid);
                e = mid-1;
            }else{
                s = mid+1;
            }
        }
        return ans!=Integer.MAX_VALUE ? ans : -1;
    }

    public boolean bouquetsFlowerBloomed(int[] bloomDay, int m, int k, int d){
        int countBloomedFlower = 0;

        for(int i : bloomDay){
            if(i > d){
                m -= (countBloomedFlower/k);
                countBloomedFlower = 0;
            }else{
                countBloomedFlower++;
            }
        }
        m -= (countBloomedFlower/k);
        return m<=0;
    }

    public int[] maxMinValue(int [] bloomDay){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for ( int i : bloomDay){
            min=Math.min(i,min);
            max=Math.max(i,max);
        }

        return new int[]{min,max};
    }
}
