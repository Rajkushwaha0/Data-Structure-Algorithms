class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int m=grid.length;
        int n = grid[0].length;
        System.out.println(m);
        int[] rowOne = new int[m];
        int[] rowZero = new int[m];
        int[] colOne = new int[n];
        int[] colZero = new int[n];
        for(int i=0;i<m;i++){
            int o=0;
            int z=0;
            for(int j=0;j<n;j++){
                if(grid[i][j]==0) z+=1;
                else o+=1;
            }
            rowOne[i]=o;
            rowZero[i]=z;
        }


        for(int i=0;i<n;i++){
            int o=0;
            int z=0;
            for(int k=0;k<m;k++){
                if(grid[k][i]==0) z+=1;
                else o+=1;
            }
            colOne[i]=o;
            colZero[i]=z;
        }
         for(int i=0;i<m;i++){
         	for(int j=0;j<n;j++){
         		grid[i][j]=rowOne[i]+colOne[j]-rowZero[i]-colZero[j];	
         	}
         }


        return grid;
    }
}
