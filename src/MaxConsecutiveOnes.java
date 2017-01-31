/**
 * Created by Nikhil on 1/30/17.
 */

/**
 * Given a binary array, find the maximum number of consecutive 1s in this array.
 */

/**
 * Inspired from
 * https://discuss.leetcode.com/topic/75430/easy-java-solution
 */
public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int max =0;
        int count =0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                count++;
                max = Math.max(max,count);
            }else{

                count=0;
            }
        }
        return max;
    }
}
