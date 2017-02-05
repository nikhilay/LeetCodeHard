/**
 * Created by Nikhil on 1/29/17.
 */

/**
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the
 * very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 */

import java.util.ArrayDeque;
import java.util.Deque;
/**
 * Inspired from
 * https://discuss.leetcode.com/topic/19055/java-o-n-solution-using-deque-with-explanation/2
 */
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) return new int[0];
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int index = 0;
        Deque<Integer> dequeue = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            // remove numbers out of range k
            while (!dequeue.isEmpty() && dequeue.peek() < i - k + 1) {
                dequeue.poll();
            }
            // remove smaller numbers in k range as they are useless
            while (!dequeue.isEmpty() && nums[dequeue.peekLast()] < nums[i]) {
                dequeue.pollLast();
            }

            dequeue.offer(i);
            if (i >= k - 1) res[index++] = nums[dequeue.peek()];
        }
        return res;
    }
}
