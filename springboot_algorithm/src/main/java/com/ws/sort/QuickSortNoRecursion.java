package com.ws.sort;

import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * 快速排序，非递归
 *
 * @author wangsen_a
 * @date 2023/12/21
 */
public class QuickSortNoRecursion {

    @Test
    public void test() {



    }


    /**
     * 快速排序
     * 非递归方式
     *
     * @param arr 数组
     */
    public void quickSort(int[] arr) {
        // 非递归写法：通过栈模拟递归
        Stack<Integer> stack = new Stack<>();
        // 初始化栈，将整个数组的范围入栈，每个元素表示一对索引，即当前元素子数组的范围
        stack.push(0);
        stack.push(arr.length - 1);
        while (!stack.isEmpty()) {
            int high = stack.pop();
            int low = stack.pop();
            int partitionIndex = partition(arr, low, high);

            if (partitionIndex - 1 > low) {
                stack.push(low);
                stack.push(partitionIndex - 1);
            }

            if (partitionIndex + 1 < high) {
                stack.push(partitionIndex + 1);
                stack.push(high);
            }

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
     * 交换索引位置元素值
     *
     * @param arr 数组
     * @param a   a
     * @param b   b
     */
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


}
