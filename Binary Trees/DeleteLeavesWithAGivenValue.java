public class DeleteLeavesWithAGivenValue {
	static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }
 
    static class BinaryTree {
        TreeNode root;

        public TreeNode removeLeafNodes(TreeNode root, int target) {
	        if(root == null){
	            return null;
	        }
	        root.left = removeLeafNodes(root.left, target);
	        root.right = removeLeafNodes(root.right, target);
	        
	        if(root.left == null && root.right == null && root.val == target){
	            return null; //delte the node
	        }
	    
	        return root;    
	    }

	    public static void preorder(TreeNode root) {
            if (root == null) return;
            System.out.print(root.val + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }


	public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(4);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.left = new TreeNode(6);
        tree.root.right.right = new TreeNode(4);
        

        tree.removeLeafNodes(tree.root, 4);
        tree.preorder(tree.root);
    }
}