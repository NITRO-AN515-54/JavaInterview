package LeetCodeProblems.LongestSubstringWithoutRepeatingCharacters;/*

/*

Given a string s, find the length of the longest substring without duplicate characters.

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

*/

import java.util.HashSet;
import java.util.Set;

public class LongestSubString {
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> temp = new HashSet<>();
        int left = 0;
        int totalLength = 0;

        for (int right = 0; right < s.length(); right++) {
            while (temp.contains(s.charAt(right))) {
                temp.remove(s.charAt(left));
                left++;
            }
            temp.add(s.charAt(right));
            totalLength = Math.max(totalLength, right - left + 1);
        }

        return totalLength;
    }

    public static void main (String arrgs[]){
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
