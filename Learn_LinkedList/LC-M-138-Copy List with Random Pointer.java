/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        
        HashMap<Node ,Node> map = new HashMap<>();
        Node nh = new Node(-1);
        Node dm = nh;
        Node ptr=head;
        while(ptr!=null){
            dm.next=new Node(ptr.val);
            map.put(ptr,dm.next);
            dm=dm.next;
            ptr=ptr.next;
        }
        nh=nh.next;
        ptr=head;
        dm=nh;
        while(ptr!=null){
            Node x = ptr.random;
            if(x!=null){
                Node y = map.get(x);
                dm.random=y;
            }
            else{
                dm.random=null;
            }
            ptr=ptr.next;
            dm=dm.next;
        }
        return nh;
        
    }
}
