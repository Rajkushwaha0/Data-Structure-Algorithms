class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        solve(n,0,0,new StringBuilder(),ans);
        return ans;
    }

    public void solve(int n,int o,int c,StringBuilder parentheses,List<String> ans){
        if(o>n || c>n){
            return ;
        }

        if(c>o){
            return ;
        }

        if(o==n && c==n){
            ans.add(parentheses.toString());
            return ;
        }

        parentheses.append('(');
        solve(n,o+1,c,parentheses,ans);
        parentheses.deleteCharAt(parentheses.length()-1);
        parentheses.append(')');
        solve(n,o,c+1,parentheses,ans);
        parentheses.deleteCharAt(parentheses.length()-1);
        return ;
    }
}
