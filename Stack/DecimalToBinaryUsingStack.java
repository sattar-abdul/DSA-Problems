import java.util.*;

public class DecimalToBinaryUsingStack {

  public static void printDecimalToBinary(int N) {
    Stack<Integer> q = new Stack<>();

    for (int i = 1; i <= N; i++) {
      int temp = i;
      while (temp != 0) {
        int binDigit = temp % 2;
        temp = temp / 2;
        q.push(binDigit);
      }

      while (!q.isEmpty()) {
        System.out.print(q.pop());
      }
      System.out.print(" ");
    }
  }

  public static void main(String[] args) {
    System.out.println("Hello, World!");
    printDecimalToBinary(3);

  }
}