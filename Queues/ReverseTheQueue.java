import java.util.*;

public class ReverseTheQueue {
    public static void reverse(Queue<Integer> q){
        Stack<Integer> s = new Stack<>();
        
        while(!q.isEmpty()){
            s.push(q.remove());
        }
        
        while(!s.isEmpty()){
            q.add(s.pop());
        }
    }
    
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        int n = 8; // size of Queue
        for(int i=1; i<=n; i++){
            q.add(i);
        }
        
        reverse(q);
        
        for(int i=1; i<=n; i++){
            System.out.print(q.remove()+" ");
        }
        
    }
    
}
