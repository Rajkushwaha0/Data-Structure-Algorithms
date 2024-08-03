class Solution {
    public int numSpecial(int[][] mat) {
        int n =mat.length;
        int m = mat[0].length;
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==1){
                    if(solve(mat,i,j)) count++;
                } 
            }
        }
        return count;
    }
    public boolean solve(int[][] mat , int i,int j){
        boolean flag=true; 
        int n1=i-1;
        int n2=i+1;
        int m2=j+1;
        int m1=j-1;
        while(n1>=0){
            if(mat[n1][j]==1) return false;
            // System.out.print(mat[n1][j]);
            n1--;
        }
        while(n2<mat.length){
            if(mat[n2][j]==1) return false;
            // System.out.print(mat[n2][j]);
            n2++;
        }
        while(m1>=0 ){
            if(mat[i][m1]==1) return false;
            // System.out.print(mat[i][m1]);
            m1--;
        }
        while(m2<mat[0].length){
            if(mat[i][m2]==1) return false;
            // System.out.print(mat[i][m2]);
            m2++;
        }
        return true;
    }
}
