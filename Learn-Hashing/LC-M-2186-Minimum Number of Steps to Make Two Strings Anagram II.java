class Solution {
    public int minSteps(String s, String t) {
        HashMap<Character,Integer> hm = new HashMap<>();
        HashMap<Character,Integer> hm1 = new HashMap<>();
        for(char ch : s.toCharArray()){
            hm.put(ch,hm.getOrDefault(ch,0)+1);
        }
        for(char ch : t.toCharArray()){
            hm1.put(ch,hm1.getOrDefault(ch,0)+1);
        }
        int ans = 0;
        for(char ch:hm.keySet()){
            if(!hm1.containsKey(ch)){
                ans+=hm.get(ch);
            }
            else{
                ans+=Math.abs(hm.get(ch)-hm1.get(ch));
                hm1.remove(ch);
            }
        }
        for(char ch:hm1.keySet()){
            if(!hm.containsKey(ch)){
                ans+=hm1.get(ch);
            }
        }
        return ans;
    }
}
