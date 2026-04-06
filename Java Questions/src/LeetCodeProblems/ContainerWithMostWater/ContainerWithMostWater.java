package LeetCodeProblems.ContainerWithMostWater;

public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while(left < right){
            int width = right - left;
            int heightVslue = Math.min(height[right], height[left]);
            int area = width*heightVslue;

            maxArea = Math.max(maxArea, area);

            if(height[left] < height[right]){
                left++;
            } else {
                right-- ;
            }
        }

        return maxArea;
    }

    public static void main(String arrgs[]){
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.print(maxArea(height));
    }
}
