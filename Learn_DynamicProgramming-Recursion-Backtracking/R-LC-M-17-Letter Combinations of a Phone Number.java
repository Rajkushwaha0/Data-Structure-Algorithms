//TC O(K^N * N)
//SC (N)
class Solution {
    public List<String> letterCombinations(String digits) {
        String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> ans = new ArrayList<>();

        solve(0,digits.length(),digits,new StringBuilder(),map,ans);
        return ans;
    }

    public void solve(int i,int n,String digits, StringBuilder current, String[] map, List<String> ans){
        if(i>=n){
            ans.add(current.toString());
            return ;
        }

        int strNumber = digits.charAt(i);
        String number_letter = map[strNumber-'0'];
        int total_letter = number_letter.length();

        for(int j=0;j<total_letter;j++){
            current.append(number_letter.charAt(j));
            solve(i+1,n,digits,current,map,ans);
            current.deleteCharAt(current.length()-1);
        }
        return ;
    }
}
