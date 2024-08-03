class Solution {
    public ListNode partition(ListNode head, int x) {
        List<Integer> l = new ArrayList<>();
        int i = 0;
        while(head!=null){
            if(head.val<x){
                l.add(i,head.val);
                i++;
            }
            else{
                l.add(head.val);
            }
            head=head.next;
        }
        System.out.print(l);
        ListNode dummy = new ListNode(-1);
        ListNode ans = dummy;
        for(int j = 0;j<l.size();j++){
            ListNode newNode =  new ListNode(l.get(j));
            dummy.next = newNode;
            dummy=dummy.next;
        }
        return ans.next;
        
    }
}
