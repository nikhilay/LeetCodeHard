/**
 * Created by Nikhil on 12/24/16.
 */

/**
 * Given two words word1 and word2, find the minimum number of steps required
 * to convert word1 to word2. (each operation is counted as 1 step.)
 * You have the following 3 operations permitted on a word:
 * a) Insert a character
 * b) Delete a character
 * c) Replace a character
 */
public class EditDistance {
    public int minDistance(String s, String t) {
        int[][] dp = new int[s.length()+1][t.length()+1];
        for(int row = 0;row<=s.length();row++){
            dp[row][0]=row;
        }
        for(int col = 0;col<=t.length();col++){
            dp[0][col]=col;
        }

        for(int row = 1;row<=s.length();row++){
            for(int col = 1;col<=t.length();col++){
                if(s.charAt(row-1)==t.charAt(col-1)){
                    dp[row][col] = dp[row-1][col-1];
                }else{
                    dp[row][col] = Math.min(dp[row-1][col-1],Math.min(dp[row-1][col],dp[row][col-1]))+1;
                }

            }

        }

        return dp[s.length()][t.length()];

    }
}
