import java.util.ArrayList;

public class PathsFromRootToLeaf {
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

	    public static void printRootToLeaf(Node root, ArrayList<Integer> path) {

	    	path.add(root.data);

	    	// If leaf node -> print the path
	    	if(root.left == null && root.right == null){
	    		System.out.println(path);
	    	} else {
	    		printRootToLeaf(root.left, path);
	    		printRootToLeaf(root.right, path);
	    	}

	    	path.remove(path.size()-1);
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

        ArrayList<Integer> list = new ArrayList<>();
        tree.printRootToLeaf(tree.root, list);

    }
}