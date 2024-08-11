class ListNode{
    ListNode next;
    int val;
    public ListNode(){
        next=null;
    }
    public ListNode(int val){
        this.val=val;
        next=null;
    }
}
class MyLinkedList {

    ListNode head;
    int length=0;
    public MyLinkedList() {
        head = null;
        // print(head);
    }
    
    public int get(int index) {
        if(index>=length) return -1;
        int count=0;
        ListNode temp = head;
        while(count<index){
            count++;
            temp=temp.next;
            
        }
        
        return temp.val;
    }
    public void print(ListNode temp){
        ListNode curr = temp;
        while(curr!=null){
            System.out.print(curr.val+" ");
            curr=curr.next;
        }
        System.out.println();

    }
    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next =head;
        head=newNode;
        length++;
        // print(head);
    }       
    
    public void addAtTail(int val) {
        if(head==null){
            addAtHead(val);
            return ;
        }
        ListNode temp = head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=new ListNode(val);
        length++;
        // print(head);
    }
    
    public void addAtIndex(int index, int val) {
        if(index>length) return ;
        if(index==0){
            addAtHead(val);
            return ;
        }
        ListNode curr=head;
        int count=1;
        while(count<index){
            curr=curr.next;
            count++;
        }
        ListNode nextNode = curr.next;
        curr.next=new ListNode(val);
        curr.next.next=nextNode;
        length++;
        // print(head);
    }
    
    public void deleteAtIndex(int index) {
        if(index>=length) return ;
        if(index==0){
            head=head.next;
            length--;
            return ;
        }
        int count=1;
        ListNode temp = head;
        while(count<index){
            count++;
            temp=temp.next;
        }
        temp.next=temp.next.next;
        length--;
        // print(head);
    }
}
