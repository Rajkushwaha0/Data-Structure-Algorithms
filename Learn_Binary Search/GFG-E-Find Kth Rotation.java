O(log N)
O(1)
class Solution {
    public int findKRotation(List<Integer> arr) {
        // Code here
        int s=0;
        int e=arr.size()-1;
        int ans = Integer.MAX_VALUE;   //this track for minimum value
        int index = 0;  //this track for index which has small value
        while(s<=e){
            int mid = (s+e)/2;
            int start = arr.get(s);
            int midValue = arr.get(mid);
            int end = arr.get(e);

          //this checks for wheather we have found the unsorted one not
            if(start<=end){
                if(start<ans){
                    ans=start;
                    index=s;
                }
                break;
            }
            
            //eliminates left sorted
            if(start<=midValue){
                if(start<ans){
                    index = s;
                    ans=start;
                }
                s=mid+1;
            }
            //eliminates right sorted
            else if(midValue<=end){
                if(midValue<ans){
                    index=mid;
                    ans=midValue;
                }
                e=mid-1;
            }
        }
        return index;
    }
}
