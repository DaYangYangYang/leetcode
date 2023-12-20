package Arithmetic.HashTable;

import java.math.BigInteger;
import java.util.*;

public class Three_Sum {
    public static void main(String[] args) {
    }

    public static List<List<Integer>> threeSum(int[] nums){
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])){
                List<Integer> list = map.get(nums[i]);
                list.add(i);
                map.put(nums[i], list);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(nums[i], list);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = -(nums[i] + nums[j]);
                if (map.containsKey(sum)){
                    List<Integer> list = map.get(sum);
                    for (int k = 0; k < list.size(); k++) {
                        if (list.get(k) > j){
                            List<Integer> o = new ArrayList<>();
                            o.add(nums[i]);
                            o.add(nums[j]);
                            o.add(sum);
                            o.sort(new Comparator<Integer>() {
                                @Override
                                public int compare(Integer o1, Integer o2) {
                                    return o1 - o2;
                                }
                            });
                            if (conpete(result, o))
                                result.add(o);
                        }
                    }
                }
            }
        }
        return result;
    }

    public static boolean conpete(List<List<Integer>> result, List<Integer> o){
        for (int i = 0; i < result.size(); i++) {
            List<Integer> list = result.get(i);
            int a = list.get(0);
            int b = list.get(1);
            int c = list.get(2);
            int d = o.get(0);
            int e = o.get(1);
            int f = o.get(2);
            if (a == d && b == e && c == f)
                return false;
        }
        return true;
    }

    public static List<List<Integer>> threeSum2(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int sum = -nums[i];
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k){
                if (nums[j] + nums[k] == sum){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    result.add(list);
                    int temp = nums[j];
                    while (j < k && nums[j] == temp)
                        j++;
                }else if (nums[j] + nums[k] > sum)
                    k--;
                else j++;
            }
            int temp = nums[i];
            while (i < nums.length && nums[i] == temp)
                i++;
            i--;
        }
        return result;
    }
}
