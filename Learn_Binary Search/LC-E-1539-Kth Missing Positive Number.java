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
