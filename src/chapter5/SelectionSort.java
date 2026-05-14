package chapter5;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int [] nums = {4, 2, 7, 1, 3};
        selectionSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    static void selectionSort(int [] nums) {
        for (int i = 0; i < nums.length; i ++) {
            int lowestNumberIndex = i;
            for (int j = i + 1; j < nums.length; j ++) {
                if (nums[j] < nums[lowestNumberIndex]) {
                    lowestNumberIndex = j;
                }
            }

            if (lowestNumberIndex != i) {
                int temp = nums[i];
                nums[i] = nums[lowestNumberIndex];
                nums[lowestNumberIndex] = temp;
            }
        }
    }
}
