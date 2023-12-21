package com.ws.sort;


import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class demo {

    @Test
    public void test() {
        int[] arr = {5, 2, 9, 1, 5, 6};

        System.out.println(Arrays.toString(arr));
    }


    public int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (j < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    /**
     * 交换数组索引位置的元素
     *
     * @param arr 数组
     * @param i   i
     * @param j   j
     */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
