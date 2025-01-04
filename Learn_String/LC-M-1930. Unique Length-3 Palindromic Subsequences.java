//Asked in Google,Meta
//Need to optimized
//O(26*2)+0(N)
//O(K)+O(26*2)
class Solution {
    public int countPalindromicSubsequence(String s) {
        int[][] firstAndLastIndex = new int[26][2];
        for(int[] i:firstAndLastIndex){
            Arrays.fill(i,-1);
        }
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            int index = ch-'a';
            if(firstAndLastIndex[index][0]==-1){
                firstAndLastIndex[index][0]=i;
            }else{
                firstAndLastIndex[index][1]=i;
            }
        }
        HashSet<String> hs = new HashSet<>();
        int ans=0;
        for(int[] i:firstAndLastIndex){
            if(i[0]>=i[1]){
                continue;
            }
            char ch1 = s.charAt(i[0]);
            char ch3 = s.charAt(i[1]);
            for(int j=i[0]+1;j<i[1];j++){
                char ch2 = s.charAt(j);
                String s1 = ""+ch1+ch2+ch3;
                if(!hs.contains(s1)){
                    ans++;
                    hs.add(s1);
                }
            }
        }
        return ans;
    }
}
