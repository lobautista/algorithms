package chapter4;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int [] list = {4, 2, 7, 1, 3};
        bubbleSort(list);
        System.out.println(Arrays.toString(list));
    }

    static void bubbleSort (int [] list) {
        boolean sorted = false;
        int lastIndex = list.length - 1;
        int temp;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < lastIndex; i ++) {
                if (list[i] > list [i + 1]) {
                    temp = list[i];
                    list[i] = list [i + 1];
                    list[i + 1] = temp;
                    sorted = false;
                }
            }
            lastIndex --;
        }

    }
}
