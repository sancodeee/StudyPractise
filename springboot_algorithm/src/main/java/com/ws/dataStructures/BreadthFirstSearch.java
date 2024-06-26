package com.ws.dataStructures;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 广度优先搜索
 *
 * @author wangsen
 * @date 2023/12/28
 */
public class BreadthFirstSearch {

    @Test
    public void test() {
        // 创建一个二叉树
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        // 广度优先遍历测试
        bfs(root);
    }

    /**
     * BFS
     * <p>广度优先遍历
     *
     * @param root 根
     */
    public static void bfs(TreeNode root) {
        if (root == null) {
            return;
        }
        // 利用队列做二叉树的广度优先遍历
        Queue<TreeNode> queue = new LinkedList<>();
        // 根节点加入队列
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 出队列
            TreeNode current = queue.poll();
            System.out.println(current.val);
            if (current.left != null) {
                // 左孩子节点加入队列
                queue.offer(current.left);
            }
            if (current.right != null) {
                // 右孩子节点加入队列
                queue.offer(current.right);
            }
        }
    }


}
