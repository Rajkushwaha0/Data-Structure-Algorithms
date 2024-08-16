//O(n)
//O(1)  
class Solution {
    public int finalPositionOfSnake(int n, List<String> commands) {
        // 0 -> 0*2+0;
        // 1 -> 0*2+1;
        // 2 -> 1*2+1;
        // 3 -> 1*2+1;
        int i=0;
        int j=0;
        for(int k=0;k<commands.size();k++){
            String str = commands.get(k);
            if(str.equals("RIGHT")){
                if(j+1<n){
                    j++;
                }
            }else if(str.equals("DOWN")){
                if(i+1<n){
                    i++;
                }
            }else if(str.equals("UP")){
                if(i-1>=0){
                    i--;
                }
            }else if(str.equals("LEFT")){
                if(j-1>=0){
                    j--;
                }
            }
        }
        return (i*n)+j;
    }   
}
