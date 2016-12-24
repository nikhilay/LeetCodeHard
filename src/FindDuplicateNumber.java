/**
 * Created by Nikhil on 12/23/16.
 */

/**
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at
 * least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
 */

/**
 * Inspired from
 * https://discuss.leetcode.com/topic/25913/my-easy-understood-solution-with-o-n-time-and-o-1-space-without-modifying-the-array-with-clear-explanationD
 */
public class FindDuplicateNumber {
    public int findDuplicate(int[] nums) {

        int slow = nums[0];
        int fast = nums[nums[0]];

        while(slow!=fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        slow = 0;

        while(slow!=fast){
            slow = nums[slow];
            fast = nums[fast];
        }

       return slow;

    }
}
