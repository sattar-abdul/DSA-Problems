import java.util.*;

public class Test {
    static class Node{
        int data;
        Node left, right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }

    public static class BinaryTree{
         public static void levelOrder(Node root){
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while(!q.isEmpty()){
                Node curr = q.poll();
                if(curr == null){
                System.out.println();
                continue;

                } else{
                    System.out.print(curr.data+" ");    
                }
                

                if(curr.left != null){
                    q.add(curr.left);
                }


                if(curr.right != null){
                    q.add(curr.right);
                }

                q.add(null);
            }
        
         }

         public static int height(Node root){
            if(root == null){
                return 0;
            }

            int leftHeight = height(root.left);
            int rightHeight = height(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
         }
        

    }


    
    public static void main(String[] args) {
        
        BinaryTree tree = new BinaryTree();

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        tree.levelOrder(root);
        System.out.println(tree.height(root));
    }
}