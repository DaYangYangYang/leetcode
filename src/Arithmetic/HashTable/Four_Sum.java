package Arithmetic.HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Four_Sum {
    public static void main(String[] args) {
        System.out.println((long) ((long)-294967296 - (1000000000 + 1000000000)));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target){
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 4)
            return result;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                long sum = (long)target - ((long) nums[i] + nums[j]);
                int m = j + 1;
                int n = nums.length - 1;
                while (m < n){
                    if ((long) nums[m] + nums[n] == sum){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[m]);
                        list.add(nums[n]);
                        result.add(list);
                        m = move(nums, m, n);
                    }else if (nums[m] + nums[n] < sum){
                        m = move(nums, m, n);
                    }else{
                        int temp = nums[n];
                        while (m < n && nums[n] == temp)
                            n--;
                    }
                }
                j = move2(nums, j);
            }
            i = move2(nums, i);
        }

        return result;
    }

    public static int move(int[] nums, int m, int n){
        int temp = nums[m];
        while (m < n && nums[m] == temp)
            m++;
        return m;
    }

    public static int move2(int[] nums, int m){
        int temp = nums[m];
        while (m < nums.length && nums[m] == temp)
            m++;
        return m - 1;
    }
}
