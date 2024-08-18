//O(n^2)
//O(1)
class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode ans = dummy;
        ListNode curr= head;
        while(curr!=null){
            while(dummy.next!=null && dummy.next.val<curr.val){
                dummy = dummy.next;
            }
            ListNode temp = dummy.next;
            dummy.next = new ListNode(curr.val);
            dummy.next.next=temp;
            dummy = ans;
            curr = curr.next;
        }
        return ans.next;
    }
}
