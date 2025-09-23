// O(n) space and time

import java.util.Stack;


public class DuplicateParentheses {
    public static boolean hasDuplicateParentheses(String str) { 

        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()) {
            int count = 0;

            // Push operands, operators and '(' into stack
            if (ch != ')') {
                stack.push(ch);
            } else {

                // Count no of operands and operator comes b/t "( )"
                while (!stack.isEmpty() && stack.peek() != '(') {
                    stack.pop();
                    count++;
                }

                if (count > 0) {
                    stack.pop();
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "((a+b))";
        String s2 = "(a+(b)/c)";
        String s3 = "(a+b*(c-d))";

        System.out.println(s1 + " → " + hasDuplicateParentheses(s1));
        System.out.println(s2 + " → " + hasDuplicateParentheses(s2));
        System.out.println(s3 + " → " + hasDuplicateParentheses(s3));
    }
}
