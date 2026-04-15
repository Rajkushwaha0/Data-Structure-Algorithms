// tc: O(log n)
//sc: O(1)
class Solution {
    public int findKRotation(int arr[]) {
        // Code here
        int n = arr.length;
        int s = 0;
        int e = n-1;
            
        int ans = Integer.MAX_VALUE;
        int value = Integer.MAX_VALUE;
        while(s<=e){
            int mid = s + (e-s)/2;
            
            // if(arr[s]<=arr[mid] && arr[mid]<=arr[e]){
            //   if(arr[s]<=value){
            //     ans = s;
            //     value=arr[s];
            //   }
            //   break;
            // }
            
            if(arr[mid]<=arr[e]){
                if(arr[mid]<value){
                    ans = mid;
                    value = arr[mid];
                }
                e = mid-1;
            }
            
            if(arr[s]<=arr[mid]){
                if(arr[s]<value){
                    ans = s;
                    value = arr[s];
                }
                s = mid+1;
            }
            
        }
        
        return ans;
    }
}
