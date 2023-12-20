package Arithmetic.Stack_And_Queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.function.BiConsumer;

public class Top_K_Frequent_Elements {
    public static void main(String[] args) {
        int[] nums = {5,-3,9,1,7,7,9,10,2,2,10,10,3,-1,3,7,-9,-1,3,3};
        int[] res = topKFrequent(nums, 3);
        System.out.println(Arrays.toString(res));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Deque<Integer> que = new ArrayDeque<>();
        Deque<Integer> que2 = new ArrayDeque<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hm.containsKey(nums[i])){
                hm.put(nums[i], hm.get(nums[i]) + 1);
            }else{
                hm.put(nums[i], 1);
            }
        }

        hm.forEach(new BiConsumer<Integer, Integer>() {
            @Override
            public void accept(Integer integer, Integer integer2) {
                if (!que.isEmpty()){
                    while (!que.isEmpty() && hm.get(que.getLast()) > integer2){
                        que2.add(que.removeLast());
                    }
                    que.add(integer);
                    while (!que2.isEmpty()){
                        que.add(que2.removeLast());
                    }
                }else que.add(integer);

                if (que.size() > k)
                    que.remove();
            }
        });
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = que.remove();
        }
        return res;
    }
}
