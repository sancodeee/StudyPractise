package com.ws.sort;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * 冒泡排序
 */
@Slf4j
public class BubbleSort {

    @Test
    public void test() {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("原始数组：");
        printArray(arr);
        // 冒泡排序
        bubbleSort(arr);

        System.out.println("\n排序后的数组：");
        printArray(arr);
    }

    /**
     * 冒泡排序
     *
     * @param arr 数组
     */
    public static void bubbleSort(int[] arr) {
        //数组长度
        int l = arr.length;
        //双指针循环
        for (int i = 0; i < l - 1; i++) {
            for (int j = 0; j < l - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // 交换 arr[j] 和 arr[j+1]
                    swap(arr, j, j + 1);
                }
            }
        }
    }


    /**
     * 交换
     *
     * @param arr 数组
     * @param i   索引i
     * @param j   索引j
     */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 打印数组
     *
     * @param arr 数组
     */
    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

}
