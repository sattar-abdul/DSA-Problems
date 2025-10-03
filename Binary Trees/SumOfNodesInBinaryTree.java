public class SumOfNodesInBinaryTree{
	static class Node{
		int data;
		Node left, right;

		Node(int data){
			this.data = data;
			left = right = null;
		}
	}

	public static class BinaryTree{
		Node root;

		public static int sumOfNodes(Node root){
			// Base case
			if(root == null){
				return 0;
			}

			int leftSum = sumOfNodes(root.left);
			int rightSum = sumOfNodes(root.right);

			int sum = leftSum + rightSum + root.data;

			return sum;
		}
	}

	public static void main(String args[]){
		BinaryTree tree = new BinaryTree();

		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);

		System.out.println("Sum of Nodes= " + tree.sumOfNodes(tree.root));

	}
}