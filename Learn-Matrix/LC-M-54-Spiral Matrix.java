O(N)
O(1)  
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int[][] direc = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        List<Integer> ans = new ArrayList<>();
        int count=0;
        int dir = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int i=0;
        int j=0;
        int n=rows;
        int m=cols;
        int p=0;
        int q=0;
        while(count < rows*cols){
            while(i>=p && i<n && j>=q && j<m){
                ans.add(matrix[i][j]);
                i+= direc[dir][0];
                j+=direc[dir][1];
                count++;
            }
            if(i<p){
                i++;
                j++;
                dir=0;
            }
            else if(i>=n){
                i--;
                j--;
                dir=2;
            }
            else if(j<q){
                j++;
                i--;
                dir=3;
            }
            else if(j>=m){
                i++;
                j--;
                dir=1;
            }

            if(dir==0){
                q++;
            }
            else if(dir==1){
                p++;
            }
            else if(dir==2){
                m--;
            }
            else if(dir==3){
                n--;
            }
        }
        return ans;
    }
}
