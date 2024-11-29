//O(N*M)
//O(1)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int[][] direc = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int row = matrix.length;
        int col = matrix[0].length;
        int count=0;
        int p=0;// boundary for upper row(already visited)
        int q=0; // boundary for left col (already visited)
        int i=0;//indexes
        int j=0;//indexes
        int dir=0; //i index for direction j will be 0/1
        int totalLoop = row*col;
        while(count < totalLoop){ //for all element should travers
            while(i>=p && i<row && j<col && j>=q){
                ans.add(matrix[i][j]);
                i+=direc[dir][0];
                j+=direc[dir][1];
                count++;
            }
            if(j>=col){
                i++;
                j--;
                dir=1;
            }else if(i>=row){
                i--;
                j--;
                dir=2;
            }else if(j<q){
                i--;
                j++;
                dir=3;
            }else{
                i++;
                j++;
                dir=0;
            }

            if(dir==1){
                p++;
            }else if(dir==2){
                col--;
            }else if(dir==3){
                row--;
            }else{
                q++;
            }
        }
        return ans;
    }
}
