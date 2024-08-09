class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int count=0;
        int n=grid.length;
        int m=grid[0].length;
        for(int i=0;i<=n-3;i++){
            for(int j=0;j<=m-3;j++){
                if(solve(i,j,grid)) count++;
            }
        }
        return count;
    }
    public boolean solve(int i,int j,int[][] mat){
        //in center there must be 5
        if(mat[i+1][j+1]!=5) return false;

        //observation
        //corner if odd
        if(mat[i][j]%2!=0 || mat[i][j+2]%2!=0 || mat[i+2][j]%2!=0 || mat[i+2][j+2]%2!=0) return false;

        //not corner if even
        if(mat[i+1][j]%2==0 || mat[i][j+1]%2==0 || mat[i+2][j+1]%2==0 || mat[i+2][j+1]%2==0) return false;

        //rows and cols
        int rowSum = mat[i][j]+mat[i][j+1]+mat[i][j+2];
        int colSum = mat[i][j]+mat[i+1][j]+mat[i+2][j];

        if(mat[i+1][j]+mat[i+1][j+1]+mat[i+1][j+2]!=rowSum || mat[i+2][j]+mat[i+2][j+1]+mat[i+2][j+2]!=rowSum) return false;
        if(mat[i][j+1]+mat[i+1][j+1]+mat[i+2][j+1]!=colSum || mat[i][j+2]+mat[i+1][j+2]+mat[i+2][j+2]!=colSum) return false;

        //diagonal 
        if(mat[i][j]+mat[i+1][j+1]+mat[i+2][j+2]!=mat[i][j+2]+mat[i+1][j+1]+mat[i+2][j]) return false;


        return true;


    }
}
