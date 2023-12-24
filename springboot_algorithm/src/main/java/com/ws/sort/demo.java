package com.ws.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class demo {

    @Test
    public void test() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> result = OddAndEven(list);
        System.out.println(result);

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


    public List<Integer> OddAndEven(List<Integer> list) {
        List<Integer> evenList = list.stream().filter(a -> a % 2 == 0).collect(Collectors.toList());
        List<Integer> oddList = list.stream().filter(a -> a % 2 == 1).collect(Collectors.toList());
        evenList.addAll(oddList);
        return evenList;
    }

}
