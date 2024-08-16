
class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
      //O(n)+O(n)+O(n) -> O(3n) -> O(n)
      //O(1)
        int currMax=Integer.MIN_VALUE;
        int currMin=Integer.MAX_VALUE;
        int max= Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int maxIndex=-1;
        int minIndex=-1;
        for(int i=0;i<arrays.size();i++){
            int n=arrays.get(i).size();
            currMax = arrays.get(i).get(n-1);
            if(currMax>max){
                max=currMax;
                maxIndex=i;
            }
            currMin = arrays.get(i).get(0);
            if(currMin<min){
                min=currMin;
                minIndex=i;
            }
        }
        if(maxIndex!=minIndex) return max-min;
        int prevMax=max;
        int prevMin=min;
        max= Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        for(int i=0;i<arrays.size();i++){
            currMin = arrays.get(i).get(0);
            if(currMin<min && i!=maxIndex){
                min=currMin;
            }
        }
        for(int i=0;i<arrays.size();i++){
            int n=arrays.get(i).size();
            currMax = arrays.get(i).get(n-1);
            if(currMax>max && i!=minIndex){
                max=currMax;
            }
        }
        return Math.max(prevMax-min,max-prevMin);
    }
}
