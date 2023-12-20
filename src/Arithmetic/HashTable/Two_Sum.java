package Arithmetic.HashTable;

import java.util.Arrays;
import java.util.HashMap;

public class Two_Sum {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        System.out.println(Arrays.toString(twoSum(nums, 9)));
    }

    public static int[] twoSum(int[] nums, int target){
        if (nums.length < 2)
            return new int[0];

        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hm.containsKey(nums[i])){
                hm.put(nums[i], hm.get(nums[i]) + 1);
            }else{
                hm.put(nums[i], 1);
            }
        }
        int val = 0;
        int i = 0;
        for (i = 0; i < nums.length; i++) {
            val = target - nums[i];
            if (hm.containsKey(val)){
                if (val == nums[i] && hm.get(val) >= 2)
                    break;
                if (val != nums[i])
                    break;
            }
        }
        if (i >= nums.length)
            return new int[0];
        int j = 0;
        for (j = 0; j < nums.length; j++) {
            if (nums[j] == val && i != j)
                break;
        }
        return new int[]{i, j};
    }
}
