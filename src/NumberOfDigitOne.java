/**
 * Created by Nikhil on 12/23/16.
 */

/**
 * Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.
 * For example:
 * Given n = 13,
 * Return 6, because digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.
 */

/**
 * Inspired from
 * https://discuss.leetcode.com/topic/27404/my-simple-and-understandable-java-solution
 */
public class NumberOfDigitOne {
    public int countDigitOne(int k) {
        int count = 0;
        int factor = 1;
        int n =k;
        while (n > 0) {
            int m = n/10;
            int r = n%10;
            int amount =0;
            if(r==0){
                amount =0;
            }else if(r>1){
                amount = factor;
            }else{
                amount = k%factor +1;
            }

            count+=m*factor+amount;
            n=n/10;
            factor*=10;

        }


        return count;
    }
}
