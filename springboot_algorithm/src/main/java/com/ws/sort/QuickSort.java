package com.ws.sort;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class QuickSort {

    @Test
    public void test(){
        int[] arr = {3,4,5,2,1,9,8};
        quickSort(arr, 0, arr.length - 1);
        log.info("{}",arr);
    }

    public void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // 分区中间值
            int partition = partition(arr, low, high);
            quickSort(arr, low, partition - 1);
            quickSort(arr, partition + 1, high);
        }
    }

    public int partition(int[] arr, int low, int high) {
        // 取最右边的为基准值
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            // 如果左边值小于基准值，则不交换
            if (arr[j] < pivot) {
                i++;
                // i指针指向遍历的low的位置，相当于不交换
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    /**
     * 交换数组元素
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
