/*

Pick a pivot, partition elements around it, then sort partitions recursively

Time Complexity :- O(n²) (if pivot is always smallest/largest → unbalanced partitions)
Space Complexity :- O(log n) (recursive stack)

 */

package CoreConcept.Sorting;

public class QuickSort {
    // Partition method
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // choosing last element as pivot
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and pivot
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // QuickSort method
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // Main
    public static void main(String[] args) {
        int[] numbers = {10, 7, 8, 9, 1, 5};

        System.out.println("Before Sorting:");
        for (int n : numbers) System.out.print(n + " ");

        quickSort(numbers, 0, numbers.length - 1);

        System.out.println("\n\nAfter Sorting:");
        for (int n : numbers) System.out.print(n + " ");
    }
}
