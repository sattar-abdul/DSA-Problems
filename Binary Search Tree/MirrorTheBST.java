import java.util.*;

public class MirrorTheBST {
    static class Node {
        int data;
        Node left, right;

        Node(int data){
            this.data = data;
            left = right = null;
        }
    }

    static class BST {
        Node root;

        void insert(int data){
            root = insertRec(root, data);
        }

        Node insertRec(Node root, int data){
            Node newNode = new Node(data);

            if(root == null){
                root = newNode;
            }

            if(root.data < data){
                root.right = insertRec(root.right, data);
            } else if(root.data > data){
                root.left = insertRec(root.left, data);
            }

            return root;
        }

        void inorder(Node root){
            if(root != null){
                inorder(root.left);
                System.out.println(root.data);
                inorder(root.right);
            }
        }

        public static Node mirror(Node root){
            if(root == null){
                return null;
            }

            //1. Solve for left and right subtree
            root.left = mirror(root.left);
            root.right = mirror(root.right);

            //2. Swap left and right subtree
            Node temp = root.left;
            root.left = root.right;
            root.right = temp;

            return root;
        }
        

        

    }


    public static void main(String args[]){
        BST tree = new BST();

        tree.insert(4);
        tree.insert(2);
        tree.insert(5);
        tree.insert(1);
        tree.insert(3);
        tree.insert(6);

        tree.inorder(tree.root);
        tree.mirror(tree.root);
        tree.inorder(tree.root);
       
    }
}