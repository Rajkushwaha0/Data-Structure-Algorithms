class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int tNode=totalNode(head);
        ListNode temp = head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p,c,n;
        p = dummy;
        while(tNode>= k){
            c = p.next;
            n = c.next;
            for(int i = 1;i<k;i++){
                c.next = n.next;
                n.next=p.next;
                p.next=n;
                n=c.next; 
            }
            p=c;
            tNode-=k;
        }
        return dummy.next;
    }
    public int totalNode(ListNode head){
        ListNode temp=head;
        int c=0;
        while(temp!=null){
            c++;
            temp=temp.next;
        }
        return c;
    }
}
