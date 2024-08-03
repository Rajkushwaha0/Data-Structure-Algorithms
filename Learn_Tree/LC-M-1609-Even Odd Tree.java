//Not appropriate
class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int i=0;
        boolean flag = true;
        List<Integer> l;
        while(!q.isEmpty()){
            int n=q.size();
            l = new ArrayList<>();
            for(int j=0;j<n;j++){
                TreeNode temp = q.poll();
                l.add(temp.val);
                if(temp.left!=null) q.add(temp.left);
                if(temp.right!=null) q.add(temp.right);
            }
            // System.out.print(l);
            if(i%2==0){
                // if(l.size()%2==0) return false;
                if(l.size()>1){
                    for(int j=0;j<l.size()-1;j++){
                        if(l.get(j)%2==0) return false;
                        if(l.get(j)>=l.get(j+1)) return false; 
                    }
                    if(l.get(l.size()-1)%2==0) return false;
                }
                else{
                    if(l.get(0)%2==0) return false;
                }
            }
            else{
                if(l.size()>1){
                    for(int j=0;j<l.size()-1;j++){
                        if(l.get(j)%2==1) return false;
                        if(l.get(j)<=l.get(j+1)) return false; 
                    }
                    if(l.get(l.size()-1)%2==1) return false;
                }
                else{
                    if(l.get(0)%2==1) return false;
                }
                
            }
            i+=1;
        }
        return flag;
        
    }
}
