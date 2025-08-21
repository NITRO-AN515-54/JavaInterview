
/*

Count occurrences of each value, then place them in sorted order.

Time Complexity :- O(n + k) (where n = number of elements, k = range of input values)
Space Complexity :- O(n + k)

 */

package CoreConcept.Sorting;

public class CountingSort {

    public static void countingSort(int[] arr) {
        if (arr.length == 0) return;

        // Step 1: Find the maximum value
        int max = arr[0];
        for (int num : arr) {
            if (num > max) max = num;
        }

        // Step 2: Initialize count array
        int[] count = new int[max + 1];

        // Step 3: Store frequency of each element
        for (int num : arr) {
            count[num]++;
        }

        // Step 4: Modify count array (prefix sums)
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // Step 5: Build output array (stable sorting)
        int[] output = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }

        // Step 6: Copy back to original array
        System.arraycopy(output, 0, arr, 0, arr.length);
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 8, 3, 3, 1};
        System.out.println("Original Array: ");
        for (int num : arr) System.out.print(num + " ");

        countingSort(arr);

        System.out.println("\nSorted Array: ");
        for (int num : arr) System.out.print(num + " ");
    }
}

