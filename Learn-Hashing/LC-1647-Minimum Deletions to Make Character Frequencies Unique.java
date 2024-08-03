class Solution {
    public int minDeletions(String s) {
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
        }
        int count=0;
        for(char ch : hm.keySet()){
            int prev = hm.get(ch);
            hm.put(ch,-1);
            int m = prev;
            while(hm.containsValue(m) && m!=0){
                count++;
                m--;
            }
            if(m!=0) hm.put(ch,m);
        }
        return count;
    }
}
