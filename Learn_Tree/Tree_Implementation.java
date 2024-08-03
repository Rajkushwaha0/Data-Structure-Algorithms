import java.util.*;
class Node5 {
    int data;
    Node5 left;
    Node5 right;
    public Node5(int i){
        data=i;
        left=null;
        right=null;
    }
}
public class tree {
    public static Node5 buildTree(Node5 root){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter data for root");
        int d = sc.nextInt();
        root = new Node5(d);

        if(d== -1 ) return null;
        System.out.println("Enter data for left root of"+d);
        root.left = buildTree(root.left);
        System.out.println("Enter data for right root of"+d);
        root.right = buildTree(root.right);
        return root;

    }
    public static List<List<Integer>> levelOrder(Node5 root){
        List<List<Integer>> ans  = new ArrayList<>();
        Queue<Node5> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
//            Node5 temp = q.peek();
//            q.poll();
            int level = q.size();
            List<Integer> fill = new ArrayList<>();
            for(int i=0;i<level;i++){
                Node5 temp = q.peek();
                fill.add(temp.data);

                if(temp.left!=null){
                    q.add(temp.left);
                }
                if(temp.right!=null) {
                    q.add(temp.right);
                }
                q.poll();

            }
            ans.add(fill);
        }
        return ans;

    }
    public static void levelDusra(Node5 root){
        Queue<Node5> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node5 temp = q.peek();
            q.poll();

            if(temp== null) {
                System.out.println("");
                if(!q.isEmpty()){
                    q.add(null);
                }
            }
            else{
                System.out.print(temp.data+" ");
                if(temp.left!=null){
                    q.add(temp.left);
                }
                if(temp.right!=null){
                    q.add(temp.right);
                }
            }
        }
    }


    public static void buildfromlevelorder(Node5 root){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the root");
        int d = sc.nextInt();
        root=new Node5(d);
        Queue<Node5> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            Node5 temp = q.poll();

            System.out.println("Enter left node value of : "+temp.data);
            int leftchild = sc.nextInt();

            if(leftchild!= -1) {
                temp.left = new Node5(leftchild);
                q.add(temp.left);
            }

            System.out.println("Enter right node value of : "+temp.data);
            int rightchild = sc.nextInt();

            if(rightchild!= -1) {
                temp.right = new Node5(rightchild);
                q.add(temp.right);
            }
        }

    }


    public static void preorder(Node5 root){
        if(root == null){
            return ;
        }
        System.out.println(root.data);
        preorder(root.left);
        preorder(root.right);
    }
    public static void postorder(Node5 root){
        if(root == null){
            return ;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.println(root.data);
    }
    public static void Inorder(Node5 root){
        if(root == null){
            return ;
        }
        Inorder(root.left);
        System.out.println(root.data);
        Inorder(root.right);

    }


    public static void main(String[] args) {
        Node5 root = new Node5(8);
        Node5 node1 = new Node5(3);
        Node5 node2 = new Node5(10);
        Node5 node3 = new Node5(1);
        Node5 node4 = new Node5(6);
        Node5 node5 = new Node5(14);
        Node5 node6 = new Node5(4);
        Node5 node7 = new Node5(7);
        Node5 node8 = new Node5(13);
        root.left=node1;
        root.right=node2;
        node1.left=node3;
        node1.right=node4;
        node2.right=node5;
        node4.left=node6;
        node4.right=node7;
        node5.left=node8;

        levelDusra(root);

//        root = buildTree(null);
//


        //buildfromlevelorder(null);


    }

}
