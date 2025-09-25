import java.util.*;

public class DecimalToBinaryUsingQueue {

    public static void printDecimalToBinary(int N) {
        Queue<String> q = new LinkedList<>();

        // Binary of 1 is 1
        q.add("1");
        for (int i = 1; i <= N; i++) {
            String curr = q.remove();
            System.out.print(curr + " ");

            // Append 0 and 1 to generate next binaries
            q.add(curr + "0");
            q.add(curr + "1");

        }

        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("Hello, World!");
        printDecimalToBinary(3);

    }
}
