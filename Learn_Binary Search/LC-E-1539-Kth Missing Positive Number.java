//O(LOG(N))
class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        int s = 0;
        int e = n-1;

        while(s<=e){
            int mid = s + (e-s)/2;

            int missing = arr[mid]-(mid+1);

            if(missing>=k){
                e=mid-1;
            }else{
                s=mid+1;
            }
        }

        return s+k; //e+1+k you know where this stopped s must be ahead of e and 
        // arr[e]+ more (k-missing)
        //arr[e]+ (k-(arr[e]-(e+1)))
        //arr[e]+k-arr[e]+e+1
        //k+e+1
    }
}

class Solution {
    public int findKthPositive(int[] arr, int k) {
        //BF
        // for(int i=0;i<arr.length;i++){
        //     if(arr[i]<=k) k++;
        //     else break;
        // }
        // return k;

        //optimized
        int n = arr.length;
        int s = 0;
        int e = n-1;
        while(s<=e){
            int mid = (s+e)/2;
            int missing = arr[mid]-(mid+1);
            if(missing<k){
                s=mid+1;
            }else{
                e=mid-1;
            }
        }
        //arr[e]+ (k-(arr[e]-e-1))
        return e+k+1;
    }
}
