class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean a = false;
        for(int i=0;i<matrix.length;i++){
            int s=0;
            int e=matrix[i].length-1;
            int mid=(s+e)/2;
            
            while(s<=e){
                if(matrix[i][mid]==target){
                    a = true;
                    break;
                }
                if(target>matrix[i][mid]){
                    s=mid+1;
                }
                else{
                    e=mid-1;
                }
                mid=(s+e)/2;
            }
        }
        return a;
    }
}


//another approoach optimized
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix[0].length-1;
        for(int i=0;i<matrix.length;i++){
            if(matrix[i][m]<target){
                continue;
            }
            else{
                for(int j=0;j<=m;j++){
                    if(matrix[i][j]==target) return true;
                }
                break;
            }
        }
        return false;
    }
}

