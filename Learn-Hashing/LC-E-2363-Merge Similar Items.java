class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        TreeMap<Integer,Integer> hm = new TreeMap<>();
        for(int i=0;i<items1.length;i++){
            hm.put(items1[i][0],hm.getOrDefault(items1[i][0],0)+items1[i][1]);
        }
        for(int i=0;i<items2.length;i++){
            hm.put(items2[i][0],hm.getOrDefault(items2[i][0],0)+items2[i][1]);
        }
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        for(int i:hm.keySet()){
            l.add(i);
            l.add(hm.get(i));
            ans.add(l);
            l = new ArrayList<>();
        }
        return ans;
    }
}
