public class CountNodesInBinaryTree{

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

        public static int countNodes(Node root){
        	//Base case
        	if(root == null){
        		return 0;
        	}

        	int leftCount = countNodes(root.left);
        	int rightCount = countNodes(root.right);

        	int count = leftCount + rightCount + 1;

        	return count;
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Create Tree
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.right = new Node(6);

        System.out.println("Total nodes in tree: " + tree.countNodes(tree.root));

    }
}