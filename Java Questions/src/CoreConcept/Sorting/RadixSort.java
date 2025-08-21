
/*

Sort numbers digit by digit using a stable sorting method.s

Time Complexity: O(d * (n + k))

        n = number of elements

        d = number of digits

        k = base (10 for decimal numbers)

Space Complexity: O(n + k)

 */

package CoreConcept.Sorting;

public class RadixSort {

    // A utility function to get the maximum value in an array
    private static int getMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) max = num;
        }
        return max;
    }

    // Counting Sort for a specific digit (exp = 1, 10, 100, ...)
    private static void countingSortByDigit(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10]; // base 10 (digits 0-9)

        // Count occurrences of each digit
        for (int num : arr) {
            int digit = (num / exp) % 10;
            count[digit]++;
        }

        // Prefix sum (to get positions)
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build output array (stable)
        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        // Copy output back to arr
        System.arraycopy(output, 0, arr, 0, n);
    }

    // Main Radix Sort function
    public static void radixSort(int[] arr) {
        int max = getMax(arr);

        // Do counting sort for each digit (1, 10, 100, ...)
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortByDigit(arr, exp);
        }
    }

    public static void main(String[] args) {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};

        System.out.println("Original Array:");
        for (int num : arr) System.out.print(num + " ");

        radixSort(arr);

        System.out.println("\nSorted Array:");
        for (int num : arr) System.out.print(num + " ");
    }
}

