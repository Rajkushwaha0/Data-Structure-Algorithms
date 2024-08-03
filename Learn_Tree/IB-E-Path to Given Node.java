public class Solution {
    public List<Integer> arr = new ArrayList<>();
    public int[] solve(TreeNode A, int B) {
        recur(A,B);
        // System.out.print(arr);
        int[] ans = new int[arr.size()];
        int i=0;
        for(int j :arr){
            ans[i++]=j;
        }
        return ans;
        
        
    }
    public Boolean recur(TreeNode root,int p){
        if(root==null) return false;
        
        
        arr.add(root.val);
        if(root.val == p) {
            
            return true;
        }
        
        Boolean left = recur(root.left,p);
        Boolean right = recur (root.right,p);
        
        if(left==false && right==false){
            arr.remove(arr.size()-1);
            return false;
        } 
        else{
            return true;
        }
        
    }
