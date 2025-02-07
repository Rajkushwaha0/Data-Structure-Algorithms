//O(n)
//O(limit+1) + O(number of distinct colors)
class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        HashMap<Integer,Integer> hm1 = new HashMap<>();
        HashMap<Integer,Integer> hm2 = new HashMap<>();
        int n = queries.length;
        int[] res = new int[n];
        for(int i =0;i<n;i++){
            int ball = queries[i][0];
            int color = queries[i][1];
            boolean ballPresent = hm1.containsKey(ball);
            boolean colorPresent = hm2.containsKey(color);
            if(ballPresent){
                int lastColor = hm1.get(ball);
                hm2.put(lastColor,hm2.get(lastColor)-1);
                if(hm2.get(lastColor)==0){
                    hm2.remove(lastColor);
                }
            }

            hm1.put(ball,color);
            hm2.put(color,hm2.getOrDefault(color,0)+1);
            res[i]=hm2.size();
        }
        return res;
    }
}
