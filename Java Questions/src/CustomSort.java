
/*

In an array, elements at any two indices can be swapped in a single operation called a move. For example, if
the array is arr = [17, 4, 8), swap arr[O] = 17 and arr(2] = 8 to get arr' = 18, 4, 17) in a single move. Determine the
minimum number of moves required to sort an array such that all of the even elements are at the beginning of the array and all of the odd elements are at the end of the array.

Example
arr = [6, 3, 4, 5J

The following four arrays are valid custom-sorted arrays:
• a = [6, 4, 3, 51
• a = [4, 6, 3, 5)
• a = [6, 4, 5, 3)
• a = [4, 6, 5, 3)

The most efficient sorting requires 1 move: swap the 4 and the 3.

Function Description:
Complete the function moves in the editor below.
moves has the following parameters): int arrini: an array of positive integers

Returns:
int: the minimum number of moves it takes to sort an array of integers with all even elements at earlier indices than any odd element
Note: The order of the elements within even or odd does not matter.

Constraints
• 2≤ n ≤ 10^5
• 1 ≤ arr[i] ≤ 10^9 where O ≤ i < n.
• It is guaranteed that array a contains at least one even and one odd element.

• Input Format for Custom Testing
Input from stdin will be processed as follows and passed to the function.
The first line contains an integer n, the number of elements in array arr.
The next n lines each contain an integer describing arr[i] where O ≤ i < n.
• Sample Case O
Sample Input O
STDIN | Function
--------------
4     -> arr[i] size n = 4
13    -> arr = [13, 10, 21, 20]
10
21
20

Sample Output O
1
Explanation O
Swap arr[O] and arr[3) to get the custom-sorted array arr' = [20, 10, 21, 131 in 1 move.


• Sample Case 1
Sample Input 1
STDIN   | Function
-------------------
5      -> arr[] size n = 5
8      -> arr = [8, 5, 11, 4, 6]
5
11
4
6



Sample Output 1
2

Explanation 1
Perform the following moves on the array:
1. Swap arr[1] and arr[3] to get the array arr' = [8, 4, 11, 5, 6].
2. Swap arr[2] and arr[4] to get the array arr" = [8, 4, 6, 5, 11].
It took two moves to get a valid custom-sorted array. This is minimal.


Input 3:

11
82921272
110219722
162495938
470311130
583170602
329963077
403414481
437623101
485366585
599466263
959094281

Sample Output:
0

*/


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomSort {

    public static int moves(List<Integer> arr) {
        int left = 0;
        int right = arr.size() - 1;
        int moves = 0;

        while (left < right) {
            // Move left forward if it's already even
            while (left < right && arr.get(left) % 2 == 0) {
                left++;
            }

            // Move right backward if it's already odd
            while (left < right && arr.get(right) % 2 != 0) {
                right--;
            }

            // Swap mismatched elements
            if (left < right) {
                int temp = arr.get(left);
                arr.set(left, arr.get(right));
                arr.set(right, temp);
                moves++;
                left++;
                right--;
            }
        }

        return moves;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.add(scanner.nextInt());
        }

        int result = moves(arr);
        System.out.println(result);
    }
}
