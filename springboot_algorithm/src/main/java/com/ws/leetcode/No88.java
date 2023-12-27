package com.ws.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * no88
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 *
 * @author wangsen
 * @date 2023/12/26
 */
public class No88 {

    @Test
    public void test() {
        int[] nums1 = {1, 3, 5, 5, 6, 0, 0, 0, 0};
        int[] nums2 = {2, 4, 6, 8};
        merge1(nums1, 5, nums2, 4);
        System.out.println(Arrays.toString(nums1));
    }


    /**
     * 方法一
     * 采用先合并再排序的思路
     *
     * @param nums1 nums1
     * @param m     m
     * @param nums2 nums2
     * @param n     n
     */
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        //通过java自带的方法对合并后的数组排序即可
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }

    /**
     * 方法二：三指针归并
     *
     * @param nums1 nums1
     * @param m     m
     * @param nums2 nums2
     * @param n     n
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int k = m + n;
        int[] anthorNums = new int[k];
        for (int i = 0, nums1Index = 0, nums2Index = 0; i < k; i++) {

        }
    }

    /**
     * 方法三：先合并再排序
     *
     * @param nums1 nums1
     * @param m     m
     * @param nums2 nums2
     * @param n     n
     * @return {@link int[]}
     */
    public int[] merge3(int[] nums1, int m, int[] nums2, int n) {
        // 合并数组
        int[] mergedNums = new int[m + n];
        System.arraycopy(nums1, 0, mergedNums, 0, m);
        System.arraycopy(nums2, 0, mergedNums, m, n);
        // 正序排序
        Arrays.sort(mergedNums);
        // 反转数组
        reversalNums(mergedNums);
        return mergedNums;
    }

    /**
     * 反转数组
     *
     * @param arr 数组
     */
    public void reversalNums(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

}
