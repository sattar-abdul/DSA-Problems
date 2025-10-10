import java.util.ArrayList;

public class MinDistanceBetweenNodes {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static class BinaryTree{
        Node root;

        public static boolean path(Node root, int n, ArrayList<Node> path){
            // Find path from "root" to 'n' and put it into "path"
            if(root == null){
                return false;
            }

            path.add(root);

            if(root.data == n){
                return true;
            }

            boolean left = path(root.left, n, path);
            boolean right = path(root.right, n, path);

            if(left || right){
                return true;
            }

            path.remove( path.size()-1 );
            return false;
        }

        public static Node lca(Node root, int n1, int n2){
            ArrayList<Node> path1 = new ArrayList<>();
            ArrayList<Node> path2 = new ArrayList<>();

            path(root, n1, path1);
            path(root, n2, path2);

            int i = 0;
            for(; i<path1.size() && i<path2.size(); i++){
                if(path1.get(i) != path2.get(i)){
                    break;
                }
            }

            return path1.get(i-1); // i-1 index contains lca

        }

        public static int distance(Node root, int n){
            if(root == null){
                return -1;
            }

            if(root.data == n){
                return 0;
            }

            int left = distance(root.left, n);
            int right = distance(root.right, n);

            if(left == -1 && right == -1){
                return -1;
            } 

            if(left != -1){
                return left + 1;
            } else {
                return right + 1;
            }
        }
        
        public static int minDistance(Node root, int n1, int n2){
            // 1. Find lca
            Node lca = lca(root, n1, n2);

            // 2. Find distance between lca and nodes. (n1 and n2)
            int d1 = distance(lca, n1);
            int d2 = distance(lca, n2);

            // 3. return sum of distance
            return d1+d2;
        }


    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        System.out.println("Min Distance (4, 6): " + tree.minDistance(tree.root, 4, 6));
        System.out.println("Min Distance (4, 5): " + tree.minDistance(tree.root, 4, 5));
        System.out.println("Min Distance (3, 4): " + tree.minDistance(tree.root, 3, 4));
    }

}