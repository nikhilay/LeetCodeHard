/**
 * Created by Nikhil on 12/25/16.
 */

import java.util.Stack;

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
 */
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int[] buffer = new int[matrix[0].length];
        int maxArea = 0;
        int area = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int number = Integer.valueOf(matrix[i][j]-'0');
                if (number == 0) {
                    buffer[j] = 0;
                } else {
                    buffer[j] += number;
                }
            }
            area = maxRectangleInHistogram(buffer);
            maxArea = Math.max(area, maxArea);

        }
        return maxArea;
    }

    private int maxRectangleInHistogram(int[] input){
        if(input==null ||input.length==0) return 0;
        int maxArea =0;
        int area =0;
        Stack<Integer> stack = new Stack<>();
        int i =0;
        for(i=0;i<input.length;){
            if(stack.isEmpty() || input[stack.peek()]<=input[i]){
                stack.push(i++);
            }else{
                int top = stack.pop();
                if(stack.isEmpty()){
                    area = input[top]*i;
                }else{
                    area = input[top]*(i-stack.peek()-1);
                }
            }
            maxArea = Math.max(area,maxArea);

        }
        while(!stack.isEmpty()){
                int top = stack.pop();
                if(stack.isEmpty()){
                    area = input[top]*i;
                }else{
                    area = input[top]*(i-stack.peek()-1);
                }

            maxArea = Math.max(area,maxArea);
        }

        return maxArea;
    }
}
