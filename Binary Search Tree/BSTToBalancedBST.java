import java.util.ArrayList;

public class BSTToBalancedBST {
	static class Node {
		int data;
        Node left, right;

        Node(int data){
            this.data = data;
            left = right = null;
        }
	}

	static class BST {
		void inorder(Node root){
            if(root != null){
                inorder(root.left);
                System.out.print(root.data+" ");
                inorder(root.right);
            }
        }

		// Step 1: Store inorder traversal
		public static void getInorder(Node root, ArrayList<Integer> inorder){
			if(root == null){
				return;
			}

			getInorder(root.left, inorder);
			inorder.add(root.data);
			getInorder(root.right, inorder);
		}

		// Step 2: Build balanced BST from sorted list
		public static Node sortedArrayToBST(ArrayList<Integer> arr, int start, int end){
			// Base case
			if(start > end){
				return null;
			}

			int mid = (start+end)/2;
			Node root = new Node(arr.get(mid));

			root.left = sortedArrayToBST(arr, start, mid-1);
			root.right = sortedArrayToBST(arr, mid+1, end);

			return root;
		}

		// Converts unbalanced BST → balanced BST
		public static Node balanceBST(Node root){
			ArrayList<Integer> inorder = new ArrayList<>();
			getInorder(root, inorder);
			return sortedArrayToBST(inorder, 0, inorder.size()-1);
		}
	}

    public static void main(String[] args) {
	    BST tree = new BST();

	    Node root = new Node(1);
	    root.right = new Node(2);
	    root.right.right = new Node(3);
	    root.right.right.right = new Node(4);

	    System.out.println("Before balancing:");
	    tree.inorder(root);

	    root = tree.balanceBST(root);

	    System.out.println("\nAfter balancing:");
	    tree.inorder(root);
	}
}