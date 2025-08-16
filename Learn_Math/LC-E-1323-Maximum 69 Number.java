//O(N)
//O(1)
class Solution {
    public int maximum69Number (int num) {
        String s = num+"";
        int length = s.length();
        for(int i=0;i<length;i++){
            char ch = s.charAt(i);
            if(ch=='6'){
                double multiplier = (length-i-1);
                int pow_10 =  (int)Math.pow(10, multiplier);
                int multipleBy = pow_10*3;
                num+=multipleBy;
                return num;
            }
        }
        return num;
    }
}
