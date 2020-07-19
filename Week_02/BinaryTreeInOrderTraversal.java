package com.algorithm.week02;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树中序遍历
 */

public class BinaryTreeInOrderTraversal {


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root,res);
        return res;
    }

    // 核心代码
    public  List<Integer> helper(TreeNode root, List<Integer> res){
        if (root.left != null) {
            helper(root.left, res);
        }
        res.add(root.val);
        if (root.right != null) {
            helper(root.right, res);
        }
        return res;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
