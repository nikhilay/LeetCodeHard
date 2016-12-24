/**
 * Created by Nikhil on 12/22/16.
 */

/**
 * Implement regular expression matching with support for '.' and '*'.
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "a*") → true
 * isMatch("aa", ".*") → true
 * isMatch("ab", ".*") → true
 * isMatch("aab", "c*a*b") → true
 */
public class RegularExpressionMatching {
    public boolean isMatch(String str, String re) {
        boolean[][] dp = new boolean[str.length() + 1][re.length() + 1];
        dp[0][0] = true;
        for (int j = 1; j < dp[0].length; j++) {
            if (re.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (str.charAt(i - 1) == re.charAt(j - 1) || re.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (re.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2];
                    if (str.charAt(i - 1) == re.charAt(j - 2) || re.charAt(j - 2) == '.') {
                        dp[i][j] = dp[i][j] | dp[i - 1][j];
                    }

                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[str.length()][re.length()];

    }
}

