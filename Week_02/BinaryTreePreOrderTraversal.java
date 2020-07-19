package com.algorithm.week02;

import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树前序遍历
 */

public class BinaryTreePreOrderTraversal {


    /**
     * 迭代
     * 顺序按照 Top->Bottom 和 Left->Right
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            // 从根节点开始，每次迭代弹出当前栈顶元素
            TreeNode node = stack.pollLast();
            output.add(node.val);
            // 将其孩子节点压入栈中，先压右孩子再压左孩子
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }
        return output;
    }


    /* Definition for a binary tree node. */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
