import java.util.*;

public class TreeTraversal{
	static class Node{
		int data;
		Node left;
		Node right;

		Node(int data){
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	static class BinaryTree{
		static int index = -1; // common for all recurive call

		// Pre order Traversal
		public static void preorder(Node root){  // O(n)
			
			// Base case
			if(root == null){
				return;
			}
			
			// 1.Print Root
			System.out.print(root.data + " ");

			// 2.Print left subtree
			preorder(root.left);

			// 3.Print right subtree
			preorder(root.right);
		}


		// In order Traversal
		public static void inorder(Node root){  // O(n)
			
			// Base case
			if(root == null){
				return;
			}
			
			// 1.Print left subtree
			inorder(root.left);

			// 2.Print Root
			System.out.print(root.data + " ");

			// 3.Print right subtree
			inorder(root.right);
		}


		// Post order Traversal
		public static void postorder(Node root){  // O(n)
			
			// Base case
			if(root == null){
				return;
			}
			
			// 1.Print left subtree
			postorder(root.left);

			// 2.Print right subtree
			postorder(root.right);

			// 3.Print Root
			System.out.print(root.data + " ");
		}


		// Level order Traversal (BFS)
		public static void levelorder(Node root){  // O(n)
			if(root == null){
				return;
			}

			Queue<Node> q = new ArrayDeque<>();
			q.add(root);
			q.add(null);

			while(!q.isEmpty()){
				Node currNode = q.poll();
				if(currNode == null){
					System.out.println();
					if(q.isEmpty()){
						break;
					} else {
						q.add(null);
					}
				}

				q.add(currNode.left);
				q.add(currNode.right);
				q.add(null);

				System.out.print(currNode.data+" ");
			}
		}

		// Builds a tree using preorder
		public static Node buildTree(int arr[]){ // O(n) 
			index++;

			// base case
			if(arr[index] == -1){
				return null;
			}

			// recursive call
			Node newNode = new Node(arr[index]); 
			newNode.left = buildTree(arr);
			newNode.right = buildTree(arr);

			return newNode;
		}
	}


	public static void main(String[] args) {
        int preorder[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();

        // First build a tree
        Node root = tree.buildTree(preorder);

        // 1. Preorder Traversal
        tree.preorder(root);

        // 2. Inorder Traversal
        tree.inorder(root);

        // 3. Postorder Traversal
        tree.postorder(root);
        
        
	}
}