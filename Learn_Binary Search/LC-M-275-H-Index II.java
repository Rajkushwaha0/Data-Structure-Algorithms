//O(log (n))
class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int s = 0;
        int e = n-1;
        int ans = 0;
        while(s<=e){
            int mid = s + (e-s)/2;

            if(citations[mid]>=n-mid){  //if mid aage ke aage ki length incliding mid >= citations[mid] then iska mtlb wo answer hai.
                ans = n-mid;
                e = mid-1;
            }else{
                s = mid+1;
            }
        }

        return ans;
    }

}
