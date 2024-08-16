//O(1)
//O(1)
class Node{
    int val;
    Node next;
    Node prev;
    public Node(int val){
        this.val=val;
        next=null;
        prev=null;
    }
}
class MyCircularDeque {
    int limit;
    Node head;
    Node tail;
    int count=0;
    public MyCircularDeque(int k) {
        limit=k;
        head=null;
        tail=null;
    }
    
    public boolean insertFront(int value) {
        if(count>=limit) return false;
        if(count==0){
            head=new Node(value);
            tail=head;
        }
        else{
            Node temp =new Node(value);
            head.prev=temp;
            temp.next=head;
            head=temp;
        }
        count++;
        // print(head);
        return true;
    }
    
    public boolean insertLast(int value) {
        if(count>=limit) return false;
        if(count==0){
            head=new Node(value);
            tail=head;
        }
        else{
            Node temp =new Node(value);
            tail.next=temp;
            temp.prev=tail;
            tail=temp;
        }
        count++;
        // print(head);
        return true;
    }
    
    public boolean deleteFront() {
        if(count==0) return false;
        if(count==1) {
            head=null;
            tail=null;
            count--;
            return true;
        }
        head=head.next;
        head.prev=null;
        count--;
        return true;
    }
    
    public boolean deleteLast() {
        if(count==0) return false;
        if(count==1) {
            head=null;
            tail=null;
            count--;
            return true;
        }
        tail=tail.prev;
        tail.next=null;
        count--;
        return true;
    }
    
    public int getFront() {
        if(count==0) return -1;
        return head.val;
    }
    
    public int getRear() {
        if(count==0) return -1;
        return tail.val; 
    }
    
    public boolean isEmpty() {
        if(count==0) return true;
        return false;
    }
    
    public boolean isFull() {
        if(count>=limit) return true;
        return false;
    }
    public void print(Node temp){
        while(temp!=null){
            System.out.print(temp.val+" ");
            temp=temp.next;
            
        }
        System.out.println();
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
