
/*

Time Complexity :- O(log n)
Space complexity :- O(1)

 */

package CoreConcept.Searching;

public class BinarySearch {
    // Iterative Binary Search
    public static int binarySearch(int[] arr, int key) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // to avoid overflow

            if (arr[mid] == key) {
                return mid; // found
            } else if (arr[mid] < key) {
                left = mid + 1; // search right half
            } else {
                right = mid - 1; // search left half
            }
        }
        return -1; // not found
    }

    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50, 60, 70};
        int key = 40;

        int result = binarySearch(numbers, key);

        if (result == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element found at index: " + result);
        }
    }
}
