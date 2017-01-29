/**
 * Created by Nikhil on 1/28/17.
 */

import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed)
 * parentheses substring.
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 * Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4
 * (())  )()()()()
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int len = s.length();
        int maxLen = 0;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else {
                if (!stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                    stack.pop();
                } else {
                    stack.push(i);
                }

            }
        }

        if (stack.isEmpty()) {
            return len;
        } else {
            int index1 = 0;
            int index2 = len;
            while (!stack.isEmpty()) {
                index1 = stack.pop();
                maxLen = Math.max(maxLen, index2 - index1 - 1);
                index2 = index1;
            }
            maxLen = Math.max(maxLen, index2);


        }
        return maxLen;
    }
}
