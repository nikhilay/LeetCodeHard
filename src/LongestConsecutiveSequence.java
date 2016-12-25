import java.util.HashSet;

/**
 * Created by Nikhil on 12/25/16.
 */

/**
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * For example,
 * Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 * Your algorithm should run in O(n) complexity.
 */

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        HashSet<Integer> hset = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            hset.add(nums[i]);
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 1;
            int num = nums[i];
            while (hset.contains(--num)) {
                count++;
                hset.remove(num);
            }
            num = nums[i];
            while (hset.contains(++num)) {
                count++;
                hset.remove(num);
            }
            res = Math.max(count, res);


        }
        return res;
    }
}
