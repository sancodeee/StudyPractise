package com.ws.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * no26
 * <p>
 * 题目：给你一个 非严格递增排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数。
 *
 * @author wangsen_a
 * @date 2024/01/15
 */
public class No26 {

    @Test
    public void test() {
        int[] nums = {2, 2, 3, 3, 3, 4};
        int i = removeDuplicates(nums);
        System.out.println(i);
    }

    /**
     * 删除重复元素
     *
     * @param nums nums
     * @return int
     */
    public int removeDuplicates(int[] nums) {
        int index = nums.length - 1;
        List<Integer> arr = new ArrayList<>();
        arr.add(nums[0]);
        // 从第二个元素开始遍历
        if (nums.length > 1) {
            for (int i = 1; i < nums.length; i++) {
                int num = nums[i];
                // 如果当前元素和上一个元素不同，则添加到新数组
                if (nums[i - 1] != num) {
                    System.out.println(num);
                    arr.add(num);
                }
            }
        }
        nums = arr.stream().mapToInt(Integer::intValue).toArray();
        System.out.println(nums.toString());
        return arr.size();
    }

}
