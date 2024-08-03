class Solution {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head==null && head.next==null) return head;
        ListNode curr = head;
        ListNode forw = curr.next;
        ListNode dummy = new ListNode(-1);
        ListNode ans =dummy;
        while(curr!=null){
            if(forw!=null){
                int  m = GCD(curr.val,forw.val);
                dummy.next=new ListNode(curr.val);
                dummy=dummy.next;
                dummy.next=new ListNode(m);
                dummy=dummy.next;
                curr=curr.next;
                forw=curr.next;
            }
            else{
                dummy.next=new ListNode(curr.val);
                dummy=dummy.next;
                curr=curr.next;
            }
            
        }

        return ans.next;


        
    }
    public int GCD(int x,int y){
        int gcd=0;
        for(int i = 1; i <= x && i <= y; i++)  
        {     
            if(x%i==0 && y%i==0)  
            gcd = i;  
        }  
        return gcd;
    }
}
