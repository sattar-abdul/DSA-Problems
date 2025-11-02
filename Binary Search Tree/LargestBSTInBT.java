public class LargestBSTInBT {
	static class Node {
	    int data;
	    Node left, right;
	    Node(int data) {
	        this.data = data;
	        left = right = null;
	    }
	}

	static class Info {
	    boolean isBST;
	    int size;
	    int min, max;

	    Info(boolean isBST, int size, int min, int max) {
	        this.isBST = isBST;
	        this.size = size;
	        this.min = min;
	        this.max = max;
	    }
	}

	static class BT {
		Node root;
		static int maxSize = 0;

		public static Info largestBST(Node root){
			if(root == null){
				return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);  // ❗min = +∞, max = -∞ 
			}

			Info left = largestBST(root.left);
			Info right = largestBST(root.right);

			if(left.isBST && right.isBST && root.data > left.max && root.data < right.min){
				int size = left.size + right.size + 1;
				int min = Math.min(root.data, left.min);
				int max = Math.max(root.data, right.max);
				maxSize = Math.max(maxSize, size);
				return new Info(true, size, min, max);

			}

			// Not a BST
			return new Info(false, 0, 0, 0);
		}
	}

	public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(30);
        root.left.left = new Node(5);
        root.left.right = new Node(20);
        root.right = new Node(60);
        root.right.left = new Node(45);
        root.right.right = new Node(70);
        root.right.right.left = new Node(65);
        root.right.right.right = new Node(80);

        BT tree = new BT();

        tree.largestBST(root);
        System.out.println("Size of largest BST: " + tree.maxSize);
    }
}