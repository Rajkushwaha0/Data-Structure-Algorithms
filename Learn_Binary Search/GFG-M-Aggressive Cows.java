//O(log(max-min) * n )
//O(1)
class Solution {
    public int aggressiveCows(int[] stalls, int k) {
        // code here
        Arrays.sort(stalls);
        
        int[] maxMinValue = maxMinOfArray(stalls); 
        
        int s = 1;
        int e = maxMinValue[1]-maxMinValue[0];
        
        while(s<=e){
            int mid = s+(e-s)/2;
            
            if( placeCows(stalls,mid,k) ){
                s = mid+1;
            }else{
                e = mid-1;
            }
        }
        
        return e;
    }
    
    public boolean placeCows(int[] arr, int dist, int cows){
        
        cows-=1;
        
        int lastCow=arr[0];
        
        for(int i=1;i<arr.length;i++){
            if( arr[i]-lastCow >=dist ){
                cows--;
                lastCow=arr[i];
            }
            
            if(cows<=0) return true;
        }
        
        return cows<=0;
    }
    
    public int[] maxMinOfArray(int[] arr){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for(int i: arr){
            max = Math.max(max,i);
            min = Math.min(min,i);
        }
        
        return new int[]{min,max};
    }
}
