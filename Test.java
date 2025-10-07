import java.util.*;

public class Test {
    static class Node{
        int data;
        Node left, right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }

    public static class BinaryTree{
        static class TreeInfo{
            int height;
            int diameter;

            TreeInfo(int h, int d){
                this.height=h;
                this.diameter=d;
            }
        }

        static class Info{
            Node node;
            int HD;

            Info(Node node, int HD){
                this.node=node;
                this.HD=HD;
            }
        }

        public void printKthLevel(Node root, int k, int level) {
            if(root == null){
                return;
            }

            if(k == level){
                System.out.println(root.data+" ");
                return;
            }

            printKthLevel(root.left, k, level+1);
            printKthLevel(root.right, k, level+1);
                 
        }

        public static void topView(Node root){
            HashMap<Integer, Integer> map = new HashMap<>();
            Queue<Info> q = new ArrayDeque<>();
            int min = 0, max = 0;

            q.add(new Info(root, 0));

            // BFS traversal
            while(!q.isEmpty()){
                Info curr = q.poll();
                
                map.put(curr.HD, curr.node.data);
                

                if(curr.node.left != null){
                    q.add(new Info(curr.node.left, curr.HD-1));
                    min = Math.min(min, curr.HD-1);
                }
                if(curr.node.right != null){
                    q.add(new Info(curr.node.right, curr.HD+1));
                    max = Math.max(max, curr.HD+1);
                }
            }

            for(int i=min; i<=max; i++){
                System.out.println(map.get(i)+" ");
            }
        }
         
         public static int height(Node root){
            if(root == null){
                return 0;
            }

            int leftHeight = height(root.left);
            int rightHeight = height(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
         }

         public static int diameter(Node root){
            if(root == null){
                return 0;
            }

            int lh = height(root.left);
            int rh = height(root.right);
            int ld = diameter(root.left);
            int rd = diameter(root.right);

            int selfd = Math.max(Math.max(ld, rd), lh+rh+1);
            return selfd;
         }

         public static TreeInfo diameter2(Node root){
            if(root == null){
                return new TreeInfo(0, 0);
            }

            TreeInfo left = diameter2(root.left);
            TreeInfo right = diameter2(root.right);

            int height = Math.max(left.height, right.height) + 1;
            int diaThroughRoot = left.height+right.height+1;
            int dia = Math.max(Math.max(left.diameter, right.diameter), diaThroughRoot);

            return new TreeInfo(height, dia);
         }


         public static boolean isSubtree(Node t1, Node t2){
            if(t2 == null){
                return true;
            }

            if(t1 == null && t2 != null){
                return false;
            }

            if(isIdentical(t1, t2)){
                return true;
            }   

            return isIdentical(t1.left, t2) || isIdentical(t1.right, t2);

         }

         public static boolean isIdentical(Node t1, Node t2){
            if(t1 == null && t2 == null){
                return true;
            }

            if(t1 == null || t2 == null){
                return false;
            }

            if(t1.data != t2.data){
                return false;
            }

            boolean left = isIdentical(t1.left, t2.left);
            boolean right = isIdentical(t1.right, t2.right);

            return left && right;
         }

         public static int lca(Node root, int n1, int n2){
            ArrayList<Integer> path1 = new ArrayList<>();
            ArrayList<Integer> path2 = new ArrayList<>();

            getPath(root, n1, path1);
            getPath(root, n2, path2);


            int i = 0;
            for(; i<path1.size() && i<path2.size(); i++){
                if(path1.get(i) != path2.get(i)){
                    break;
                }
            }

            int lca = path1.get(i-1); 
            return lca;
         }

         public static boolean getPath(Node root,int n,ArrayList<Integer> path){
            if(root == null){
                return false;
            }

            path.add(root.data);
            if(root.data == n){
               return true; // node found
            }

            boolean left = getPath(root.left, n, path);
            boolean right = getPath(root.right, n, path);

            if(left || right){
                return true;
            }
            path.remove(path.size()-1);
            return false;
         }
    }

        private static int keyFinder(int arr[], int key, int idx){
            if(idx >= arr.length){
                return -1;
            }

            if(arr[idx] == key){
                return idx;
            }

            return keyFinder(arr, key, idx+1);
        }

    public static int linearSearch(int arr[], int key){
        return keyFinder(arr, key, 0);
    }

    public static int binarySearch(int arr[], int key){
        int left=0;
        int right=arr.length-1;

        while(left<=right){
            int mid = left + (right-left)/2;

            if(arr[mid] == key){
                return mid;
            }

            if(arr[mid] > key){
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return -1;
    }

    public static void reverseArray(int arr[]){
        int n = arr.length;

        for(int i=0; i<n/2; i++){
            int temp = arr[i];
            arr[i] = arr[n-1-i];
            arr[n-1-i] = temp;
        }
    }

    
    public static void main(String[] args) {
        
        BinaryTree tree = new BinaryTree();

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        int arr[] = {1,2,3,4,5};
        reverseArray(arr);
        for(int el: arr){
            System.out.println(el+" ");    
        }
        
    }
}