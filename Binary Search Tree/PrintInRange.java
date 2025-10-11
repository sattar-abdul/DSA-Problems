public class PrintInRange {
	static class Node{
		int data;
		Node left, right;

		Node(int data){
			this.data = data;
			left = right = null;
		}
	}

	static class BST{
		Node root;

		void insert(int data){
			root = insertRec(root, data);
		}

		Node insertRec(Node root, int data){
			Node newNode = new Node(data);

			// IF BST is empty
			if(root == null){
				root = newNode;
			}

			if(data < root.data){
				root.left = insertRec(root.left, data);
			} else if (data > root.data) {
				root.right = insertRec(root.right, data);
			}

			return root;
		}

		public static void printInRange(Node root, int X, int Y){
			if(root == null){
				return;
			}

			// If current node value > X, left subtree may have values in range
			if(X < root.data){
				printInRange(root.left, X, Y);
			}

			// If current node value in range, print it
			if(X <= root.data && root.data <= Y){
				System.out.println(root.data+" ");
			}

			// If current node value < Y, right subtree may have values in range
			if(root.data < Y){
				printInRange(root.right, X, Y);
			}


		}

	}

	public static void main(String[] args) {
        BST tree = new BST();

        tree.insert(4);
        tree.insert(2);
        tree.insert(1);
        tree.insert(3);
        tree.insert(6);
        tree.insert(5);
        tree.insert(7);

        tree.printInRange(tree.root, 3, 7);

    }
}