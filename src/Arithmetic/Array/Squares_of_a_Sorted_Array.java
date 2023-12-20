package Arithmetic.Array;

import java.util.Arrays;

public class Squares_of_a_Sorted_Array {
    public static void main(String[] args) {
        int[] nums = {-4,-1,0,3,10};
        System.out.println(Arrays.toString(sortedSquares2(nums)));
    }

    public static int[] sortedSquares(int[] nums) {

        if (nums.length <= 0)
            return null;
        while (nums[0] < 0){
            nums[0] = -nums[0];
            int k = nums[0];
            int i = 1;
            for (; i < nums.length; i++){
                if (nums[i] < k)
                    nums[i - 1] = nums[i];
                else break;
            }
            nums[i - 1] = k;
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        return  nums;
    }

    public static int[] sortedSquares2(int[] nums){
        if (nums.length <= 0)
            return nums;
        int[] result = new int[nums.length];
        for (int i = 0, j = nums.length - 1, index = 0; i <= j;){
            if (nums[i] * nums[i] > nums[j] * nums[j]) {
                result[index++] = nums[i] * nums[i];
                i++;
            } else {
                result[index++] = nums[j] * nums[j];
                j--;
            }
        }

        for (int i = 0, j = nums.length - 1; i <= j; i++, j--){
            int temp = result[i];
            result[i] = result[j];
            result[j] = temp;
        }

        return result;
    }
}
