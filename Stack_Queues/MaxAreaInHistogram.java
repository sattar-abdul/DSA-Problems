import java.util.Stack;

public class MaxAreaInHistogram {

    public static int maxArea(int heights[]) {
        int n = heights.length;
        int pse[] = new int[n]; // previous smaller element
        int nse[] = new int[n]; // next smaller element
        Stack<Integer> stack = new Stack<>();

        // calculate next smaller element
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            nse[i] = stack.isEmpty() ? n : stack.peek(); // put n instead of -1 (right boundary)
            stack.push(i);
        }

        // Reset the stack
        stack.clear();

        // calculate previous smaller element
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            pse[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        // calculate all possible area
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int height = heights[i];
            int width = nse[i] - pse[i] - 1;
            int area = height * width;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = { 2, 1, 5, 6, 2, 3 };
        System.out.println("Maximum Area = " + maxArea(heights));
    }

}
