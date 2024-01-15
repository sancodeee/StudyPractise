package com.ws.leetcode;

import org.junit.jupiter.api.Test;

/**
 * no80：删除有序数组中的重复项2
 * <p>
 * 题目：给你一个有序数组 nums ，请你原地删除重复出现的元素，使得出现次数超过两次的元素只出现两次，返回删除后数组的新长度。
 *
 * @author wangsen_a
 * @date 2024/01/15
 */
public class No80 {

    @Test
    public void test() {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int i = removeDuplicates(nums);
        System.out.println(i);
    }

    public int removeDuplicates(int[] nums) {
        int left = 1;
        for (int right = 2; right < nums.length; right++) {
            if (nums[right] != nums[left - 1]) {
                nums[++left] = nums[right];
            }
        }
        printArr(nums);
        return left + 1;
    }

    /**
     * 打印数组
     *
     * @param nums nums
     */
    public void printArr(int[] nums) {
        for (int num : nums) {
            System.out.println(num);
        }
    }


}
