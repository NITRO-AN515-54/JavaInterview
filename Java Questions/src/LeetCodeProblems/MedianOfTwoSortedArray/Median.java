package LeetCodeProblems.MedianOfTwoSortedArray;

import java.util.Arrays;

public class Median {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        int[] combined = new int[totalLength];
        System.arraycopy(nums1, 0,combined,0,nums1.length);
        System.arraycopy(nums2, 0,combined,nums1.length,nums2.length);

        Arrays.sort(combined);

        if (totalLength % 2 == 1) {
            return combined[totalLength / 2];
        } else {
            int midIndex = totalLength / 2;
            return (combined[midIndex - 1] + combined[midIndex]) / 2.0;
        }
    }

    public static void main (String[] args){
        int[] nums1 = {1,3};
        int[] nums2 = {2};

        System.out.println(findMedianSortedArrays(nums1, nums2));

        int[] nums3 = {1,2};
        int[] nums4 = {3,4};

        System.out.println(findMedianSortedArrays(nums3, nums4));
    }
}
