350ms
class FindElements {
    public void preorder(TreeNode root,int k){
        if(root==null) return ;

        root.val=k;
        l.add(root.val);
        preorder(root.left,2*k+1);
        preorder(root.right,2*k+2);
    }
    List<Integer> l;
    public FindElements(TreeNode root) {
        l = new ArrayList<>();
        preorder(root,0);
    }
    
    public boolean find(int target) {
        return l.contains(target);
    }
    
}



using hashset takes less time than array or arraylist
20ms
// class FindElements {
//     Set<Integer> nodes;
//     public FindElements(TreeNode root) {
//         nodes = new HashSet<>();
//         recover(root,0);
//     }
//     private void recover(TreeNode root, int parent){
//         if(root == null){
//             return;
//         }
//         root.val = parent;
//         nodes.add(root.val);
//         recover(root.left,2*parent+1);
//         recover(root.right,2*parent+2);
//     }
//     public boolean find(int target) {
//         return nodes.contains(target);
//     }
// }
