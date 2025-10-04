public class DiameterOfBinaryTree{
	static class Node {
	    int data;
	    Node left, right;

	    Node(int data) {
	        this.data = data;
	        left = right = null;
	    }
	}

	public static class BinaryTree{
		Node root;

		public int height(Node root){
			// Base case - Height of tree = 0
			if(root == null){
				return 0;
			}

			int leftHeight = height(root.left);
			int rightHeight = height(root.right);
			int height = Math.max(leftHeight, rightHeight) + 1;

			return height;
		}

		public int diameter(Node root){
			// Base case - Diameter of tree = 0
			if(root == null){
				return 0;
			}

			int leftHeight = height(root.left);
			int rightHeight = height(root.right);

			int leftDia = diameter(root.left);
			int rightDia = diameter(root.right);

			int selfDia = leftHeight + rightHeight + 1;

			return Math.max(selfDia, Math.max(leftDia, rightDia));
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

		System.out.println(tree.diameter(tree.root));
	}
}