package chapter6;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int [] nums = {4, 2, 7, 1, 3};
        insertionSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    static void insertionSort (int [] nums) {
        for (int i = 1; i < nums.length; i ++) {
            int temp = nums[i];
            int position = i - 1;
            while (position >= 0) {
                if (nums[position] > temp) {
                    nums[position + 1] = nums[position];
                    position --;
                } else {
                    break;
                }
                nums[position + 1] = temp;
            }
        }
    }
}
