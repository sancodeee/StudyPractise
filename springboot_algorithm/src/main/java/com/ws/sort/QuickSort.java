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

    public static void quickSort(int[] arr , int low, int high){
        if(low < high){
            int partitionIndex = partition(arr, low, high);
            quickSort(arr, low, partitionIndex -1);
            quickSort(arr, partitionIndex+1, high);
        }
    }

    /**
     * 分区
     *
     * @param arr  数组
     * @param low  低
     * @param high 高
     * @return int
     */
    public static int partition(int[] arr, int low, int high) {
        //默认选择最右边的数作为 基准值
        int pivot = arr[high];
        int i = low - 1;
        //从最左边往右遍历 
        for (int j = low; j < high; j++) {
            //将小于等于基准值的元素放到基准值左边
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }


    /**
     * 交换数组两个索引位置的值
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
