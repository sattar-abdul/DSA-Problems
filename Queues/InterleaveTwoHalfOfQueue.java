import java.util.*;

public class InterleaveTwoHalfOfQueue {
    public static void interleave(Queue<Integer> q){
        int size = q.size();
        Queue<Integer> tempQ = new LinkedList<>();
        
        // move half element to Q2
        for(int i=0; i<size/2; i++){
            tempQ.add(q.remove());
        }
        
        //Alternatively push element to q
        while(!tempQ.isEmpty()){
            q.add(tempQ.remove());
            q.add(q.remove());
        }
    }
    
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        int n = 8; // size of Queue
        for(int i=1; i<=n; i++){
            q.add(i);
        }
        
         System.out.println();
        
        interleave(q);
        
        for(int i=1; i<=n; i++){
            System.out.print(q.remove()+" ");
        }
        
    }
    
}
