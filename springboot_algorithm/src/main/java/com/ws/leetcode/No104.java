package com.ws.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * 题目：给定一个二叉树 root ，返回其最大深度。
 *
 * @author wangsen_a
 * @date 2023/12/26
 */
@Slf4j
public class No104 {

    @Test
    public void test() {
        //1左移两位
        int i = 1 << 2;
        System.out.println(i);

    }

    /**
     * 最大深度
     *
     * @param root 根
     * @return int·
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }


}
