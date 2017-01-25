import java.util.Stack;

/**
 * Created by Nikhil on 1/25/17.
 */

/**
 * Implement a basic calculator to evaluate a simple expression string.
 * The expression string may contain open ( and closing parentheses ), the plus + or minus sign -,
 * non-negative integers and empty spaces .
 * You may assume that the given expression is always valid.
 */
public class BasicCalculator {
    public int calculate(String s) {
        int result = 0;
        int num = 0;
        int sign = 1;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == '+') {
                result += sign * num;
                sign = 1;
                num = 0;
            } else if (c == '-') {
                result += sign * num;
                sign = -1;
                num = 0;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;

            } else if (c == ')') {
                result += sign * num;
                result *= stack.pop();
                result += stack.pop();
                num = 0;
            }

        }
        if (num != 0) result = sign * num + result;
        return result;

    }
}
