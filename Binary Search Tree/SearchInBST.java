public class SearchInBST {
	static class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
			left = right = null;
		}
	}

	
	static class BST {
		Node root;

		// Same as Binary Search
		boolean search(Node root, int key){
			if(root == null){
				return false; // Element not found
			}

			if(root.data == key){
				return true;
			} else if (key < root.data){
				return search(root.left, key);
			} else {
				return search(root.right, key);
			}
		}
	}

	public static void main(String[] args) {
        BST tree = new BST();

        tree.root = new Node(4);
        tree.root.left = new Node(2);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);
        tree.root.right = new Node(5);
        tree.root.right.right = new Node(6);
        
        System.out.println(tree.search(tree.root, 7));
    }

}