package com.ws.dataStructures;

/**
 * 二叉树深度优先搜索
 *
 * @author wangsen
 * @date 2023/12/28
 */
public class DepthFirstSearch {

    public void test() {
        // 创建一个二叉树
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        dfs(root);
    }

    /**
     * dfs
     * 递归实现深度优先遍历
     *
     * @param node 节点
     */
    public static void dfs(TreeNode node) {
        if (node != null) {
            // 打印当前节点
            System.out.println(node.val);
            dfs(node.left);
            dfs(node.right);
        }
    }


}
