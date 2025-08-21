
/*

Distribute elements into buckets, sort each bucket, then combine.

Time Complexity: O(n²)
Space Complexity: O(n + k), where k = number of buckets.

 */

package CoreConcept.Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BucketSort {
    // Bucket Sort for Integers
    public static void bucketSort(int[] arr, int bucketSize) {
        if (arr.length == 0) return;

        // Step 1: Find min and max
        int minValue = arr[0];
        int maxValue = arr[0];
        for (int num : arr) {
            if (num < minValue) minValue = num;
            if (num > maxValue) maxValue = num;
        }

        // Step 2: Calculate number of buckets
        int bucketCount = (maxValue - minValue) / bucketSize + 1;
        @SuppressWarnings("unchecked")
        List<Integer>[] buckets = new List[bucketCount];
        for (int i = 0; i < bucketCount; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Step 3: Distribute elements into buckets
        for (int num : arr) {
            int bucketIndex = (num - minValue) / bucketSize;
            buckets[bucketIndex].add(num);
        }

        // Step 4: Sort each bucket
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
        }

        // Step 5: Concatenate buckets
        int index = 0;
        for (List<Integer> bucket : buckets) {
            for (int num : bucket) {
                arr[index++] = num;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {42, 32, 33, 52, 37, 47, 51};

        System.out.println("Original Array: " + Arrays.toString(arr));
        bucketSort(arr, 5); // bucket size = 5
        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }
}
