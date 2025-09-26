import java.util.PriorityQueue;

public class ConnectNRopesWithMinimumCost {
    public static int minCost(int[] ropes) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int cost = 0;

        for (int rope : ropes) {
            pq.add(rope);
        }


        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();


            int newRope = first + second;
            pq.add(newRope);
            cost += newRope;
        }
        return cost;
    }

    public static void main(String[] args) {
        int ropes[] = { 1, 2, 3 };

        System.out.println(minCost(ropes));

    }
}