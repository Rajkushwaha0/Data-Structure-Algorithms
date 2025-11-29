class Solution {
    List<String> ans;
    public List<String> validStrings(int n) {
        ans = new ArrayList<>();
        solve("" , 0, n);
        return ans;
    }

    public void solve(String str, int i, int n){
        int str_length = str.length();
        if(i>=n){
            if(str_length==n) ans.add(str);
            return ;
        }

        boolean check = true;
        if(str_length>0){
            char last = str.charAt(str_length - 1);
            check = last=='0' ? false : true;
        }
        if(check){
            solve(str+"0",i+1,n);
        }
        solve(str+"1",i+1,n);
        return ;
    }
}
