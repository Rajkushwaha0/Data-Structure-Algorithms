class Solution {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        int m = (n*25)/100;
       HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i:arr){
           hm.put(i,hm.getOrDefault(i,0)+1);
        }
        for(int i :hm.keySet()){
            if(hm.get(i)>m) return i;
        }
        return -1;
    }
}
