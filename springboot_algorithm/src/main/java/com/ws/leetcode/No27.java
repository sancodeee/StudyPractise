package com.ws.leetcode;

import com.ws.common.CommonUtils;
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
        int[] nums = {3, 2, 2, 3, 3, 3};
        int val = 3;
        int i = removeElement1(nums, val);
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
        // 双指针遍历
        int j = nums.length - 1;
        for (int i = 0; i < j; i++) {
            if (nums[i] == val) {
                // 将等于val的元素移动到数组末尾
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
                // 如果元素不是val，则移动到数组前边
                nums[i++] = x;
            }
        }
        return i;
    }

    /**
     * 交换数组元素
     *
     * @param nums 数组
     * @param i    i
     * @param j    j
     */
    void swap(int[] nums, int i, int j) {
        CommonUtils.swap(nums, i, j);
    }
}
