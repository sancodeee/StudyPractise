package com.ws.sort;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

public class demo {

    @Test
    public void test() {
        Integer[] arr = {5, 2, 9, 1, 4, 5, 6};
        Arrays.sort(arr, new comparator());
        System.out.println(Arrays.toString(arr));
    }

    public void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }

    public int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    /**
     * 自定义比较器
     * 将数组偶数排在前面，奇数排在后面
     *
     * @author wangsen
     * @date 2023/12/24
     */
    static class comparator implements Comparator<Integer> {
        @Override
        public int compare(Integer a, Integer b) {
            if (a % 2 == 0 && b % 2 != 0) {
                // 返回负数表示第一个数小于第二个数
                return -1;
            }
            if (a % 2 != 0 && b % 2 == 0) {
                // 返回正数表示第一个数大于第二个数
                return 1;
            }
            return a.compareTo(b);
        }
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
