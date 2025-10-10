public class UnivaluedBinaryTree{
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

        public static boolean helper(TreeNode root, int value){
            // base case
            if(root == null){
                return true;
            }

            boolean left = helper(root.left, value) && root.val == value;
            boolean right = helper(root.right, value) && root.val == value;

            return left && right;

        }

        public boolean isUnivalTree(TreeNode root) {
            if(root == null){
                return true;
            }
            int value = root.val;
            return helper(root, value);
        }
    }

        public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(1);
        tree.root.right = new TreeNode(1);
        tree.root.left.left = new TreeNode(1);
        tree.root.left.right = new TreeNode(2);

        System.out.println(tree.isUnivalTree(tree.root));
        
    }
}
