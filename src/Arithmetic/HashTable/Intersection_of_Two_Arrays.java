package Arithmetic.HashTable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.function.IntFunction;

public class Intersection_of_Two_Arrays {
    public static void main(String[] args) {
        int[] nums1 = {4,3,9,3,1,9,7,6,9,7};
        int[] nums2 = {5,0,8};
        System.out.println(intersection(nums1, nums2));
    }

    public static int[] intersection(int[] nums1, int[] nums2){
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0)
            return new int[0];
        Set<Integer> s = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            s.add(nums1[i]);
        }
        Set<Integer> list = new HashSet<>();

        for (int i = 0; i < nums2.length; i++) {
            if (s.contains(nums2[i]))
                list.add(nums2[i]);
        }
        if (list.size() == 0)
            return new int[1];
        Integer[] nums = list.stream().toArray(new IntFunction<Integer[]>() {
            @Override
            public Integer[] apply(int value) {
                return new Integer[value];
            }
        });
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[i];
        }
        return result;
    }
}
