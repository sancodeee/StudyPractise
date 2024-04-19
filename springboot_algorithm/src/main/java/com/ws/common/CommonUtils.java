package com.ws.common;

/**
 * 公共工具类
 *
 * @author wangsen_a
 * @date 2024/04/19
 */
public class CommonUtils {

    /**
     * 整型数组元素交换
     *
     * @param arr int数组
     * @param i   i
     * @param j   j
     */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }



}
