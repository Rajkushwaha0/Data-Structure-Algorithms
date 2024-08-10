class Solution {
    public int[][] spiralMatrix(int n, int m, ListNode head) {
        int[][] direc = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int[][] ans = new int[n][m];
        for(int[] i:ans) Arrays.fill(i,-1);
        ListNode temp = head;
        int dir = 0;
        int i=0;
        int j=0;
        int p=0;
        int q=0;
        while(temp!=null){
            while(temp!=null && i>=p && i<n && j>=q && j<m){
                ans[i][j]=temp.val;
                temp=temp.next;
                i+= direc[dir][0];
                j+=direc[dir][1];
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
