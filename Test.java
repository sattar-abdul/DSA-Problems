import java.util.*;

public class Test {
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

        boolean BSTsearch(int key, Node root){
            if(root == null){
                return false;
            }

            if(root.data == key){
                return true;
            }

            if(key < root.data){
                return BSTsearch(key, root.left);
            } else {
                return BSTsearch(key, root.right);
            }

        }

        Node delete(Node root, int key){
            //search in order
            if(key < root.data){
                root.left = delete(root.left, key);
            } else if(root.data < key){
                root.right = delete(root.right, key);
            } else{
                //we got the node

                //case1 leaf node
                if(root.left == null && root.right == null){
                    return null;
                }

                //case2 one child
                if(root.left == null){
                    return root.right;
                }

                if(root.right == null){
                    return root.left;
                }

                //case3 two child
                Node successor = findInorderSuccessor(root.right);
                root.data = successor.data;
                root.right = delete(root.right, successor.data);

            }

            return root;

        }

        public static Node findInorderSuccessor(Node root){
            while(root.left != null){
                root = root.left;
            }

            return root;
        }

        public static void printRootToLeaf(Node root, ArrayList<Integer> path){
            if(root == null){
                return;
            }

            path.add(root.data);

            if(root.left == null && root.right == null){
                System.out.println(path);
            }

            else{
                printRootToLeaf(root.left, path);
                printRootToLeaf(root.right, path);
            }

            path.remove(path.size()-1);
        }

        public static boolean isValidBST(Node root, int min, int max){
            if(root == null){
                return true;
            }

            if(root.data <= min || root.data >= max){
                return false;
            }

            boolean left = isValidBST(root.left, min, root.data);
            boolean right = isValidBST(root.right, root.data, max);

            return left && right;
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

        System.out.println(tree.isValidBST(tree.root, Integer.MIN_VALUE, Integer.MAX_VALUE));
       
    }
}