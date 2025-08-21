/*

Build a max-heap and repeatedly extract the maximum element.

Time Complexity :- O(n log n)
Space Complexity :- O(1) (in-place)

 */

package CoreConcept.Sorting;

public class HeapSort {
    public void heapSort(int[] arr) {
        int n = arr.length;

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Extract elements from heap
        for (int i = n - 1; i > 0; i--) {
            // Swap arr[0] (max) with arr[i]
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Heapify reduced heap
            heapify(arr, i, 0);
        }
    }

    // Heapify function
    void heapify(int[] arr, int n, int i) {
        int largest = i; // root
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest])
            largest = left;

        if (right < n && arr[right] > arr[largest])
            largest = right;

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }

    // Main
    public static void main(String[] args) {
        int[] numbers = {12, 11, 13, 5, 6, 7};

        System.out.println("Before Sorting:");
        for (int n : numbers) System.out.print(n + " ");

        HeapSort sorter = new HeapSort();
        sorter.heapSort(numbers);

        System.out.println("\n\nAfter Sorting:");
        for (int n : numbers) System.out.print(n + " ");
    }
}
