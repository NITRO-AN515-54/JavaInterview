/*

Time Complexity :- So total = O(n) + O(n) = O(n)
Space complexity :- O(1)

 */

package CoreConcept.Searching;

public class FirstSecondHeighestValue {
    public static void main(String[] args) {
        int[] arr = {12, 5, 8, 19, 1, 5, 19};

        if (arr.length < 2) {
            System.out.println("Not enough elements!");
            return;
        }

        // Step 1: Find min and max
        int min = arr[0], max = arr[0];
        for (int num : arr) {
            if (num < min) min = num;
            if (num > max) max = num;
        }

        // Step 2: Find second min and second max
        Integer secondMin = null, secondMax = null;
        for (int num : arr) {
            if (num != min) {
                if (secondMin == null || num < secondMin) {
                    secondMin = num;
                }
            }
            if (num != max) {
                if (secondMax == null || num > secondMax) {
                    secondMax = num;
                }
            }
        }

        if (secondMin == null || secondMax == null) {
            System.out.println("Not enough unique elements!");
        } else {
            System.out.println("Second Lowest: " + secondMin);
            System.out.println("Second Highest: " + secondMax);
        }
    }
}
