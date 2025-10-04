public class DiameterOfBinaryTreeOptimized{
	static class Node {
	    int data;
	    Node left, right;

	    Node(int data) {
	        this.data = data;
	        left = right = null;
	    }
	}

	public static class BinaryTree{
		Node root;

		// Helper class to store height and diameter together
		static class TreeInfo {
            int height;
            int diameter;

            TreeInfo(int height, int diameter) {
                this.height = height;
                this.diameter = diameter;
            }
        }

        // Recursive function returning both height and diameter
		public TreeInfo diameter(Node root){
			if(root == null){
				return new TreeInfo(0, 0);
			}

			TreeInfo left = diameter(root.left);
			TreeInfo right = diameter(root.right);

			int myHeight = Math.max(left.height, right.height) + 1;
			
			int diaThroughRoot = left.height + right.height + 1;

			// Max of (left dia, right dia, dia through root)
            int myDia = Math.max(Math.max(left.diameter, right.diameter), diaThroughRoot);

            return new TreeInfo(myHeight, myDia);


			
		}

	}

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();

		// Create Tree
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.right = new Node(6);

		System.out.println(tree.diameter(tree.root).diameter);
	}
}