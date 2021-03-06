/**
 * Created by Nikhil on 1/28/17.
 */


import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a list of unique words, find all pairs of distinct indices (i, j) in the given list, so that
 * the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.
 * Example 1:
 * Given words = ["bat", "tab", "cat"]
 * Return [[0, 1], [1, 0]]
 * The palindromes are ["battab", "tabbat"]
 * Example 2:
 * Given words = ["abcd", "dcba", "lls", "s", "sssll"]
 * Return [[0, 1], [1, 0], [3, 2], [2, 4]]
 * The palindromes are ["dcbaabcd", "abcddcba", "slls", "llssssll"]
 */

/**
 * Inspired from
 * https://discuss.leetcode.com/topic/41477/the-easy-to-unserstand-java-solution/2
 */
public class PalindromePairs {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new LinkedList<>();
        if (words == null || words.length == 0) return res;
        //build the map save the key-val pairs: String - idx
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }
        //special cases: "" can be combine with any palindrome string
        if (map.containsKey("")) {
            for (int i = 0; i < words.length; i++) {
                if (words[i].equals("")) continue;
                if (isPalindrome(words[i])) {
                    res.add(Arrays.asList(map.get(""), i));
                    res.add(Arrays.asList(i, map.get("")));
                }
            }
        }
        //find all string and reverse string pairs
        for (int i = 0; i < words.length; i++) {
            String revWord = reverse(words[i]);
            if (map.containsKey(revWord) && map.get(revWord) != i) {
                res.add(Arrays.asList(i, map.get(revWord)));
            }

        }
        //find the pair s1, s2 that
        //case1 : s1[0:cut] is palindrome and s1[cut+1:] = reverse(s2) => (s2, s1)
        //case2 : s1[cut+1:] is palindrome and s1[0:cut] = reverse(s2) => (s1, s2)
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int cut = 1; cut < word.length(); cut++) {

                if (isPalindrome(word.substring(0, cut))) {
                    String revWord = reverse(word.substring(cut));
                    if (map.containsKey(revWord) && map.get(revWord) != i) {
                        res.add(Arrays.asList(map.get(revWord), i));
                    }
                }
                if (isPalindrome(word.substring(cut))) {
                    String revWord = reverse(word.substring(0, cut));
                    if (map.containsKey(revWord) && map.get(revWord) != i) {
                        res.add(Arrays.asList(i, map.get(revWord)));
                    }
                }
            }
        }
        return res;
    }
    private String reverse(String word){
        StringBuilder sb = new StringBuilder();
        for(int i = word.length()-1;i>=0;i--){
            sb.append(word.charAt(i));
        }
        return sb.toString();
    }

    private boolean isPalindrome(String word) {
        int i = 0;
        int j = word.length() - 1;
        while (i <= j) {
            if (word.charAt(i) != word.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
