package Arithmetic.Array;

public class Remove_Element {

    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int len = removeElement(nums, 2);
        System.out.println(len);
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
    }

    public static int removeElement(int[] nums, int val){
        int len = nums.length;
        if (len == 0)
            return 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == val){
                nums[i] = nums[len - 1];
                len--;
                i--;
            }
        }
        return len;
    }

    //双指针法
    public static int removeElement2(int[] nums, int val){
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val){
                nums[slow++] = nums[fast];
            }
        }

        return  slow;
    }
}
