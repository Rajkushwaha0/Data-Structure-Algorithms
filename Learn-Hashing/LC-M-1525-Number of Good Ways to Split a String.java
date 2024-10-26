//Asked in google
class Solution {
    public int numSplits(String s) {
        int n = s.length();
        int[] mark = new int[26];
        int[] frq = new int[26];
        int countUnique=0;
        for(char ch: s.toCharArray()){
            if(frq[ch-'a']==0){
                countUnique++;
            }
            frq[ch-'a']++;
        }
        int countDistinct=0;
        int ans=0;
        for(int i=0;i<=n-1;i++){
            char ch = s.charAt(i);
            if(mark[ch-'a']==0){
                countDistinct++;
                mark[ch-'a']++;
            }
            frq[ch-'a']--;
            if(frq[ch-'a']==0){
                countUnique--;
            }
            if(countDistinct==countUnique) ans++;
        }
        return ans;
    }
}
