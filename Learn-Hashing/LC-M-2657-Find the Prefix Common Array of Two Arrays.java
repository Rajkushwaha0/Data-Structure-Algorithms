class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] ans = new int[A.length];
        Set<Integer> s = new HashSet<>();
        Set<Integer> s1 = new HashSet<>();
        for(int i=0;i<A.length;i++){
           s.add(A[i]);
            s1.add(B[i]);
            if(s.equals(s1)) ans[i]=s.size();
            else{
                if(i-1>=0 && A[i]==B[i]) ans[i]=ans[i-1]+1;
                else if(i-1>=0 && s1.contains(A[i]) && s.contains(B[i])){
                    ans[i]=ans[i-1]+2;
                }
                else if(i-1>=0 && s1.contains(A[i]) || s.contains(B[i])){
                    ans[i]=ans[i-1]+1;
                }
                else if(i-1>=0 && !s1.contains(A[i]) && !s.contains(B[i])){
                    ans[i]=ans[i-1];
                }
            }
            
            
        }



        return ans;
    }
}
