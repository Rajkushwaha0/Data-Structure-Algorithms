class Solution {
    public ListNode doubleIt(ListNode head) {
        // ListNode newNode = reverse(head);
        // int remain=0;
        // int mul = 0;
        // int n=0;
        // ListNode temp = newNode;
        // while(temp!=null){
        //     mul = (temp.val*2)+remain;
        //     n=mul%10;
        //     temp.val=n;
        //     remain=mul/10;
        //     if(temp.next==null){
        //         while(remain!=0){
        //             int modulo = remain%10;
        //             ListNode node = new ListNode(modulo);
        //             temp.next=node;
        //             temp=temp.next;
        //             remain=remain/10;
        //         }
        //         break;
        //     }
        //     temp=temp.next;
        // }
        // return reverse(newNode);

        //Another optimized solution
        //if there will be node.next.val>4 there will be carry;
        ListNode temp=null;
        if(head.val>4){
            ListNode one = new ListNode(1);
            one.next=head;
            head=one;
            temp=head.next;
        }else{
            temp=head;
        }
        
        int mul=0;
        while(temp!=null){
            mul = (temp.val*2);
            if(temp.next!=null && temp.next.val>4){
                mul +=1;
            }
            temp.val = mul%10;
            temp=temp.next;
        }
        
        return head;

    }
    public ListNode reverse(ListNode head){
        if(head == null || head.next==null) return head;

        ListNode newhead = reverse(head.next);
        head.next.next=head;
        head.next=null;
        return newhead;
        
    }
}
