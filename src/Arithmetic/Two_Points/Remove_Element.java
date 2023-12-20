package Arithmetic.Two_Points;

public class Remove_Element {
    public static void main(String[] args) {

    }

    public static int removeElement(int[] nums, int val) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1){
            if (nums[0] == val)
                return 0;
            else return 1;
        }
        int i = 0;
        int j = nums.length - 1;
        while (i < j){
            while (i < j && nums[i] != val)
                i++;
            while (i < j && nums[j] == val)
                j--;
            if (i < j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

        if (nums[i] == val)
            return i;
        return ++i;
    }
}
