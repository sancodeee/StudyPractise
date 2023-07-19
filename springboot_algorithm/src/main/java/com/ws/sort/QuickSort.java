package com.ws.sort;

import org.junit.jupiter.api.Test;

public class QuickSort {

    @Test
    public void test(){
        int[] arr = {3,4,5,2,1,9,8};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(arr);
    }

    public static void quickSort(int[] arr , int low, int high){
        if(low < high){
            int partitionIndex = partition(arr, low, high);
            quickSort(arr, low, partitionIndex -1);
            quickSort(arr, partitionIndex+1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        //默认选择最右边的数作为 基准值
        int pivot = arr[high];
        int i = low - 1;

        //从最左边往右遍历 
        for (int j = i; j < high; j++) {
            //将小于等于基准值的元素放到基准值左边
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    //swap
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
