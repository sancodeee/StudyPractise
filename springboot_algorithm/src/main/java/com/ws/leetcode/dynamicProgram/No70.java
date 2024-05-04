package com.ws.leetcode.dynamicProgram;

import org.junit.jupiter.api.Test;

/**
 * 动态规划问题：
 * <p>
 * 爬楼梯：
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * @author wangsen
 * @date 2024/05/04
 */
public class No70 {

    @Test
    public void test() {
        int i = climbStairs(10);
        System.out.println(i);
    }

    /**
     * 解法一
     * 时间复杂度为：O(n)
     *
     * @param n n阶楼梯
     * @return int 方法数
     */
    public int climbStairs(int n) {
        // 第一阶只有一种方法
        if (n == 1) {
            return 1;
        }
        // dp[i]表示爬到第i级台阶的方法数
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        // 通过迭代发现，爬到第 i 级台阶的方法数等于爬到第 i-1 级台阶的方法数，加上怕到第 i-2 级台阶的方法数
        // 通过数组记录每级台阶的方法数
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

}
