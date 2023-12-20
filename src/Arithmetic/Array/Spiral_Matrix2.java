package Arithmetic.Array;

public class Spiral_Matrix2 {
    public static void main(String[] args) {
        int[][] nums = generateMatrix(6);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                System.out.print(nums[i][j]);
            }
            System.out.println();
        }
    }

    public static int[][] generateMatrix(int n) {
        int[][] nums = new int[n][n];
        int s = 0;
        int e = 0;
        while (n > 0){
            int end = nums.length - (nums.length - n) / 2;
            int i = s;
            int j = e;
            for (; e < end; e++){
                if (s == 0 && e == 0){
                    nums[s][e] = 1;
                }
                else nums[s][e] = nums[s][e - 1] + 1;
            }
            e--;
            for (s = s + 1; s < end; s++){
                nums[s][e] = nums[s - 1][e] + 1;
            }
            s--;
            e--;
            for (; e >= j; e--){
                nums[s][e] = nums[s][e + 1] + 1;
            }

            e++;
            s--;
            for (; s > i; s--){
                nums[s][e] = nums[s + 1][e] + 1;
            }
            s++;

            e++;

            n = n - 2;
        }

        return nums;
    }
}
