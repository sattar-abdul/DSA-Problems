public class SubtreeOfAnotherTree {
    static class Node{
    	int data;
    	Node left, right;

    	Node(int data) {
        	this.data = data;
        	left = right = null;
    	}
    }

    static class BinaryTree {
        Node root;

        // Check if two tree are identical
        public static boolean isIdentical(Node root1, Node root2){
            if(root1 == null && root2 == null){
                return true;
            }

            if(root1 == null || root2 == null){
                return false;
            }

            if(root1.data != root2.data){
                return false;
            }

            boolean left = isIdentical(root1.left, root2.left);
            boolean right = isIdentical(root1.right, root2.right);

            return left && right;
        }

        // Check id T2 is a subtree of T1
        public static boolean isSubTree(Node T1, Node T2){
            if (T2 == null){
                return true; // empty tree is always a subtree
            }

            if (isIdentical(T1, T2)){
                return true;
            }

            // Check left and right subtrees
            return isSubTree(T1.left, T2) || isSubTree(T1.right, T2);
        }

    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Main Tree T1
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        // Subtree T2
        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(5);

        System.out.println(tree.isSubTree(tree.root, subRoot));
    }
}