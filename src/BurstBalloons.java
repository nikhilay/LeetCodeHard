/**
 * Created by Nikhil on 1/28/17.
 */

public class BurstBalloons {
    /**
     * Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.

     Find the maximum coins you can collect by bursting the balloons wisely.

     Note:
     (1) You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
     (2) 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
     */

    /**
     * Inspired from
     * https://www.youtube.com/watch?v=IFNibRVgFBo&t=61s
     */
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[][] memo = new int[nums.length][nums.length];
        for (int len = 1; len <= nums.length; len++) {
            for (int i = 0; i <= nums.length - len; i++) {
                int j = i + len - 1;
                for (int k = i; k <= j; k++) {
                    int leftValue = 1;
                    int rightValue = 1;
                    if (i != 0) {
                        leftValue = nums[i - 1];
                    }
                    if (j != nums.length - 1) {
                        rightValue = nums[j + 1];
                    }

                    int after = 0;
                    int before = 0;
                    if (i != k) {
                        before = memo[i][k - 1];
                    }
                    if (j != k) {
                        after = memo[k + 1][j];
                    }

                    memo[i][j] = Math.max(memo[i][j], leftValue * nums[k] * rightValue + after + before);


                }
            }


        }
        return memo[0][nums.length - 1];
    }
}
