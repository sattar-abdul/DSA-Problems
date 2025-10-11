public class DeleteNodeInBST{
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

		public static Node delete(Node root, int value){
			// search for node to be deleted
			if(root.data < value){
				root.right = delete(root.right, value);
			} else if (root.data > value){
				root.left = delete(root.left, value);
			} else {
				// we got the node

				// CASE1: Leaf node
				if(root.left == null && root.right == null){
					return null;
				}

				// CASE2: Single child
				if(root.left == null){
					return root.right;
				}

				if( root.right == null){
					return root.left;
				}

				// CASE3: Two child
				Node successor = findInorderSuccessor(root.right);
				root.data = successor.data;
				
				// delete the succssor node
				root.right = delete(root.right, successor.data);


			}
			return root;
		}

		public static Node findInorderSuccessor(Node root){
			while(root.left != null){
				root = root.left;
			}
			return root;
		}

		void inorder(Node root){
			if(root != null){
				inorder(root.left);
				System.out.println(root.data+" ");
				inorder(root.right);
			}
		}
	}

	public static void main(String[] args) {
        BST tree = new BST();

        tree.root = new Node(4);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);
        tree.root.right.right = new Node(6);

        tree.inorder(tree.root);
        tree.delete(tree.root, 2);
        tree.inorder(tree.root);

    }
}
