public class CreateBST{
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

		void inorder(Node root){
			if(root != null){
				inorder(root.left);
				System.out.println(root.data);
				inorder(root.right);
			}
		}
	}

	public static void main(String[] args) {
        BST tree = new BST();

        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);

        tree.inorder(tree.root); // Output: 20 30 40 50 60 70 80
    }
}