/**
 * Created by Nikhil on 1/28/17.
 */

/**
 * Validate if a given string is numeric.
 * Some examples:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 */

/**
 * Inspired from
 * https://discuss.leetcode.com/topic/9490/clear-java-solution-with-ifs
 */
public class ValidNumber {
    public boolean isNumber(String s) {
        boolean pointSeen = false;
        boolean numSeen = false;
        boolean eSeen = false;
        boolean numAfESeen = false;
        s = s.trim();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                numSeen = true;
                numAfESeen = true;
            } else if (c == '.') {
                if (pointSeen || eSeen) {
                    return false;
                }
                pointSeen = true;
            } else if (c == 'e') {
                if (eSeen || !numSeen) return false;
                numAfESeen = false;
                eSeen = true;
            } else if (c == '+' || c == '-') {
                if (i != 0 && s.charAt(i - 1) != 'e') return false;
            } else {
                return false;
            }
        }
        return numAfESeen && numAfESeen;
    }
}
