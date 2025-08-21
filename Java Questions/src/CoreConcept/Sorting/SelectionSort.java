/*

Repeatedly select the smallest element and place it in the correct position.

Time Complexity :- O(n²))
Space Complexity :- O(1)

 */

package CoreConcept.Sorting;

public class SelectionSort {
    // Selection Sort method
    public static void selectionSort(int[] arr) {
        int n = arr.length;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n - 1; i++) {
            // Find the index of minimum element in unsorted array
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the found minimum element with the first element
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    // Main method to test
    public static void main(String[] args) {
        int[] numbers = {64, 25, 12, 22, 11};

        System.out.println("Before Sorting:");
        for (int num : numbers) {
            System.out.print(num + " ");
        }

        selectionSort(numbers);

        System.out.println("\n\nAfter Sorting:");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
    }
}
