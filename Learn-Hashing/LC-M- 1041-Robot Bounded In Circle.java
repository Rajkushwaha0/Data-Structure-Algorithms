class Solution {
    public boolean isRobotBounded(String ins) {
        HashMap<Character,Character> hm1 = new HashMap<>();
        HashMap<Character,Character> hm2 = new HashMap<>();
        hm1.put('N','W');
        hm1.put('W','S');
        hm1.put('S','E');
        hm1.put('E','N');
        hm2.put('N','E');
        hm2.put('W','N');
        hm2.put('S','W');
        hm2.put('E','S');
        int[] ans = new int[2];
        char flag ='N';
        for(int i=0;i<ins.length();i++){
            char ch = ins.charAt(i);
            if(ch=='G'){
                if(flag=='N'){
                    ans[1]++;
                }
                else if(flag=='E'){
                    ans[0]++;
                }
                else if(flag=='S'){
                    ans[1]--;
                }
                else if(flag=='W'){
                    ans[0]--;
                }
            }
            else if(ch=='L'){
                flag = hm1.get(flag);
            }
            else{
                flag = hm2.get(flag);
            }
        }
        if(ans[0]==0 && ans[1]==0) return true;
        if(flag=='N') return false;
        return true;
    }
}
