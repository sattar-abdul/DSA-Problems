import java.util.*;

public class DequeUsingJCF {

    public static void main(String[] args) {
        Deque<Integer> dq = new LinkedList<>()
        ;
        dq.addFirst(2); // [1]
        dq.addFirst(1); // [1,2]
        
        dq.addLast(3);  // [1, 2, 3]
        dq.addLast(4);  // [1, 2, 3, 4]
        
        System.out.println(dq.peekFirst());  // 1
        System.out.println(dq.peekLast());  // 4
    
        dq.removeFirst();  // [2, 3, 4]
        dq.removeLast();  // [2, 3]
        
        System.out.println(dq); // [2, 3]
    }
}
