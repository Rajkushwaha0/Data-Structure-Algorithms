class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        
        int s = 1;
        int e = maxValue(citations);

        while(s<=e){
            int mid = s + (e-s)/2;

            if(isHIndex(citations,mid)){
                s = mid+1;
            }else{
                e = mid-1;
            }
        }

        return e;
    }

    public boolean isHIndex(int[] citations, int mid){
        int count = 0;
        for(int i: citations){
            if(i>=mid) count++;
        }

        return count>=mid;
    }

    public int maxValue(int[] citations){
        int max = Integer.MIN_VALUE;

        for(int i: citations){
            max = Math.max(max,i);
        }

        return max;
    }
}
