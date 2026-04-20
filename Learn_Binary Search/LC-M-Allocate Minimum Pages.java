//O(N * LOG (max(arr) - sum(arr)))
class Solution {
    public int findPages(int[] arr, int k) {
        // code here
        int n = arr.length;
        if(n<k) return -1;
        int s = arr[n-1];
        int e = sum(arr);
        
        int ans = Integer.MAX_VALUE;
        while(s<=e){
           int mid = s + (e-s)/2;
           
           int value = findAllocatedPages(arr,mid,k);
           
           if(value==-1){
               s = mid+1;
           }else{
               ans=Math.min(ans,value);
               e = mid-1;
           }
        }
        
        
        return ans!=Integer.MAX_VALUE ? ans : -1;
    }
    
    public int findAllocatedPages(int[] arr,int mid,int k){
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int allocatedTo = 0;
        for(int i=0;i<arr.length;i++){
            if((sum+arr[i])>mid){
                max=Math.max(max,sum);
                sum=arr[i];
                allocatedTo+=1;
            }
            else{
                sum+=arr[i];
            }
            
            if(allocatedTo>k) return -1;
            
        }
        
        max=Math.max(max,sum);
        allocatedTo+=1;
        
        if(allocatedTo>k) return -1;
        
        
        return max;
        
    }
    
    public int sum(int[] arr){
        int sum=0;
        for(int i : arr) sum+=i;
        
        return sum;
    }
}
