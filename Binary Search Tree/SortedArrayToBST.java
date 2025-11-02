public class SortedArrayToBST {
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

		public static Node sortedArrayToBST(int[] arr, int start, int end){
			// Base case
			if(start > end){
				return null;
			}

			int mid = (start+end)/2;
			Node root = new Node(arr[mid]);

			root.left = sortedArrayToBST(arr, start, mid-1);
			root.right = sortedArrayToBST(arr, mid+1, end);

			return root;
		}

		public static void inorder(Node root){
			if(root == null){
				return;
			}

			inorder(root.left);
			System.out.print(root.data+" ");
			inorder(root.right);
		}
	}

	public static void main (String args[]){
		BST tree = new BST();
		int arr[] = {3,5,6,8,10,11,12};

		tree.root = tree.sortedArrayToBST(arr, 0, 6);
		tree.inorder(tree.root);


	}
}