package Arithmetic.Stack_And_Queue;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;


public class Sliding_Window_Maximum {
    public static void main(String[] args) {
        int[] nums = {9,10,9,-7,-4,-8,2,-6};
        int[] res = maxSlidingWindow2(nums, 3);
        System.out.println(Arrays.toString(res));
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> que1 = new LinkedBlockingDeque<>();
        Queue<Integer> que2 = new LinkedBlockingDeque<>();
        for (int i = 0; i < nums.length; i++) {
            int number = nums[i];
            while (!que1.isEmpty() && que1.peek() < number)
                que1.remove();
            que1.add(number);
            if ((i + 1) >= k) {
                list.add(que1.peek());
            }
            if (que1.size() == k) {
                que1.remove();
                while (!que1.isEmpty()){
                    Integer re = que1.remove();
                    while (!que2.isEmpty() && que2.peek() < re)
                        que2.remove();
                    que2.add(re);
                }
                Queue<Integer> que = que1;
                que1 = que2;
                que2 = que;
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static int[] maxSlidingWindow2(int[] nums, int k){
        Deque<Integer> que = new ArrayDeque<>();
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!que.isEmpty() && nums[que.getLast()] < nums[i]){
                que.removeLast();
            }
            que.add(i);
            if (i >= k - 1){
                res[index++] = nums[que.getFirst()];
            }
            if (!que.isEmpty() && (i - que.getFirst() + 1) == k){
                que.remove();
            }
        }
        return res;
    }
}
