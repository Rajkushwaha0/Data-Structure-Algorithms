class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String,String> hm = new HashMap<>();
        for(List<String> i:knowledge){
            hm.put(i.get(0),i.get(1));
        }
        // System.out.print(hm);
        String ans="";
        int i=0;
        while(i<s.length()){
            char ch = s.charAt(i);
            if(ch=='('){
                i++;
                String temp = "";
                while(i<s.length() && s.charAt(i)!=')'){
                    temp+=s.charAt(i++);
                }
                i++;
                if(hm.containsKey(temp)){
                    ans+=hm.get(temp);
                }
                else{
                    ans+='?';
                }
                
            }
            else {
                ans+=ch;
                i++;
            }
            
        }
        return ans;
        
    }
}
