package tree.generaltree;

class Node{
    int data;

    Node left;
    Node right;

    Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
public class generaltree {
    public static void main(String[] args) {
            
            Node root = new Node(25);

            //level1
            root.left = new Node(10);
            root.right = new Node(35);
            //level 2

            root.left.left = new Node(5);
            root.left.right = new Node(25);
            root.right.left = new Node(30);
            root.right.right = new Node(40);

            //level 3

            root.left.right.left = new Node(13);
            root.left.right.right = new Node(20);

            


        
        
        
    }
}
