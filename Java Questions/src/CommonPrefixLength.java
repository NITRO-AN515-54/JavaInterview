/*
Common Prefix Length
Given a string, split the string into two substrings at every possible point. The rightmost substring is a suffix, and the beginning of the string is the prefix. Determine the lengths of the common prefix between each suffix and the original string. Sum and return the lengths of the common prefixes.
Example
inputs = ['abcabcd"]

Each suffix is compared to the original string.

Remove to leave suffix  | Suffix       | Common Prefix | Length|
----------------------------------------------------------------

"                       |   'abcabcd'  | 'abcabcd'     | 7     |
'a'                     | 'bcabcd'     |   "           | 0     |
'ab'                    |   'cabcd'    |   "           | 0     |
'abc'                   |   'abcd'     |  'abc'        | 3     |
'abca'                  |    'bcd'     |  "            | 0     |
'abcab'                 |   'cd'       |   "           | 0     |
'abcabc'                | 'd'          |   "           | 0     |
----------------------------------------------------------------

The sum is 7 + 0 + 0 + 3 + 0+0+0 = 10.

Function Description
Complete the function commonPrefix in the editor with the following parameters):
string inputs[n]: an array of strings

Returns
int[]: the sums of the common prefix lengths for each test case

Constraints

1 ≤ n ≤ 10
1 ≤ length of inputs[i] ≤ 10^5
Each inputs[i] contains only letters in the range ascii[a-z].
• Input Format For Custom Testing
The first line contains the number of test cases n.
Each of the next n lines contains a string, inputs[i], one for each test case.

• Sample Case O
Sample Input
STDIN   |   Function
----------------
1       →  number of test cases n = 1
ababaa  -> inputs = ['ababaa']

Sample Output
11

Explanation
The suffixes are ['ababaa', 'babaa, 'abaa", 'baa, 'aa', 'a']. The common prefix lengths of each of these suffixes with the original string are [6, O, 3, O, 1, 1], respectively, and they sum to 11.

• Sample Case 1

Sample Input
STDIN | Function
-----------------
1     -> number of test cases n = 1
aa    -> inputs = ['aa']

Sample Output
3

Explanation
The suffixes are ['aa, 'a']. The common prefix lengths of each of these suffixes with the original string are [2, 1] which sum to 3.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CommonPrefixLength {
    public static List<Integer> commonPrefix(List<String> inputs) {
        List<Integer> results = new ArrayList<>();

        for (String s : inputs) {
            int sum = 0;
            int len = s.length();
            for (int i = 0; i < len; i++) {
                String suffix = s.substring(i);
                sum += countCommonPrefix(s, suffix);
            }
            results.add(sum);
        }

        return results;
    }

    private static int countCommonPrefix(String original, String suffix) {
        int count = 0;
        int minLen = Math.min(original.length(), suffix.length());
        for (int i = 0; i < minLen; i++) {
            if (original.charAt(i) != suffix.charAt(i)) {
                break;
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine()); // Number of test cases
        List<String> inputs = new ArrayList<>();

        // Read n strings
        for (int i = 0; i < n; i++) {
            inputs.add(scanner.nextLine());
        }

        // Get results
        List<Integer> result = commonPrefix(inputs);

        // Print results line by line
        for (int sum : result) {
            System.out.println(sum);
        }
    }
}
