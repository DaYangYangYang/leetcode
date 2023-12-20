package Arithmetic.Array;

public class Minimum_Size_Subarray_Sum {
    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen2(7, nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int slow = 0;
        int fast = 0;
        int len = nums.length + 1;
        int sum = nums[slow];
        while (slow <= fast && fast < nums.length){
            while (sum < target && ++fast < nums.length){
                sum += nums[fast];
            }
            if (sum < target)
                continue;
            len = len > fast - slow + 1 ? fast - slow + 1 : len;
            sum -= nums[slow++];
        }

        return len > nums.length ? 0 : len;
    }

    public static int minSubArrayLen2(int target, int[] nums){
        int sum = 0;
        int len = nums.length + 1;
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++){
            sum += nums[fast];
            while (sum >= target && slow <= fast){
                sum -= nums[slow];
                len = Math.min(len, fast - slow++ + 1);
            }
        }
        return len > nums.length ? 0 : len;
    }
}
