class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode ans = dummy;
        ListNode curr = head;
        curr=curr.next;
        while(curr!=null){
            int sum=0;
            while(curr!=null && curr.val!=0){
                sum+=curr.val;
                curr=curr.next;
            }
            dummy.next = new ListNode(sum);;
            dummy=dummy.next;
            curr=curr.next;

        }

        return ans.next;
    }
}
