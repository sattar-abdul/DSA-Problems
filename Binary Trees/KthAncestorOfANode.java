public class KthAncestorOfANode{

	static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
        }
    }

    static class BinaryTree {
        Node root;
        
        public static int kthAncestor(Node root, int n, int K) {
			if(root == null){
				return -1;
			}


			if(root.data == n){
				return 0;
			}

			int leftDist = kthAncestor(root.left, n, K);
			int rightDist = kthAncestor(root.right, n, K);
        	
			if(leftDist == -1 && rightDist == -1){
				return -1;
			}

			int max = Math.max(leftDist, rightDist); // one will be -1 and other will be a positive no
			if(max+1 == K){
				System.out.println(root.data);
			}

			return max+1;
        }


        
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        int n = 5, k = 3;
        
        tree.kthAncestor(tree.root, n, k );
        
    }
}