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

package LeetCodeProblems.LongestSubstringWithoutRepeatingCharacters;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {

        Set<Character> charSet = new HashSet<>();

        int maxLength = 0;
        int left = 0;

        for(int right = 0 ; right < s.length() ; right++){

            while(charSet.contains(s.charAt(right)))
            {
                charSet.remove(s.charAt(left));
                left ++;
            }

            charSet.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    public static void main(String arrgs[])
    {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        Solution obj = new Solution();
        System.out.print(obj.lengthOfLongestSubstring(s));
    }
}
