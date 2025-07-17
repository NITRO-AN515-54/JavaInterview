
/* Find the index i where the sum of elements on
   the left is equal to the sum of elements on the
   right.

   Input:
   7, 3, 6, 5, 61  */

public class PivotIndexFinder {
    public static int findPivotIndex(int[] arr) {
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }

        int leftSum = 0;
        for (int i = 0; i < arr.length; i++) {
            int rightSum = totalSum - leftSum - arr[i];
            if (leftSum == rightSum) {
                return i;
            }
            leftSum += arr[i];
        }

        return -1; // If no pivot index found
    }

    public static void main(String[] args) {
        int[] input = {7, 3, 6, 5, 61};
        int pivotIndex = findPivotIndex(input);

        if (pivotIndex != -1) {
            System.out.println("Pivot index found at: " + pivotIndex);
        } else {
            System.out.println("No pivot index found.");
        }
    }
}
