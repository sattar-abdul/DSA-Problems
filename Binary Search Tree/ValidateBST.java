public class ValidateBST {
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

	    public static boolean isValid(Node root){
	    	// Call another isValid with initial range (-∞, +∞)
	    	return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
	    }

	    public static boolean isValid(Node root, long min, long max){
	    	if(root == null){
	    		return true;
	    	}

	    	if(root.data <= min &&  root.data >= max){
	    		return false;
	    	}

	    	boolean leftSubtree = isValid(root.left, min, root.data);
	    	boolean rightSubtree = isValid(root.right, root.data, max);

	    	return leftSubtree && rightSubtree;
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

        System.out.println(tree.isValid(tree.root));

    }
}