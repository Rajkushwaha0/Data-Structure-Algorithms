class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null && k>=0) return head;
        if(head.next == null && k>=0) return head;
        int length = len(head);
        k=k%length;
        while(k!=0){
            ListNode curr = head;
            ListNode prev = null;
            while(curr.next!=null){
                prev = curr;
                curr= curr.next;
            }
            prev.next=null;
            curr.next=head;
            head=curr;
            
            k--;
        }
        return head;

    }
    public int len(ListNode head){
        int count=0;
        while(head!=null){
            head=head.next;
            count++;
        }
        return count;
    }
}
