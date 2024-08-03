class Solution {
    ArrayList<Integer> list = new ArrayList<>();
    public TreeNode solve(int s,int e){
        if(s>e) return null;

        int mid = s+(e-s)/2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = solve(s,mid-1);
        root.right = solve(mid+1,e);
        return root;
    }
    public TreeNode sortedListToBST(ListNode head) {
        while(head!=null){
            list.add(head.val);
            head=head.next;
        }
        int s=0;
        int e=list.size()-1;

        return solve(s,e);

    }
}
