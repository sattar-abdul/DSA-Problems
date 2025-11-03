/*
class Node {
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}
*/

class KthSmallestInBST {
    int count = 0;
    int result = -1;
    
    private void inorder(Node root, int k){
        if(root == null){
            return;
        }
        
        inorder(root.left, k);
        
        count++;
        if(count == k){
            result = root.data;
            return ;
        }
        
        inorder(root.right, k);
        
    }
    
    public int kthSmallest(Node root, int k) {
        // Inorder Traversal
        inorder(root, k);
        return result;
    }
}