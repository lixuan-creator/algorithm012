package com.algorithm.week03;

/**
 * 最近公共祖先
 */

public class LowestCommonAncestor {

    private TreeNode anc;

    public LowestCommonAncestor() {
        this.anc = null;
    }


    public TreeNode solution(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return anc;
    }

    /**
     * 递归解法
     * x 节点包含 p、q
     * 成立条件一 lson && rson
     * 成立条件二 (x=p || x=q) && (lson || rson)
     * 所有节点访问一次，时间复杂度O(n)
     */
    public boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;

        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p , q);

        if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
            this.anc = root;
        }

        return lson || rson || (root.val == p.val || root.val == q.val);
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
