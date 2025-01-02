//O(n+m)
//O(5) -> O(1)
class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        HashSet<Character> hs = new HashSet<>();
        hs.add('a');
        hs.add('e');
        hs.add('i');
        hs.add('o');
        hs.add('u');
        int n = words.length;
        int m = queries.length;
        int[] prefix = new int[n];
        int[] ans = new int[m];

        int wordLength = words[0].length();
        char ch = words[0].charAt(0);
        char ch1 = words[0].charAt(wordLength-1);
        prefix[0] = (hs.contains(ch) && hs.contains(ch1))?1:0;

        for(int i=1;i<n;i++){
            ch = words[i].charAt(0);
            wordLength = words[i].length();
            ch1 = words[i].charAt(wordLength-1);
            if(hs.contains(ch) && hs.contains(ch1)){
                prefix[i] = prefix[i-1]+1;
            }else{
                prefix[i] = prefix[i-1];
            }
        }

        for(int i=0;i<m;i++){
            int x = queries[i][0];
            int y = queries[i][1];

            if(x==0){
                ans[i]=prefix[y];
            }else{
                ans[i]=prefix[y]-prefix[x-1];
            }
        }
        return ans;
    }
}
