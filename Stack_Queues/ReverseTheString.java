// Reverse the string using stack.

import java.util.Stack;

public class ReverseTheString {
    public static String reverseString(String str){
        int idx = 0;
        Stack<Character> s = new Stack<>();

        while(idx < str.length()){
            s.push(str.charAt(idx));
            idx++;
        }

        StringBuilder result = new StringBuilder("");

        while(!s.isEmpty()){
            char ch = s.pop();
            result.append(ch);
        }

        return result.toString();  // since StringBuilder and string are of different type 

    }

    public static void main(String[] args) {
        String str = "abc";
        System.out.println("Original str: " + str);
        str = reverseString(str);
        System.out.println("Reversed str: " + str);
    }
}
