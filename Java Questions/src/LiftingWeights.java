/*

Lifting Weights
An athlete is lifting weights. The barbell has a maximum capacity of maxCapacity. Each barbell plate has a specific weight given by weightlil. Determine the maximum weight of plates that can be added to the barbell without exceeding maxCapacity.
Example
weights = [7, 1, 5, 6, 2]
maxCapacity = 7
There are 3 ways to reach the maximum weight that is optimal: {7}, {1, 6}, and {2, 5}. Return 7.

Function Description
Complete the weightCapacity function in the editor with the following parameters:
int weights[n]: each element is the weight of a plate
maxCapacity: the capacity of the barbell

Returns
int: the maximum weight that can be added
Constraints
• 1≤n≤ 42
• 1≤ maxCapacity ≤ 10^9
• 1 ≤ weights[i][] I≤ 10^9


Input Format For Custom Testing
Locked stub code in the editor reads the following input lasm stdin and passes it to the function:
The first line contains an integer, n, the number of elements in weights.
Each line i of the n subsequent lines contains an integer, weights[i].
The last line contains an integer, maxCapacity.
• Sample Case O
Sample Input O
STDIN | Function
-----------------
3    → weights[] size n = 3
1    → weights [] = [ 1, 3, 5 ]
3
5
7    → maxCapacity = 7


Sample Output 0
6
Explanation O
All the possible combinations of weights are {}, (1}, {3}, {5}, {1, 3}, {1, 5}, {3, 5}, and {1, 3, 5}. Choose {1,5}.

• Sample Case 1
Sample Input 1
STDIN | Function
----------------
4  → weights[] size n = 4
4  → weights [] = [ 4, 8, 5, 9 ]
8
5
9
20 → maxCapacity = 20

Sample Output 1
18

Explanation
All the possible combinations of weights are: {}, {4}, {8}, {5}, {9}, {4, 8}, {4, 5}, {4, 9}, {8, 5}, {8, 9}, {5, 9}, {4, 8, 5}, {4, 8, 9}, {4, 5, 9}, {8, 5, 9}, {4, 8, 5, 9}. Choose {4, 5, 9}.


*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
public class LiftingWeights {
    public static int weightCapacity(List<Integer> weights, int maxCapacity) {
        int n = weights.size();
        List<Integer> left = weights.subList(0, n / 2);
        List<Integer> right = weights.subList(n / 2, n);

        List<Long> leftSums = generateSubsetSums(left);
        List<Long> rightSums = generateSubsetSums(right);

        Collections.sort(rightSums);

        long maxWeight = 0;
        for (long l : leftSums) {
            long remaining = maxCapacity - l;
            if (remaining < 0) continue;

            int idx = upperBound(rightSums, remaining);
            if (idx >= 0) {
                long total = l + rightSums.get(idx);
                if (total <= maxCapacity) {
                    maxWeight = Math.max(maxWeight, total);
                }
            }
        }

        return (int) maxWeight;
    }

    private static List<Long> generateSubsetSums(List<Integer> arr) {
        int size = arr.size();
        List<Long> sums = new ArrayList<>();
        int totalComb = 1 << size;
        for (int mask = 0; mask < totalComb; mask++) {
            long sum = 0;
            for (int i = 0; i < size; i++) {
                if ((mask & (1 << i)) != 0) {
                    sum += arr.get(i);
                }
            }
            sums.add(sum);
        }
        return sums;
    }

    // Finds the largest index where value <= key
    private static int upperBound(List<Long> list, long key) {
        int low = 0, high = list.size() - 1, ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (list.get(mid) <= key) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    // Example usage
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> weights = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            weights.add(sc.nextInt());
        }
        int maxCapacity = sc.nextInt();
        System.out.println(weightCapacity(weights, maxCapacity));
    }
}
