class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] direc = {{0,1},{1,0},{0,-1},{-1,0}};
        int m=4;
        int step=0;
        int dir=0;
        int count=1;
        int[][] ans = new int[rows*cols][2];
        ans[0] = new int[]{rStart,cStart};

        while(count < rows*cols){
            if(dir==0 || dir ==2) {
                step++;
            }

            for(int i=1;i<=step;i++){
                rStart += direc[dir][0];
                cStart += direc[dir][1];

                if(rStart<rows && rStart>=0 && cStart<cols && cStart>=0 ){
                    ans[count] = new int[]{rStart,cStart};
                    count++;
                }
            }
            dir = (dir+1)%m;
        }
        return ans;
    }
}
