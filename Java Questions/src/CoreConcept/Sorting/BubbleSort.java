/*

Repeatedly swap adjacent elements if they are in the wrong order.

Time Complexity :- O(n²))
Space Complexity :- O(1)

 */

package CoreConcept.Sorting;

public class BubbleSort {
    // Bubble Sort method
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        // Outer loop - runs (n-1) times
        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            // Inner loop - compare adjacent elements
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swapped = true;
                }
            }

            // If no elements were swapped, array is already sorted
            if (!swapped) break;
        }
    }

    // Main method to test
    public static void main(String[] args) {
        int[] numbers = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("Before Sorting:");
        for (int num : numbers) {
            System.out.print(num + " ");
        }

        bubbleSort(numbers);

        System.out.println("\n\nAfter Sorting:");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
    }
}
