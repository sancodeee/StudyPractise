package com.ws.leetcode;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * 两数之和
 *
 * @author wangsen
 * @date 2024/05/04
 */
public class No01 {


    @Test
    public void test() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 9;
        // 方法结果验证
        int[] result = twoSum2(arr, target);
        for (int i : result) {
            System.out.println(i);
        }
    }

    /**
     * 暴力解法
     * 双指针遍历法，时间复杂度为 O(n²)
     *
     * @param nums   数组
     * @param target 目标值
     * @return {@link int[]} 返回数组下标结果
     */
    public int[] twoSum(int[] nums, int target) {
        // 结果
        int[] result = new int[2];

        // 双指针数组遍历
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    /**
     * 解法二：
     * 利用map暂存，避免重复遍历数组
     *
     * @param nums   数组
     * @param target 目标值
     * @return {@link int[]} 返回数组下标结果
     */
    public int[] twoSum2(int[] nums, int target) {
        // 缓存遍历的索引: k-数值，v-对应的数组索引
        HashMap<Integer, Integer> map = new HashMap<>();
        // 遍历数组
        for (int i = 0; i < nums.length; i++) {
            // 如果包含所需的值,则直接返回
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }


}
