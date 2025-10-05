public class KthLevelOfTree {
	static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static class BinaryTree {
        Node root;

        public void printKthLevel(Node root, int k, int level) {
        	// Base case
        	if(root == null){
        		return;
        	}

        	// If current level == k, print the node
        	if(k == level){
        		System.out.print(root.data+" ");
        		return;
        	}

        	// Recurse for left and right subtrees
        	printKthLevel(root.left, k, level+1);
        	printKthLevel(root.right, k, level+1);
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

        int k = 1;
        System.out.print("Nodes at level " + k + ": ");
        tree.printKthLevel(tree.root, k, 1);
    }
}