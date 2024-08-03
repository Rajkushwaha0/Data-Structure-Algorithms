class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int n = rowSum.length;
        int m = colSum.length;
        int[][] arr = new int[n][m];

        int i=0;
        int j=0;
        while(i<n && j<m){
            int minVal = Math.min(rowSum[i],colSum[j]);
            arr[i][j]=minVal;
            rowSum[i]=Math.abs(rowSum[i]-minVal);
            colSum[j]=Math.abs(colSum[j]-minVal);
            if(rowSum[i]==0){
                i++;
            }
            else if(colSum[j]==0){
                j++;
            }

        }
        return arr;

    }
}
