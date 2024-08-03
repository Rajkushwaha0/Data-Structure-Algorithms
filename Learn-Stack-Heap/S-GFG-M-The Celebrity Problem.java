class Solution
{
    int celebrity(int mat[][], int N)
    {
    	// code here 
    	Stack<Integer> stk=new Stack<>();
        
        for(int i=0;i<N;i++) {
            stk.push(i);
        }
        
        while(stk.size() > 1) {
            int col = stk.pop();
            int row = stk.pop();
            if(mat[row][col] == 1) {
                stk.add(col); 
            } else {
                stk.add(row); 
            }
        }
        
        int x = stk.pop();
        
        for(int j=0;j<N;j++) {
            if(j == x) continue;
            if(mat[x][j] == 1) {
                return -1;
            }
        }
        
        for(int i=0;i<N;i++) {
            if(i == x) continue;
            if(mat[i][x] == 0) {
                return -1;
            }
        }
        
        return x;
    }
}
