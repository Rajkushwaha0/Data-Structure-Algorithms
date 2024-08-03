class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int len = length(head);
        int m = (len/k);
        int r = len%k;
        ListNode[] ans = new ListNode[k];
        ListNode curr= head;
        int i=0;
        while(curr!=null ){
            ListNode dummy = new ListNode(-1);
            ListNode store = dummy;
            int n=m;
            while(n!=0 && curr!=null){
                dummy.next = new ListNode(curr.val);
                dummy = dummy.next;
                curr=curr.next;
                n--;
            }
            if(r!=0){
                dummy.next = new ListNode(curr.val);
                dummy = dummy.next;
                curr=curr.next;
                r--;
            }
            ans[i]=store.next;
            i++;
            
        }
        return ans;



        
    }
    public int length(ListNode root){
        int c=0;
        while(root!=null){
            c++;
            root=root.next;
        }
        return c;
    }
}
