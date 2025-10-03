public class BuildTreeUsingPreorder{
	static class Node{
		int data;
		Node left;
		Node right;

		Node(int data){
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	static class BinaryTree{
		static int index = -1; // common for all recurive call

		public static Node buildTree(int arr[]){
			index++;

			// base case
			if(arr[index] == -1){
				return null;
			}

			// recursive call
			Node newNode = new Node(arr[index]); // root
			newNode.left = buildTree(arr); // Build left subtree
			newNode.right = buildTree(arr); // Build right subtree

			return newNode;
		}
	}

		public static void main(String[] args) {
        int preorder[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();

        Node root = tree.buildTree(preorder);
        
        System.out.println(root.data+" "+root.left.data+ " " +root.right.data);
	}
}