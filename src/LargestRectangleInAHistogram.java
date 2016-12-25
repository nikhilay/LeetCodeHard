/**
 * Created by Nikhil on 12/25/16.
 */

import java.util.Stack;

/**
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1,
 * find the area of largest rectangle in the histogram.
 */
public class LargestRectangleInAHistogram {
    public static void main(String[] args) {
        int[] input = {4, 2};
        new LargestRectangleInAHistogram().largestRectangleArea(input);
    }

    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int i = 0;
        int area = 0;
        for (i = 0; i < heights.length; ) {
            if (stack.isEmpty() || heights[stack.peek()] <= heights[i]) {
                stack.push(i++);
            } else {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    area = heights[top] * i;
                } else {
                    area = heights[top] * (i - stack.peek() - 1);
                }
                maxArea = Math.max(area, maxArea);

            }

        }
        while (!stack.isEmpty()) {
            int top = stack.pop();
            if (stack.isEmpty()) {
                area = heights[top] * i;
            } else {
                area = heights[top] * (i - stack.peek() - 1);
            }
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;

    }
}
