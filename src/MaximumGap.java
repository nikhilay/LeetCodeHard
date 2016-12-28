/**
 * Created by Nikhil on 12/27/16.
 */

import java.util.Arrays;

/**
 * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
 * Try to solve it in linear time/space.
 * Return 0 if the array contains less than 2 elements.
 * You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
 */
public class MaximumGap {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length<2) return 0;
        int min = nums[0];
        int max = nums[0];
        for (int i : nums) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        int[] minArr = new int[nums.length - 1];
        int[] maxArr = new int[nums.length - 1];
        Arrays.fill(minArr, Integer.MAX_VALUE);
        Arrays.fill(maxArr, Integer.MIN_VALUE);
        int gap = (int) Math.ceil((double)(max - min) / (nums.length - 1));
        //puttting values in bucket
        for (int i : nums) {
            if (i == max || i == min) continue;
            int index = (i - min) / gap;
            minArr[index] = Math.min(minArr[index], i);
            maxArr[index] = Math.max(maxArr[index], i);
        }
        int maxGap = Integer.MIN_VALUE;
        int previousMin = min;
        for (int i = 0; i < nums.length-1; i++) {
            if(minArr[i]==Integer.MAX_VALUE && maxArr[i]==Integer.MIN_VALUE) continue;
            maxGap = Math.max(maxGap,minArr[i]-previousMin);
            previousMin = maxArr[i];

        }
        maxGap = Math.max(maxGap,max -previousMin);
        return maxGap;
    }
}
