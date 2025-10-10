public class TransformToSumTree {

	static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
        }
    }

    static class BinaryTree {
        Node root;
        
        public static int transform(Node root){
        	// Base case
        	if(root == null){
        		return 0;
        	}

        	// 2. calculate left and right sum
        	int leftSum = transform(root.left);
        	int rightSum = transform(root.right);

        	int temp = root.data; // store node's value

        	root.data = leftSum + rightSum;

        	return root.data + temp;
        }

        public static void preorder(Node root) {
            if (root == null) return;
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
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

        tree.transform(tree.root);
        tree.preorder(tree.root);
        
    }

}