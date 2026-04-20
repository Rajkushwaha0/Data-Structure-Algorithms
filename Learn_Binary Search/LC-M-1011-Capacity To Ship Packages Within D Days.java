//O(N) + O(log(max(array)-sum(array)))
//O(1)
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int[] sumMinArray = sumOfArray(weights);
        int s = sumMinArray[0];
        int e = sumMinArray[1];

        while(s<=e){
            int mid = s + (e-s)/2;

            if( weightLoadedforShipment(weights,days,mid) ){
                e = mid-1;
            }else{
                s = mid+1;
            }
        }

        return s;
    }

    public boolean weightLoadedforShipment(int[] weights,int days, int mid){
        int totalDaysUsed = 1;
        int sum = 0;
        System.out.println(" ");
        for(int i : weights){
            
            if((sum+i)>mid){
                totalDaysUsed+=1;
                sum=i;
            }else{
                sum+=i;
            }
            // System.out.println("mid: "+mid+" sum: "+(sum)+" => "+totalDaysUsed);
            if(totalDaysUsed>days){
                return false;
            }
        }

        return totalDaysUsed<=days;
    }

    public int[] sumOfArray(int[] weights){
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int i: weights){
            sum+=i;
            max=Math.max(max,i);
        }

        return new int[]{max,sum};
    }
}
