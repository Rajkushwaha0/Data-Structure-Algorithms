class Solution {
    public String makeGood(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            int m = ch;
            if(!st.isEmpty() && m>=65 && m<=90){
                char ch1= st.peek();
                int n = ch1;
                int a = ch-'A';
                int b = ch1-'a';
                if( n>=97 && n<=122 && a==b)   {
                    st.pop();
                    continue;
                }
            }
            else if(!st.isEmpty() && m>=97 && m<=122){
                char ch1= st.peek();
                int n = ch1;
                int a = ch-'a';
                int b = ch1-'A';
                if( n>=65 && n<=90 && a==b )  {
                    st.pop();
                    continue;
                }
            }
            st.add(ch);

        }
        // StringBuilder ans = new StringBuilder();
        String ans = "";
        while(!st.isEmpty()){
            ans = st.pop() + ans;
        }
        return ans;
    }
}
