import java.util.*;

public class TopViewOfBinaryTree {
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

		static class Info {
			Node node;
			int hd;

			Info(Node node, int hd) {
				this.node = node;
				this.hd = hd;
			}
		}

		public static void topView(Node root) {
			if(root == null){
				return;
			}

			Queue<Info> q = new ArrayDeque<>();
			HashMap<Integer, Node> map = new HashMap<>();

			int min = 0, max = 0; // Keep track of min and max HD


			// Level Order Traversal 
			q.add(new Info(root, 0));  // HD of root is 0

			while(!q.isEmpty()) {
				Info curr = q.remove();
				if(curr == null) {
					if(q.isEmpty()){
						break;
					} else {
						q.add(null);
					}
				}

				if(!map.containsKey(curr.hd)) { // first time HD is occuring
					map.put(curr.hd, curr.node);
				}

				if(curr.node.left != null){
					q.add(new Info(curr.node.left, curr.hd-1));
					min = Math.min(min, curr.hd-1);

				}

				if(curr.node.right != null){
					q.add(new Info(curr.node.right, curr.hd+1));
					max = Math.max(max, curr.hd+1);
				}
			}

			// Print top view
			for(int i=min; i<=max; i++) {
				System.out.print(map.get(i).data + " ");
			}

		}
	}
	

	public static void main(String args[]){
		BinaryTree tree = new BinaryTree();

		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);

		tree.topView(tree.root);

	}
}