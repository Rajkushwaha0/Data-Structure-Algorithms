TC -> O(n)
SC -> O(1)
class Solution {
    public int minimumPushes(String word) {
        
        int[] letterFrequency = new int[26];
        for (char c : word.toCharArray()) {
            letterFrequency[c - 'a']++;
        }
        
        Integer[] sortedFreq = new Integer[26];
        for (int i = 0; i < 26; i++) {
            sortedFreq[i] = letterFrequency[i];
        }
        Arrays.sort(sortedFreq, Collections.reverseOrder());
        int totalPresses = 0;
        for (int i = 0; i < 26; i++) {
            if (sortedFreq[i] == 0) break;
            totalPresses += (i / 8 + 1) * sortedFreq[i];
        }
        
        return totalPresses;

    }
}

TC -> O(n*log n)
SC -> O(n)
class Solution {
    public int minimumPushes(String word) {
        HashMap<Character,Integer> hm = new HashMap<>();
        HashMap<Character,Integer> hm1 = new HashMap<>();
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
        }
        PriorityQueue<Map.Entry<Character,Integer>> pq = new PriorityQueue<>((a, b)-> b.getValue() - a.getValue());
        pq.addAll(hm.entrySet());
        int i=1;
        int val=1;
        int limit=8;
        while(!pq.isEmpty()){
            Map.Entry<Character,Integer> e = pq.poll();
            hm1.put(e.getKey(),val);
            i++;
            if(i>limit){
                val++;
                i=1;
            }
            
        }
        int ans=0;
        for(char ch:hm.keySet()){
            ans+= hm.get(ch)*hm1.get(ch);
        }
        return ans;

    }
}
