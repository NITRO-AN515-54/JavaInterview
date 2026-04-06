package LeetCodeProblems.SortColors;

import java.util.Arrays;

class Solution {
    public static int[] sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            if(nums[left] > nums[right]){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
            else{
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                right--;
            }
        }
        return nums;
    }

    public static void main(String[] args){
        int[] nums = {2,0,2,1,1,0};
        System.out.println(Arrays.toString(sortColors(nums)));
    }
}
