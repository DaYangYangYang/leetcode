package Arithmetic.Array;

public class Binary_Search {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        System.out.println(search(nums, 9));
    }


    public static int search(int[] nums, int target){
        int min = 0;
        int max = nums.length - 1;
        int mid;
        while(min <= max){
            mid = (max + min) / 2;
            if (nums[mid] < target)
                min = mid + 1;
            else if (nums[mid] > target)
                max = mid - 1;
            else return mid;
        }

        return -1;
    }


}
