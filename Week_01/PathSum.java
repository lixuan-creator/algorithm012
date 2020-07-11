package com.algorithm.week01;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 路径求和
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * 说明: 叶子节点是指没有子节点的节点。
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 *
 * https://leetcode-cn.com/problems/path-sum/
 */
public class PathSum {

    @Test
    public void hasPathSumTest(){

        TreeNode root = getNewTreeNode();
        boolean flag = hasPathSum(root, 22);
        System.out.println(flag);


    }

    /**
     * 容易理解，巧妙，用队列存储sum和节点的数值
     * 这种解法令我挺意外，第一次读题完全懵了，完全没有思路，看了一遍图解后还是懵逼，自己又动手画图才发现挺好理解，思路也很清晰
     * 补充知识点Queue几种操作，看的英文文档，用谷歌翻译，中引文对比，也不是很难理解
     * 抛异常 add()、remove()、element()
     * 不抛异常 offer()、poll()、peek()
     * https://leetcode-cn.com/problems/path-sum/solution/lu-jing-zong-he-by-leetcode-solution/
     * 时间复杂度：O(N)，其中 N 是树的节点数。对每个节点访问一次。
     * 空间复杂度：O(N)，其中 N 是树的节点数。空间复杂度主要取决于队列的开销，队列中的元素个数不会超过树的节点数。
     */
    public boolean hasPathSum(TreeNode root, int sum) {

        if (root == null) {
            return false;
        }
        Queue<TreeNode> queNode = new LinkedList<TreeNode>();
        Queue<Integer> queVal = new LinkedList<Integer>();
        queNode.offer(root);
        queVal.offer(root.val);
        while (!queNode.isEmpty()) {
            TreeNode now = queNode.poll();
            int temp = queVal.poll();
            if (now.left == null && now.right == null) {
                if (temp == sum) {
                    return true;
                }
                continue;
            }
            if (now.left != null) {
                queNode.offer(now.left);
                queVal.offer(now.left.val + temp);
            }
            if (now.right != null) {
                queNode.offer(now.right);
                queVal.offer(now.right.val + temp);
            }
        }
        return false;
    }


    /**
     * 经典，已经无法用形容，见识了递归的巧妙，对空间复杂度的理解还不是很深，尤其是O(logN)
     * 链接：https://leetcode-cn.com/problems/path-sum/solution/lu-jing-zong-he-by-leetcode-solution/
     * 时间复杂度：O(N)，其中 N 是树的节点数。对每个节点访问一次。
     * 空间复杂度：O(H)，其中 H 是树的高度。空间复杂度主要取决于递归时栈空间的开销，最坏情况下，树呈现链状，
     * 空间复杂度为 O(N)。平均情况下树的高度与节点数的对数正相关，空间复杂度为 O(logN)。
     */
    public boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        return hasPathSum2(root.left, sum - root.val) || hasPathSum2(root.right, sum - root.val);
    }

    public TreeNode getNewTreeNode() {

        TreeNode tree5 = new TreeNode(5);
        TreeNode tree4 = new TreeNode(4);
        TreeNode tree8 = new TreeNode(8);
        TreeNode tree11 = new TreeNode(11);
        TreeNode tree13 = new TreeNode(13);
        TreeNode tree4_2 = new TreeNode(4);
        TreeNode tree7 = new TreeNode(7);
        TreeNode tree2 = new TreeNode(2);
        TreeNode tree1 = new TreeNode(1);

        tree5.left = tree4;
        tree5.right = tree8;

        tree4.left = tree11;

        tree8.left = tree13;
        tree8.right= tree4_2;

        tree11.left = tree7;
        tree11.right = tree2;

        tree4_2.right = tree1;

        return tree5;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
