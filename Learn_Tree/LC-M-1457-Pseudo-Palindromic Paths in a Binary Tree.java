//Optimize solution
class Solution{
    public int pseudoPalindromicPaths (TreeNode root) {
        return solve(root,0);
    }
    public int solve(TreeNode root,int cnt){
        if(root==null) return 0;
        cnt^= (1<<root.val);
        if(root.left==null && root.right==null){
            return (cnt & (cnt-1))==0 ? 1:0;
        }
        return solve(root.left,cnt)+solve(root.right,cnt);
    }
} 

//My solution
class Solution {
    public int count=0;
    public int pseudoPalindromicPaths (TreeNode root) {
        if(root.left==null && root.right==null) return 1;
        HashMap<Integer,Integer> hm = new HashMap<>();
        solve(root,hm);
        return count;
    }
    public Boolean solve(TreeNode root,HashMap<Integer,Integer> hm){
        if(root==null){
            return false;
        }
        int m = root.val;
        hm.put(m,hm.getOrDefault(m,0)+1);
        boolean left = solve(root.left,hm);
        boolean right = solve(root.right,hm);


        if(root.left==null && root.right==null){
            if(check(hm)){
                count++;
            }
        }
        
        if(left==false && right== false){
            hm.put(root.val,hm.get(root.val)-1);
            if(hm.get(root.val)==0) hm.remove(root.val);
            return false;
        }
        return true;


    } 
    public boolean check(HashMap<Integer,Integer> hm){
        int odd=0;
        int count1=0;
        System.out.println(hm);
        for(int i:hm.keySet()){
            if(hm.get(i)%2==1) count1++;
            if(count1>1) return false;
        }
        return true;
    }
}
