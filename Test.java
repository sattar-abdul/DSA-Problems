import java.util.*;

public class Test {
       static class BinaryTree {
            Node root;

            public Node lca(Node root, int n1, int n2) {
                if(root = null || root.data = n1 || root.data = n2)

                Node leftLca = lca(root.left, n1, n2);
                Node rightLca = lca(root.right, n1, n2);

                if(leftLca != null && rightLca != null){
                    return root;
                }

                return (leftLca != null)? leftLca : rightLca;
            }
       }


    public static void main(String args[]){
       C c = new C();
       c.greet();
    }
}