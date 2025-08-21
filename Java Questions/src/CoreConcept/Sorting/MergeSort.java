/*

Divide the array into halves, sort recursively, then merge them

Time Complexity :- O(n log n)
Space Complexity :- O(n)

 */

package CoreConcept.Sorting;

public class MergeSort {

    // Main merge sort function
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            // Find the middle point
            int mid = (left + right) / 2;

            // Recursively sort first and second halves
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            // Merge the sorted halves
            merge(arr, left, mid, right);
        }
    }

    // Function to merge two subarrays
    public static void merge(int[] arr, int left, int mid, int right) {
        // Sizes of subarrays
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Temporary arrays
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[mid + 1 + j];
        }

        // Merge temp arrays back into arr
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[]
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[]
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Test the Merge Sort
    public static void main(String[] args) {
        int[] numbers = {38, 27, 43, 3, 9, 82, 10};

        System.out.println("Before Sorting:");
        for (int num : numbers) {
            System.out.print(num + " ");
        }

        mergeSort(numbers, 0, numbers.length - 1);

        System.out.println("\n\nAfter Sorting:");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
    }
}
