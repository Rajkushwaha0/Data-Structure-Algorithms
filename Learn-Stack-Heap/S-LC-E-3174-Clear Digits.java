//O(N)
//O(N)
class Solution {
    public String clearDigits(String s1) {
        Stack<Character> s = new Stack<>();
        for(int i=0;i<s1.length();i++){
            char ch = s1.charAt(i);
            int val = ch-'0';
            if(val>=0 && val<=9){
                if(!s.isEmpty()) s.pop();
            }else{
                s.push(ch);
            }
        }
        if(s.isEmpty()) return "";
        String ans="";
        while(!s.isEmpty()){
            ans = s.pop()+ans;
        }
        return ans;
    }
}
