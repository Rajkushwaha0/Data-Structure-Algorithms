O(log N)
class Solution {
    long floorSqrt(long n) {
        // Your code here
        long s = 1;
        long e = n;
        long ans = n;
        while(s<=e){
            long mid = (s+e)/2;
            long square = mid*mid;
            // System.out.println(mid+" "+square+" ");
            if(square == n) return mid;
            if(square<n){
                ans=mid;
                s=mid+1;
            }else{
                e=mid-1;
            }
        }
        return ans;
    }
}
