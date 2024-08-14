class Solution {
    //O(n2)
    //O(n)
    public String countOfAtoms(String formula) {
        Stack<HashMap<String,Integer>> st = new Stack<>();
        HashMap<String,Integer> hm = new HashMap<>();
        st.push(hm);
        int i=0;
        int n=formula.length();
        while(i<n){
            char ch = formula.charAt(i);
            if(ch=='('){
                hm = new HashMap<>();
                st.push(hm);
                i++;
            }
            else if( ch==')'){
                HashMap<String,Integer> curr =st.pop();
                i++;

                String mul="";
                while(i<n && formula.charAt(i)>='0' && formula.charAt(i)<='9'){
                    mul+=formula.charAt(i);
                    i++;
                }
                if(mul.length()>0){
                    Integer multiplier = Integer.parseInt(mul);
                    for(String s:curr.keySet()){
                        curr.put(s,curr.get(s)*multiplier);
                    }
                }

                HashMap<String ,Integer> top = st.peek();
                for(String s:curr.keySet()){
                    if(top.containsKey(s)){
                        top.put(s,top.get(s)+curr.get(s));
                    }else{
                        top.put(s,curr.get(s));
                    }
                }
                
            }
            else{
                String thing = ch+"";
                i++;
                while(i<n && formula.charAt(i)>='a' && formula.charAt(i)<='z'){
                    thing+=formula.charAt(i);
                    i++;
                }

                String thingDigit = "";
                while(i<n && formula.charAt(i)>='0' && formula.charAt(i)<='9'){
                    thingDigit+= formula.charAt(i);
                    i++;
                }
                int digit = thingDigit.length()>0?Integer.parseInt(thingDigit):1;
                HashMap<String ,Integer> top = st.peek();
                top.put(thing,top.getOrDefault(thing,0)+digit);

            }
        }
        TreeMap<String,Integer> ans = new TreeMap<>(st.peek());
        String res="";
        for (String key : ans.keySet()){
                    if(ans.get(key)>1) res+=key+ans.get(key);
                    else res+=key;
        }
        return res;
    }
}
