package com.ws.leetcode;

import java.util.Arrays;

/**
 * 动态规划经典问题--最长递增子序列
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4。
 */
public class No300 {

    public int lengthOfLIS(int[] nums) {
        //数组长度(元素个数)
        int n = nums.length;
        // 用于存储已经计算过的子问题的解
        int[] memory= new int[n];
        // 初始化为-1表示尚未计算过
        Arrays.fill(memory, -1);
        //记录最大子序列长度
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            maxLength = Math.max(maxLength, findLIS(nums, i, memory));
        }

        return maxLength;
    }

    // 递归函数，用于找出以第index位置元素为结尾的最长递增子序列长度
    private int findLIS(int[] nums, int index, int[] memory) {
        // 如果已经计算过，直接返回结果
        if (memory[index] != -1) {
            return memory[index];
        }
        //如果没有计算过 就开始比较
        int maxLength = 1;
        for (int i = 0; i < index; i++) {
            if (nums[i] < nums[index]) {
                maxLength = Math.max(maxLength, 1 + findLIS(nums, i, memory));
            }
        }
        // 将计算结果保存到memo数组中
        memory[index] = maxLength;
        return maxLength;
    }

}
