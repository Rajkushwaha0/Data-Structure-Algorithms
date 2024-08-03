//Best Solution
class Solution {
    public int numberOfBeams(String[] bank) {
        int prevRowCount = 0;
        int total=0;

        for(String row : bank) {
            int curRowCount = calc(row);
            if(curRowCount==0) 
                continue;

            total += curRowCount * prevRowCount;
            prevRowCount = curRowCount;
        }
        return total;
    }

    private int calc(String s) {
        int count = 0;
        for(char c : s.toCharArray()) 
            count += c - '0';

        return count;
    }    
}


class Solution {
    public int numberOfBeams(String[] bank) {
        if(bank.length==1) return 0;
        Stack<Integer> s = new Stack<>();
        for(int i=bank.length-1;i>=0;i--){
            int count=0;
            for(char ch:bank[i].toCharArray()){
                if(ch=='1') count++;
            }
            if(count!=0) s.add(count);
        }
        int ans=0;
        if(s.isEmpty() || s.size()==1) return 0;
        if(s.size()==2) return s.pop()*s.pop();
        int n=s.pop();
        int m=s.pop();
        ans = n*m;
        while(!s.isEmpty()){
            n=m;
            m=s.pop();
            ans+= (n*m);
        }
        return ans;
    }
}
