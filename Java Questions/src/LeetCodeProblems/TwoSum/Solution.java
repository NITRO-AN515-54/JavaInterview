/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]

 */

package LeetCodeProblems.TwoSum;

import java.util.Arrays;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] NewNums = new int[2];
        for(int i = 0; i < nums.length ; i++)
        {
            for(int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i,j};
                }
            }
        }
        return NewNums;
    }

    public static void main(String args[]){
        Solution solution = new Solution();
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        System.out.println("Output 1: " + Arrays.toString(solution.twoSum(nums1, target1)));

        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        System.out.println("Output 2: " + Arrays.toString(solution.twoSum(nums2, target2)));

        int[] nums3 = {3, 3};
        int target3 = 6;
        System.out.println("Output 3: " + Arrays.toString(solution.twoSum(nums3, target3)));
    }
}