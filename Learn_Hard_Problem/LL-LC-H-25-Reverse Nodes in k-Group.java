//Optimize 
class Solution {
    //O(n)+O(n) -> O(2n)
    //O(1)
    public ListNode findKthNode(ListNode head,int k){
        k-=1;
        while(head!=null && k>0){
            k--;
            head=head.next;
        }
        return head;
    }
    public ListNode reverse(ListNode head){
        if(head==null || head.next == null) return head;

        ListNode newNode = reverse(head.next);
        head.next.next=head;
        head.next=null;
        return newNode;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null) return head;

        ListNode temp = head;
        ListNode prevNode = null;
        ListNode nextNode = null;
        while(temp!=null){
            ListNode kthnode = findKthNode(temp,k); //O(n)
            if(kthnode == null ){
                if(prevNode!=null){
                    prevNode.next=temp;
                }
                break;
            }
            else{
                nextNode = kthnode.next;
                kthnode.next=null;
                reverse(temp);//O(n)
                if(temp==head){
                    head=kthnode;
                }
                else{
                    prevNode.next=kthnode;
                }
                prevNode=temp;
                temp = nextNode;
            }
        }
        return head;
    }
}





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
