import java.util.*;

public class LowestCommonAncestor {
	static class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
			left = right = null;
		}
	}

	static class BinaryTree {
		Node root;

		public static Node lca(Node root, int n1, int n2){
			ArrayList<Node> path1 = new ArrayList<>();
			ArrayList<Node> path2 = new ArrayList<>();

			getPath(root, n1, path1);
			getPath(root, n2, path2);

			// Last common ancestor
			int i = 0;
			for(; i<path1.size() && i<path2.size(); i++ ) {
				if(path1.get(i) != path2.get(i)){
					break;
				}
			}

	
			Node lca = path1.get(i-1); // (i-1) th element contains LCA
			return lca;
		}

		public static boolean getPath(Node root, int n, ArrayList<Node> path) {
			if(root == null){
				return false;
			}

			path.add(root);
			if(root.data == n){
				return true; // node found
			}

			boolean foundLeft = getPath(root.left, n, path);
			boolean foundRight = getPath(root.right, n, path);

			if(foundLeft || foundRight){
				return true;
			}

			path.remove(path.size()-1);
			return false;
		}

	}

	public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        int k = 1;
        System.out.print(tree.lca(tree.root, 4,6).data);
        
    }

}