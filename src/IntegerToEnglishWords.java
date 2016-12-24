/**
 * Created by Nikhil on 12/24/16.
 * <p>
 * Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.
 * For example,
 * 123 -> "One Hundred Twenty Three"
 * 12345 -> "Twelve Thousand Three Hundred Forty Five"
 * 1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 */

/**
 * Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.
 * For example,
 * 123 -> "One Hundred Twenty Three"
 * 12345 -> "Twelve Thousand Three Hundred Forty Five"
 * 1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 */

/**
 * Inspired from
 * https://discuss.leetcode.com/topic/30488/short-clean-java-solution
 */
public class IntegerToEnglishWords {
    private final String[] belowTen = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private final String[] belowTwenty = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",
            "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] belowHundred = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        return helper(num);

    }

    private String helper(int num) {
        StringBuilder sb = new StringBuilder();
        if (num == 0) return "";
        else if (num < 10) sb.append(belowTen[num]);
        else if (num < 20) sb.append(belowTwenty[num - 10]);
        else if (num < 100) sb.append(belowHundred[num / 10] + " " + helper(num % 10));
        else if (num < 1000) sb.append(helper(num / 100) + " Hundred " + helper(num % 100));
        else if (num < 1000000) sb.append(helper(num / 1000) + " Thousand " + helper(num % 1000));
        else if (num < 1000000000) sb.append(helper(num / 1000000) + " Million " + helper(num % 1000000));
        else sb.append(helper(num / 1000000000) + " Billion " + helper(num % 1000000000));
        return sb.toString().trim();
    }
}
