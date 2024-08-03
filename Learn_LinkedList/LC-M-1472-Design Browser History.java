class ListNode{
    String name;
    ListNode next;
    ListNode prev;
    public ListNode(String name){
        this.name=name;
        this.next=null;
        this.prev=null;
    }
}
class BrowserHistory {
    ListNode head;
    ListNode curr = null;

    public BrowserHistory(String homepage) {
        head=new ListNode(homepage);
        curr=head;
        // print();
    }
    public void print(){
        ListNode temp = curr;
        while(temp!=null){
            System.out.print(temp.name+" ");
            temp=temp.next;
        }
        System.out.println();
    }
    public void visit(String url) {
        curr.next=null;
        ListNode newNode  = new ListNode(url);
        newNode.prev=curr;
        curr.next=newNode;
        curr=newNode;
        // print();
    }
    
    public String back(int steps) {
        if(curr.prev==null) return curr.name;
        while(steps!=0 && curr.prev!=null){
            curr=curr.prev;
            steps--;
        }
        return curr.name;
    }
    
    public String forward(int steps) {
        if(curr.next==null) return curr.name;
        while(steps!=0 && curr.next!=null){
            curr=curr.next;
            steps--;
        }
        return curr.name;

    }
}
