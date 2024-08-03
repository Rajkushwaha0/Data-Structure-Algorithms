class Pair{
    int index ;
    int freq;
    public Pair(int index,int freq){
        this.index=index;
        this.freq=freq;

    }
}
class Solution {
    public int firstUniqChar(String s) {
        int min=Integer.MAX_VALUE;
        HashMap<Character,Pair>hm = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(!hm.containsKey(ch)){
                hm.put(ch,new Pair(i,1));
            }
            else{
                Pair q = hm.get(ch);
                int fre = q.freq+1;
                hm.put(ch,new Pair(i,fre));
            }
        }
        for(char ch:hm.keySet()){
            Pair p = hm.get(ch);
            if(p.freq ==1){
                min= Math.min(min,p.index);
            }
        }
        if(min==Integer.MAX_VALUE) return -1;
        return min;

        
    }
}
