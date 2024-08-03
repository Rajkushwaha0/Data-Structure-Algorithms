class Solution {
    public String reverseParentheses(String s) {
        Stack<String> st = new Stack<>();
        for (int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch==')'){
                String ans = "";
                while(!st.isEmpty() && !st.peek().equals("(")){
                    ans=ans+st.pop();
                }
                st.pop();
                for(char ch1:ans.toCharArray()){
                    st.push(ch1+"");
                }
            }
            else{
                st.push(ch+"");
            }
        }
        String res="";
        while(!st.isEmpty()){
            res=st.pop()+res;
        }
        return res;
    }
}
