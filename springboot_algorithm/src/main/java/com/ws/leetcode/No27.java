package com.ws.leetcode;

import org.junit.jupiter.api.Test;

/**
 * no27
 * <p>
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * <p>
 * 注意：题目要求nums数组必须移除掉和val相同的值才行。
 *
 * @author wangsen
 * @date 2023/12/26
 */
public class No27 {

    @Test
    public void test() {
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        int i = removeElement1(nums, 3);
        System.out.println(i);
    }

    /**
     * 方法一
     *
     * @param nums nums
     * @param val  val
     * @return int
     */
    public int removeElement1(int[] nums, int val) {
        int j = nums.length - 1;
        for (int i = 0; i < j; i++) {
            if (nums[i] == val) {
                swap(nums, i--, j--);
            }
        }
        return j + 1;
    }

    /**
     * 方法二
     *
     * @param nums nums
     * @param val  val
     * @return int
     */
    public int removeElement2(int[] nums, int val) {
        int i = 0;
        for (int x : nums) {
            if (x != val) {
                nums[i++] = x;
            }
        }
        return i;
    }

    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
