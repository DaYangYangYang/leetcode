package Arithmetic.HashTable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

public class Four_Sum2 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {-1, -2};
        int[] nums3 = {-1, 2};
        int[] nums4 = {0, 2};
        fourSumCount3(nums1, nums2, nums3, nums4);
    }

    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums4.length; i++) {
            if (map.containsKey(nums4[i]))
                map.put(nums4[i], map.get(nums4[i]) + 1);
            else map.put(nums4[i], 1);
        }
        int result = 0;
        for (int i : nums1) {
            for (int j : nums2) {
                for (int k : nums3) {
                    int sum = i + j + k;
                    if (map.containsKey(-sum)){
                        result += map.get(-sum);
                    }
                }
            }
        }

        return result;
    }
    public static int fourSumCount2(int[] nums1, int[] nums2, int[] nums3, int[] nums4){
        int result = 0;
        for (int i : nums1) {
            for (int j : nums2) {
                for (int k : nums3) {
                    for (int q : nums4) {
                        if (i + j + k + q == 0)
                            result++;
                    }
                }
            }
        }
        return result;
    }

    public static int fourSumCount3(int[] nums1, int[] nums2, int[] nums3, int[] nums4){
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int i : nums1) {
            for (int j : nums2) {
                int sum = i + j;
                if (map1.containsKey(sum)){
                    map1.put(sum, map1.get(sum) + 1);
                }
                else map1.put(sum, 1);
            }
        }
        for (int i : nums3) {
            for (int j : nums4) {
                int sum = i + j;
                if (map2.containsKey(sum)){
                    map2.put(sum, map2.get(sum) + 1);
                }
                else map2.put(sum, 1);
            }
        }
        int result = 0;
        Set<Map.Entry<Integer, Integer>> entries = map1.entrySet();
        Set<Map.Entry<Integer, Integer>> entries1 = map2.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            for (Map.Entry<Integer, Integer> entry1 : entries1) {
                if (entry.getKey() + entry1.getKey() == 0)
                    result += (entry.getValue() * entry1.getValue());
            }
        }
        return result;
    }
}
