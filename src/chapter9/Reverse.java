package chapter9;

import java.util.Arrays;

public class Reverse {
    public static void rotate(int [] arr, int k) {
        int n = arr.length;
        k %= n;
        reverse(arr, 0, arr.length - 1);
        reverse(arr, 0, k -1);
        reverse(arr, k, n - 1);
    }

    private static void reverse(int [] arr, int left, int right) {
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left ++;
            right --;
        }
    }

    public static void main(String[] args) {
        int [] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        rotate(arr, 2);
        System.out.println(Arrays.toString(arr));
    }
}
