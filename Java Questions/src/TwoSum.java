public class TwoSum {
        public int[] solution(int[] nums, int target) {
            int[] a = new int[2];
            for(int i = 0; i <= nums.length; i++)
            {
                for(int j = 1; j < nums.length; j++)
                {
                    int sum = nums[i] + nums[j];
                    if(sum == target)
                    {
                        a[0] = i;
                        a[1] = j;
                        return a;
                    }
                }
            }
            return a;
        }
    public static void main(String[] args) {
        TwoSum a = new TwoSum();
        int[] data = new int[4];
        data[0] = 2;
        data[1] = 7;
        data[2] = 11;
        data[3] = 15;
        System.out.print("Final output "+ a.solution(data, 9));
    }
}