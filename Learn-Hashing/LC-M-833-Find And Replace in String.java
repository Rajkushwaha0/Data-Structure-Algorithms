//Asked in Amazon
//O(N+K)
//O(K)
class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        Map<Integer,Integer> hm=new HashMap<>();
        for (int i=0; i<indices.length; i++){
            if (s.startsWith(sources[i],indices[i])){
                hm.put(indices[i],i);
            }
        }  
        StringBuilder sb=new StringBuilder();
        for (int i=0; i<s.length();){
            if (!hm.containsKey(i)){
                sb.append(s.charAt(i));
                i++;
            } else {
                sb.append(targets[hm.get(i)]); 
                i+=sources[hm.get(i)].length();
            }
        }
        return sb.toString();
    }
}
